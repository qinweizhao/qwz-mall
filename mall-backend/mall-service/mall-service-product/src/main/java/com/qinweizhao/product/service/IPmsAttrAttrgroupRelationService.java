package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsAttrAttrgroupRelation;

import java.util.List;

/**
 * 属性&属性分组关联Service接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface IPmsAttrAttrgroupRelationService {
    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    PmsAttrAttrgroupRelation selectPmsAttrAttrgroupRelationById(Long id);

    /**
     * 查询属性&属性分组关联列表
     *
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<PmsAttrAttrgroupRelation> selectPmsAttrAttrgroupRelationList(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 新增属性&属性分组关联
     *
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    int insertPmsAttrAttrgroupRelation(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 修改属性&属性分组关联
     *
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    int updatePmsAttrAttrgroupRelation(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation);

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键集合
     * @return 结果
     */
    int deletePmsAttrAttrgroupRelationByIds(Long[] ids);

    /**
     * 删除属性&属性分组关联信息
     *
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    int deletePmsAttrAttrgroupRelationById(Long id);
}
