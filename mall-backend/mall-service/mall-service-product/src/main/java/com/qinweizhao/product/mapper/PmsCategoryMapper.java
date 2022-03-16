package com.qinweizhao.product.mapper;

import java.util.List;
import com.qinweizhao.product.domain.PmsCategory;

/**
 * 商品三级分类Mapper接口
 * 
 * @author qinweizhao
 * @date 2022-03-16
 */
public interface PmsCategoryMapper 
{
    /**
     * 查询商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 商品三级分类
     */
    public PmsCategory selectPmsCategoryByCatId(Long catId);

    /**
     * 查询商品三级分类列表
     * 
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类集合
     */
    public List<PmsCategory> selectPmsCategoryList(PmsCategory pmsCategory);

    /**
     * 新增商品三级分类
     * 
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    public int insertPmsCategory(PmsCategory pmsCategory);

    /**
     * 修改商品三级分类
     * 
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    public int updatePmsCategory(PmsCategory pmsCategory);

    /**
     * 删除商品三级分类
     * 
     * @param catId 商品三级分类主键
     * @return 结果
     */
    public int deletePmsCategoryByCatId(Long catId);

    /**
     * 批量删除商品三级分类
     * 
     * @param catIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsCategoryByCatIds(Long[] catIds);
}
