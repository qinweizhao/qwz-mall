package com.qinweizhao.product.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qinweizhao.product.mapper.PmsCategoryMapper;
import com.qinweizhao.product.domain.PmsCategory;
import com.qinweizhao.product.service.IPmsCategoryService;

/**
 * 商品三级分类Service业务层处理
 * 
 * @author qinweizhao
 * @date 2022-03-16
 */
@Service
public class PmsCategoryServiceImpl implements IPmsCategoryService 
{
    @Autowired
    private PmsCategoryMapper pmsCategoryMapper;

    /**
     * 查询商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public PmsCategory selectPmsCategoryByCatId(Long catId)
    {
        return pmsCategoryMapper.selectPmsCategoryByCatId(catId);
    }

    /**
     * 查询商品三级分类列表
     * 
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<PmsCategory> selectPmsCategoryList(PmsCategory pmsCategory)
    {
        return pmsCategoryMapper.selectPmsCategoryList(pmsCategory);
    }

    /**
     * 新增商品三级分类
     * 
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int insertPmsCategory(PmsCategory pmsCategory)
    {
        return pmsCategoryMapper.insertPmsCategory(pmsCategory);
    }

    /**
     * 修改商品三级分类
     * 
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int updatePmsCategory(PmsCategory pmsCategory)
    {
        return pmsCategoryMapper.updatePmsCategory(pmsCategory);
    }

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCatIds(Long[] catIds)
    {
        return pmsCategoryMapper.deletePmsCategoryByCatIds(catIds);
    }

    /**
     * 删除商品三级分类信息
     * 
     * @param catId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCatId(Long catId)
    {
        return pmsCategoryMapper.deletePmsCategoryByCatId(catId);
    }
}
