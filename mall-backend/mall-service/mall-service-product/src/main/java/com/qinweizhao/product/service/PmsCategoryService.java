package com.qinweizhao.product.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.product.model.dto.CategoryDTO;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.model.vo.CategoryVO;

import java.util.List;

/**
 * 商品三级分类Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsCategoryService extends QwzService<PmsCategory> {
    /**
     * 查询商品三级分类
     *
     * @param categoryId 商品三级分类主键
     * @return 商品三级分类
     */
    CategoryDTO getById(Long categoryId);

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


    /**
     * 查找一级分类 id
     * @param categoryId categoryId
     * @return Long
     */
    Long getTopCategoryId(Long categoryId);


}
