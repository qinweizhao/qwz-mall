package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsCategory;

/**
 * 商品三级分类Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsCategoryService {
    /**
     * 查询商品三级分类
     *
     * @param categoryId 商品三级分类主键
     * @return 商品三级分类
     */
    PmsCategory selectPmsCategoryByCategoryId(Long categoryId);

    /**
     * 查询商品三级分类列表
     *
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类集合
     */
    List<PmsCategory> selectPmsCategoryList(PmsCategory pmsCategory);

    /**
     * 新增商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    int insertPmsCategory(PmsCategory pmsCategory);

    /**
     * 修改商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    int updatePmsCategory(PmsCategory pmsCategory);

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的商品三级分类主键集合
     * @return 结果
     */
    int deletePmsCategoryByCategoryIds(Long[] categoryIds);

    /**
     * 删除商品三级分类信息
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    int deletePmsCategoryByCategoryId(Long categoryId);
}
