package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.domain.PmsCategory;
import com.qinweizhao.product.mapper.PmsCategoryMapper;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品三级分类Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsCategoryServiceImpl implements IPmsCategoryService {
    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    /**
     * 查询商品三级分类
     *
     * @param categoryId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public PmsCategory selectPmsCategoryByCategoryId(Long categoryId) {
        return pmsCategoryMapper.selectPmsCategoryByCategoryId(categoryId);
    }

    /**
     * 查询商品三级分类列表
     *
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<PmsCategory> selectPmsCategoryList(PmsCategory pmsCategory) {
        return pmsCategoryMapper.selectPmsCategoryList(pmsCategory);
    }

    /**
     * 新增商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int insertPmsCategory(PmsCategory pmsCategory) {
        pmsCategory.setCreateTime(DateUtils.getNowDate());
        return pmsCategoryMapper.insertPmsCategory(pmsCategory);
    }

    /**
     * 修改商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int updatePmsCategory(PmsCategory pmsCategory) {
        pmsCategory.setUpdateTime(DateUtils.getNowDate());
        return pmsCategoryMapper.updatePmsCategory(pmsCategory);
    }

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCategoryIds(Long[] categoryIds) {
        return pmsCategoryMapper.deletePmsCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除商品三级分类信息
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCategoryId(Long categoryId) {
        return pmsCategoryMapper.deletePmsCategoryByCategoryId(categoryId);
    }
}
