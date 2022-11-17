package com.qinweizhao.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.pojo.entity.SysDictItem;
import com.qinweizhao.system.pojo.form.DictItemForm;
import com.qinweizhao.system.pojo.query.DictItemPageQuery;
import com.qinweizhao.system.pojo.vo.dict.DictItemPageVO;
import com.qinweizhao.system.pojo.Option;

import java.util.List;


/**
 * 字典数据项业务接口层
 *
 * @author haoxr
 * @date 2022/6/9
 */
public interface SysDictItemService extends IService<SysDictItem> {

    /**
     * 字典数据项分页列表
     *
     * @param queryParams
     * @return
     */
    Page<DictItemPageVO> listDictItemPages(DictItemPageQuery queryParams);

    /**
     * 字典数据项表单详情
     *
     * @param id 字典数据项ID
     * @return
     */
    DictItemForm getDictItemFormData(Long id);

    /**
     * 新增字典数据项
     *
     * @param dictItemForm 字典数据项表单
     * @return
     */
    boolean saveDictItem(DictItemForm dictItemForm);

    /**
     * 修改字典数据项
     *
     * @param id           字典数据项ID
     * @param dictItemForm 字典数据项表单
     * @return
     */
    boolean updateDictItem(Long id, DictItemForm dictItemForm);

    /**
     * 删除字典数据项
     *
     * @param idsStr 字典数据项ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteDictItems(String idsStr);

    /**
     * 根据字典类型编码获取字典数据项
     *
     * @param typeCode 字典类型编码
     * @return
     */
    List<Option> listDictItemsByTypeCode(String typeCode);
}
