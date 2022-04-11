package com.qinweizhao.product.mapper;

import java.util.List;

import com.qinweizhao.product.domain.PmsCategoryBrand;

/**
 * 分类&品牌关联Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsCategoryBrandMapper {
    /**
     * 查询分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 分类&品牌关联
     */
    public PmsCategoryBrand selectPmsCategoryBrandById(Long id);

    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 分类&品牌关联集合
     */
    public List<PmsCategoryBrand> selectPmsCategoryBrandList(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    public int insertPmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 修改分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    public int updatePmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 删除分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    public int deletePmsCategoryBrandById(Long id);

    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsCategoryBrandByIds(Long[] ids);
}
