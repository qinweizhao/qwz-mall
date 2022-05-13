package com.qinweizhao.product.service;

import com.qinweizhao.product.model.entity.PmsCategoryBrand;

import java.util.List;


/**
 * 分类&品牌关联Service接口
 *
 * @author qinweizhao
 * @date 2022-04-24
 */
public interface IPmsCategoryBrandService {


    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 分类&品牌关联集合
     */
    List<PmsCategoryBrand> list(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    int save(PmsCategoryBrand pmsCategoryBrand);


    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的分类&品牌关联主键集合
     * @return 结果
     */
    int removeByIds(Long[] ids);

    /**
     * 删除分类&品牌关联信息
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    int removeById(Long id);

}
