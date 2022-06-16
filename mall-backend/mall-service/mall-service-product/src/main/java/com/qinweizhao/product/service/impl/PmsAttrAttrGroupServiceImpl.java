package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.core.utils.bean.BeanUtils;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.product.constant.ProductConstant;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.entity.PmsAttrAttrGroup;
import com.qinweizhao.product.model.entity.PmsAttrGroup;
import com.qinweizhao.product.model.param.AttrAttrGroupSaveBatchParam;
import com.qinweizhao.product.mapper.PmsAttrAttrGroupMapper;
import com.qinweizhao.product.mapper.PmsAttrGroupMapper;
import com.qinweizhao.product.mapper.PmsAttrMapper;
import com.qinweizhao.product.service.IPmsAttrAttrGroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性&属性分组关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsAttrAttrGroupServiceImpl implements IPmsAttrAttrGroupService {


    @Resource
    private PmsAttrAttrGroupMapper pmsAttrAttrGroupMapper;

    @Resource
    private PmsAttrGroupMapper pmsAttrGroupMapper;

    @Resource
    private PmsAttrMapper pmsAttrMapper;

    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    @Override
    public PmsAttrAttrGroup selectPmsAttrAttrGroupById(Long id) {
        return pmsAttrAttrGroupMapper.selectPmsAttrAttrGroupById(id);
    }

    /**
     * 查询属性&属性分组关联列表
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 属性&属性分组关联
     */
    @Override
    public List<PmsAttrAttrGroup> selectPmsAttrAttrGroupList(PmsAttrAttrGroup pmsAttrAttrGroup) {
        return pmsAttrAttrGroupMapper.selectPmsAttrAttrGroupList(pmsAttrAttrGroup);
    }

    /**
     * 新增属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int insertPmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup) {
        pmsAttrAttrGroup.setCreateTime(DateUtils.getNowDate());
        return pmsAttrAttrGroupMapper.insertPmsAttrAttrGroup(pmsAttrAttrGroup);
    }

    /**
     * 修改属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int updatePmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup) {
        pmsAttrAttrGroup.setUpdateTime(DateUtils.getNowDate());
        return pmsAttrAttrGroupMapper.updatePmsAttrAttrGroup(pmsAttrAttrGroup);
    }

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrAttrGroupByIds(Long[] ids) {
        return pmsAttrAttrGroupMapper.deletePmsAttrAttrGroupByIds(ids);
    }

    /**
     * 删除属性&属性分组关联信息
     *
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrAttrGroupById(Long id) {
        return pmsAttrAttrGroupMapper.deletePmsAttrAttrGroupById(id);
    }

    @Override
    public List<PmsAttr> listUnRelationByAttrGroupId(Long attrGroupId) {
        // 1、当前分组只能关联自己所属的分类里面的所有属性
        PmsAttrGroup pmsAttrGroup = pmsAttrGroupMapper.selectPmsAttrGroupByAttrGroupId(attrGroupId);
        Long categoryId = pmsAttrGroup.getCategoryId();
        // 2、当前分组只能关联别的分组没有引用的属性
        // 2.1)、当前分类下的其他分组+当前分组
        List<Long> ids = pmsAttrGroupMapper.selectAttrGroupIdsByCategoryId(categoryId);

        // 2.2)、这些分组关联的属性
        List<Long> excludeAttrIds = pmsAttrMapper.selectIdsByAttrGroupIds(ids);

        // 2.3)、从当前分类的所有属性(基本属性)中移除这些属性
        return pmsAttrMapper.selectPmsAttrsByCategoryId(categoryId, ProductConstant.AttrEnum.ATTR_TYPE_BASE.getCode(), excludeAttrIds);
    }


    @Override
    public int insertPmsAttrAttrGroups(AttrAttrGroupSaveBatchParam pmsAttrAttrGroupSaveBatch) {
        String ids = pmsAttrAttrGroupSaveBatch.getAttrIds();
        String[] attrIds = ids.split(",");
        List<PmsAttrAttrGroup> list = Arrays.stream(attrIds).map(item -> {
            PmsAttrAttrGroup attrAttrGroup = new PmsAttrAttrGroup();
            BeanUtils.copyProperties(pmsAttrAttrGroupSaveBatch, attrAttrGroup);
            attrAttrGroup.setAttrId(Long.parseLong(item));
            attrAttrGroup.setCreateTime(new Date());
            attrAttrGroup.setRemark("");
            attrAttrGroup.setCreateBy(SecurityUtils.getUsername());
            return attrAttrGroup;
        }).collect(Collectors.toList());
        return pmsAttrAttrGroupMapper.insertPmsAttrAttrGroups(list);
    }

    @Override
    public PmsAttrAttrGroup selectByAttrId(Long attrId) {
        return pmsAttrAttrGroupMapper.selectByAttrId(attrId);
    }
}
