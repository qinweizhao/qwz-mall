package com.qinweizhao.system.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qinweizhao.system.converter.DictTypeConverter;
import com.qinweizhao.system.mapper.SysDictTypeMapper;
import com.qinweizhao.system.pojo.entity.SysDictItem;
import com.qinweizhao.system.pojo.entity.SysDictType;
import com.qinweizhao.system.pojo.form.DictTypeForm;
import com.qinweizhao.system.pojo.query.DictTypePageQuery;
import com.qinweizhao.system.pojo.vo.dict.DictTypePageVO;
import com.qinweizhao.system.service.SysDictItemService;
import com.qinweizhao.system.service.SysDictTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典类型业务实现类
 *
 * @author haoxr
 * @date 2022/6/9
 */
@Service
@RequiredArgsConstructor
public class SysDictTypeTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {

    private final SysDictItemService dictItemService;
    private final DictTypeConverter dictTypeConverter;

    /**
     * 字典分页列表
     *
     * @param queryParams 分页查询对象
     * @return
     */
    @Override
    public Page<DictTypePageVO> listDictTypePages(DictTypePageQuery queryParams) {
        // 查询参数
        int pageNum = queryParams.getPageNum();
        int pageSize = queryParams.getPageSize();
        String keywords = queryParams.getKeywords();

        // 查询数据
        Page<SysDictType> dictTypePage = this.page(
                new Page<>(pageNum, pageSize),
                new LambdaQueryWrapper<SysDictType>()
                        .like(StrUtil.isNotBlank(keywords), SysDictType::getName, keywords)
                        .or()
                        .like(StrUtil.isNotBlank(keywords), SysDictType::getCode, keywords)
                        .select(SysDictType::getId, SysDictType::getName, SysDictType::getCode, SysDictType::getStatus)
        );

        // 实体转换
        Page<DictTypePageVO> pageResult = dictTypeConverter.entity2Page(dictTypePage);
        return pageResult;
    }

    /**
     * 获取字典类型表单详情
     *
     * @param id 字典类型ID
     * @return
     */
    @Override
    public DictTypeForm getDictTypeFormData(Long id) {
        // 获取entity
        SysDictType entity = this.getOne(new LambdaQueryWrapper<SysDictType>()
                .eq(SysDictType::getId, id)
                .select(
                        SysDictType::getId,
                        SysDictType::getName,
                        SysDictType::getCode,
                        SysDictType::getStatus,
                        SysDictType::getRemark
                ));
        Assert.isTrue(entity != null, "字典类型不存在");

        // 实体转换
        DictTypeForm dictTypeForm = dictTypeConverter.entity2Form(entity);
        return dictTypeForm;
    }

    /**
     * 新增字典类型
     *
     * @param dictTypeForm
     * @return
     */
    @Override
    public boolean saveDictType(DictTypeForm dictTypeForm) {
        // 实体对象转换 form->entity
        SysDictType entity = dictTypeConverter.form2Entity(dictTypeForm);
        // 持久化
        boolean result = this.save(entity);
        return result;
    }


    /**
     * 修改字典类型
     *
     * @param id           字典类型ID
     * @param dictTypeForm 字典类型表单
     * @return
     */
    @Override
    public boolean updateDictType(Long id, DictTypeForm dictTypeForm) {
        // 获取字典类型
        SysDictType sysDictType = this.getById(id);
        Assert.isTrue(sysDictType != null, "字典类型不存在");

        SysDictType entity = dictTypeConverter.form2Entity(dictTypeForm);
        boolean result = this.updateById(entity);
        if (result) {
            // 字典类型code变化，同步修改字典项的类型code
            String oldCode = sysDictType.getCode();
            String newCode = dictTypeForm.getCode();
            if (!StrUtil.equals(oldCode, newCode)) {
                dictItemService.update(new LambdaUpdateWrapper<SysDictItem>()
                        .eq(SysDictItem::getTypeCode, oldCode)
                        .set(SysDictItem::getTypeCode, newCode)
                );
            }
        }
        return result;
    }

    /**
     * 删除字典类型
     *
     * @param idsStr 字典类型ID，多个以英文逗号(,)分割
     * @return
     */
    @Override
    @Transactional
    public boolean deleteDictTypes(String idsStr) {

        Assert.isTrue(StrUtil.isNotBlank(idsStr), "删除数据为空");
        //
        List<Long> ids = Arrays.asList(idsStr.split(","))
                .stream()
                .map(id -> Long.parseLong(id))
                .collect(Collectors.toList());

        // 删除字典项
        List<String> dictTypeCodes = this.list(new LambdaQueryWrapper<SysDictType>()
                        .in(SysDictType::getId, ids)
                        .select(SysDictType::getCode))
                .stream().map(dictType -> dictType.getCode())
                .collect(Collectors.toList()
                );
        if (CollectionUtil.isNotEmpty(dictTypeCodes)) {
            dictItemService.remove(new LambdaQueryWrapper<SysDictItem>().in(SysDictItem::getTypeCode, dictTypeCodes));
        }
        // 删除字典类型
        boolean result = this.removeByIds(ids);
        return result;
    }
}
