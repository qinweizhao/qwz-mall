package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsCategoryBrandRelation;

import java.util.List;

/**
 * 分类&品牌关联Service接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface IPmsCategoryBrandRelationService {
    /**
     * 查询分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 分类&品牌关联
     */
    public PmsCategoryBrandRelation selectPmsCategoryBrandRelationById(Long id);

    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrandRelation 分类&品牌关联
     * @return 分类&品牌关联集合
     */
    public List<PmsCategoryBrandRelation> selectPmsCategoryBrandRelationList(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrandRelation 分类&品牌关联
     * @return 结果
     */
    public int insertPmsCategoryBrandRelation(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /**
     * 修改分类&品牌关联
     *
     * @param pmsCategoryBrandRelation 分类&品牌关联
     * @return 结果
     */
    public int updatePmsCategoryBrandRelation(PmsCategoryBrandRelation pmsCategoryBrandRelation);

    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的分类&品牌关联主键集合
     * @return 结果
     */
    public int deletePmsCategoryBrandRelationByIds(Long[] ids);

    /**
     * 删除分类&品牌关联信息
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    public int deletePmsCategoryBrandRelationById(Long id);
}
