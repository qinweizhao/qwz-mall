package com.qinweizhao.product.service;

import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.model.vo.CategoryVO;

import java.util.List;

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
    PmsCategory getById(Long categoryId);

    /**
     * 查询商品三级分类列表
     *
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类集合
     */
    List<PmsCategory> list(PmsCategory pmsCategory);

    /**
     * 新增商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    int save(PmsCategory pmsCategory);

    /**
     * 修改商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    int updateById(PmsCategory pmsCategory);

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的商品三级分类主键集合
     * @return 结果
     */
    int removeByIds(Long[] categoryIds);

    /**
     * 删除商品三级分类信息
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    int removeById(Long categoryId);

    /**
     * 构建分类树
     *
     * @param list list
     * @return List<PmsCategory>
     */
    List<CategoryVO> buildCategoryTree(List<PmsCategory> list);

    /**
     * 获取分类树
     * @return List
     */
    List<CategoryVO> getCategoryTree();


}
