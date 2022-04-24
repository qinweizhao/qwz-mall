package com.qinweizhao.product.service;

import com.qinweizhao.product.entity.PmsCategoryBrand;

import java.util.List;


/**
 * 分类&品牌关联Service接口
 *
 * @author qinweizhao
 * @date 2022-04-24
 */
public interface IPmsCategoryBrandService {
    /**
     * 查询分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 分类&品牌关联
     */
    PmsCategoryBrand selectPmsCategoryBrandById(Long id);

    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 分类&品牌关联集合
     */
    List<PmsCategoryBrand> selectPmsCategoryBrandList(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    int insertPmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 修改分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    int updatePmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的分类&品牌关联主键集合
     * @return 结果
     */
    int deletePmsCategoryBrandByIds(Long[] ids);

    /**
     * 删除分类&品牌关联信息
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    int deletePmsCategoryBrandById(Long id);

    /**
     * 查询分类和品牌的关联信息
     *
     * @param brandId brandId
     * @return List<PmsCategoryBrand>
     */
    List<PmsCategoryBrand> selectPmsCategoryBrandByBrandId(Long brandId);
}
