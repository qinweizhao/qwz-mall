package com.qinweizhao.product.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.product.convert.CategoryConvert;
import com.qinweizhao.product.mapper.PmsCategoryMapper;
import com.qinweizhao.product.model.dto.CategoryDTO;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.model.vo.CategoryVO;
import com.qinweizhao.product.service.PmsCategoryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品三级分类Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsCategoryServiceImpl extends QwzServiceImpl<PmsCategoryMapper, PmsCategory> implements PmsCategoryService {

    private static final Long LONG_ZERO = 0L;

    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    /**
     * 查询商品三级分类
     *
     * @param categoryId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public CategoryDTO getById(Long categoryId) {
        PmsCategory pmsCategory = pmsCategoryMapper.selectById(categoryId);
        return CategoryConvert.INSTANCE.convert(pmsCategory);
    }





    /**
     * 修改该分类的子分类祖籍列表
     *
     * @param categoryId   categoryId
     * @param newAncestors newAncestors
     * @param oldAncestors oldAncestors
     */
    private void updateCategoryChildren(Long categoryId, String newAncestors, String oldAncestors) {
//        PmsCategory pmsCategory = new PmsCategory();
//        pmsCategory.setCategoryId(categoryId);
//        List<PmsCategory> children = pmsCategoryMapper.selectList(pmsCategory);
//        for (PmsCategory child : children) {
//            child.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
//            pmsCategoryMapper.updateById(child);
//        }

    }


    @Cacheable(value = {"category"}, key = "#root.method.name", sync = true)
    @Override
    public List<CategoryVO> getCategoryTree() {
//        return buildCategoryTree(list(new PmsCategory()));
        return null;
    }

    @Override
    public Long getTopCategoryId(Long categoryId) {
//        PmsCategory pmsCategory = pmsCategoryMapper.selectById(categoryId);
//
//        Long parentId = pmsCategory.getParentId();
//        if (!parentId.equals(0L)){
//            return getTopCategoryId(parentId);
//        }else {
//            return pmsCategory.getCategoryId();
//        }
        return null;
    }

    /**
     * 构建分类树
     *
     * @param list list
     * @return List
     */
    @Override
    public List<CategoryVO> buildCategoryTree(List<PmsCategory> list) {
        return buildTree(CategoryConvert.INSTANCE.convertToVO(list));
    }


    /**
     * 构建树
     *
     * @param list list
     * @return List
     */
    private List<CategoryVO> buildTree(List<CategoryVO> list) {
        return list.stream().filter(item ->
                LONG_ZERO.equals(item.getParentId())
        ).peek(item -> item.setChildren(getCategoryChildren(item, list))).collect(Collectors.toList());
    }

    /**
     * 获取子分类
     *
     * @param category   category
     * @param categories categories
     * @return List
     */
    private List<CategoryVO> getCategoryChildren(CategoryVO category, List<CategoryVO> categories) {
        return categories.stream()
                .filter(
                        i ->
                                category.getCategoryId().equals(i.getParentId())
                ).peek(item ->
                        item.setChildren(getCategoryChildren(item, categories)))
                .collect(Collectors.toList());
    }


}
