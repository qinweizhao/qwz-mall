package com.qinweizhao.product.service;

import com.qinweizhao.product.entity.PmsAttrAttrGroup;

import java.util.List;

/**
 * 属性&属性分组关联Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsAttrAttrGroupService {
    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    PmsAttrAttrGroup selectPmsAttrAttrGroupById(Long id);

    /**
     * 查询属性&属性分组关联列表
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<PmsAttrAttrGroup> selectPmsAttrAttrGroupList(PmsAttrAttrGroup pmsAttrAttrGroup);

    /**
     * 新增属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    int insertPmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup);

    /**
     * 修改属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    int updatePmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup);

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键集合
     * @return 结果
     */
    int deletePmsAttrAttrGroupByIds(Long[] ids);

    /**
     * 删除属性&属性分组关联信息
     *
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    int deletePmsAttrAttrGroupById(Long id);
}
