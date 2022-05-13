package com.qinweizhao.product.mapper;

import com.qinweizhao.product.model.entity.PmsCategoryBrand;

import java.util.List;

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
    PmsCategoryBrand selectPmsCategoryBrandById(Long id);

    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 分类&品牌关联集合
     */
    List<PmsCategoryBrand> selectList(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    int insert(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 修改分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    int updatePmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand);

    /**
     * 删除分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    int deleteById(Long id);

    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByIds(Long[] ids);

    /**
     * 查询分类和品牌的关联信息
     *
     * @param brandId brandId
     * @return List<PmsCategoryBrand>
     */
    List<PmsCategoryBrand> selectPmsCategoryBrandByBrandId(Long brandId);

}
