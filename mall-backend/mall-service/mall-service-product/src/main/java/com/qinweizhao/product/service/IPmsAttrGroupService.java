package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsAttrGroup;

import java.util.List;

/**
 * 属性分组Service接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface IPmsAttrGroupService {
    /**
     * 查询属性分组
     *
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    PmsAttrGroup selectPmsAttrGroupByAttrGroupId(Long attrGroupId);

    /**
     * 查询属性分组列表
     *
     * @param pmsAttrGroup 属性分组
     * @return 属性分组集合
     */
    List<PmsAttrGroup> selectPmsAttrGroupList(PmsAttrGroup pmsAttrGroup);

    /**
     * 新增属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    int insertPmsAttrGroup(PmsAttrGroup pmsAttrGroup);

    /**
     * 修改属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    int updatePmsAttrGroup(PmsAttrGroup pmsAttrGroup);

    /**
     * 批量删除属性分组
     *
     * @param attrGroupIds 需要删除的属性分组主键集合
     * @return 结果
     */
    int deletePmsAttrGroupByAttrGroupIds(Long[] attrGroupIds);

    /**
     * 删除属性分组信息
     *
     * @param attrGroupId 属性分组主键
     * @return 结果
     */
    int deletePmsAttrGroupByAttrGroupId(Long attrGroupId);
}
