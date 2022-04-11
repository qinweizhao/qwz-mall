package com.qinweizhao.product.mapper;

import com.qinweizhao.product.entity.PmsCategory;

import java.util.List;

/**
 * 商品三级分类Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsCategoryMapper {
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
     * 删除商品三级分类
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    int deletePmsCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsCategoryByCategoryIds(Long[] categoryIds);
}
