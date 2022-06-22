package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.product.convert.CategoryConvert;
import com.qinweizhao.product.mapper.PmsCategoryMapper;
import com.qinweizhao.product.model.dto.CategoryTreeDTO;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品三级分类Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsCategoryServiceImpl implements IPmsCategoryService {

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
    public PmsCategory getById(Long categoryId) {
        return pmsCategoryMapper.selectById(categoryId);
    }

    /**
     * 查询商品三级分类列表
     *
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<PmsCategory> list(PmsCategory pmsCategory) {
        return pmsCategoryMapper.selectList(pmsCategory);
    }

    /**
     * 新增商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int save(PmsCategory pmsCategory) {
        PmsCategory info = pmsCategoryMapper.selectById(pmsCategory.getParentId());
        pmsCategory.setAncestors(info.getAncestors() + "," + pmsCategory.getParentId());
        pmsCategory.setCreateTime(LocalDateTime.now());
        return pmsCategoryMapper.insert(pmsCategory);
    }

    /**
     * 修改商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @CacheEvict(value = "category",allEntries = true)
    @Override
    public int updateById(PmsCategory pmsCategory) {
        PmsCategory newParentCategory = pmsCategoryMapper.selectById(pmsCategory.getParentId());
        PmsCategory oldCategory = pmsCategoryMapper.selectById(pmsCategory.getCategoryId());
        if (StringUtils.isNotNull(newParentCategory) && StringUtils.isNotNull(oldCategory)) {
            String newAncestors = newParentCategory.getAncestors() + "," + newParentCategory.getCategoryId();
            String oldAncestors = oldCategory.getAncestors();
            pmsCategory.setAncestors(newAncestors);
            updateCategoryChildren(pmsCategory.getParentId(), newAncestors, oldAncestors);
        }

        pmsCategory.setUpdateTime(LocalDateTime.now());
        return pmsCategoryMapper.updateById(pmsCategory);
    }

    /**
     * 修改该分类的子分类祖籍列表
     *
     * @param categoryId   categoryId
     * @param newAncestors newAncestors
     * @param oldAncestors oldAncestors
     */
    private void updateCategoryChildren(Long categoryId, String newAncestors, String oldAncestors) {
        PmsCategory pmsCategory = new PmsCategory();
        pmsCategory.setCategoryId(categoryId);
        List<PmsCategory> children = pmsCategoryMapper.selectList(pmsCategory);
        for (PmsCategory child : children) {
            child.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
            pmsCategoryMapper.updateById(child);
        }

    }

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int removeByIds(Long[] categoryIds) {
        return pmsCategoryMapper.removeByIds(categoryIds);
    }

    /**
     * 删除商品三级分类信息
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int removeById(Long categoryId) {
        return pmsCategoryMapper.removeById(categoryId);
    }



    @Cacheable(value = {"category"},key = "#root.method.name",sync = true)
    @Override
    public List<CategoryTreeDTO> getCategoryTree() {
        List<PmsCategory> list = this.list(new PmsCategory());
        return buildCategoryTree(list);
    }

    /**
     * 构建分类树
     *
     * @param list list
     * @return List
     */
    @Override
    public List<CategoryTreeDTO> buildCategoryTree(List<PmsCategory> list) {
        List<CategoryTreeDTO> categoryTreeDTOList = CategoryConvert.INSTANCE.convertToDTO(list);
        return buildTree(categoryTreeDTOList);
    }


    /**
     * 构建树
     *
     * @param list list
     * @return List
     */
    private List<CategoryTreeDTO> buildTree(List<CategoryTreeDTO> list) {
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
    private List<CategoryTreeDTO> getCategoryChildren(CategoryTreeDTO category, List<CategoryTreeDTO> categories) {
        return categories.stream()
                .filter(
                        i ->
                                category.getCategoryId().equals(i.getParentId())
                ).peek(item ->
                        item.setChildren(getCategoryChildren(item, categories)))
                .collect(Collectors.toList());
    }


}
