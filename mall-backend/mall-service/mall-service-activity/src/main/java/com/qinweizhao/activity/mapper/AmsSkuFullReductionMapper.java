package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.domain.AmsSkuFullReduction;

import java.util.List;

/**
 * 商品满减信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSkuFullReductionMapper {
    /**
     * 查询商品满减信息
     *
     * @param id 商品满减信息主键
     * @return 商品满减信息
     */
    AmsSkuFullReduction selectAmsSkuFullReductionById(Long id);

    /**
     * 查询商品满减信息列表
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 商品满减信息集合
     */
    List<AmsSkuFullReduction> selectAmsSkuFullReductionList(AmsSkuFullReduction amsSkuFullReduction);

    /**
     * 新增商品满减信息
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 结果
     */
    int insertAmsSkuFullReduction(AmsSkuFullReduction amsSkuFullReduction);

    /**
     * 修改商品满减信息
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 结果
     */
    int updateAmsSkuFullReduction(AmsSkuFullReduction amsSkuFullReduction);

    /**
     * 删除商品满减信息
     *
     * @param id 商品满减信息主键
     * @return 结果
     */
    int deleteAmsSkuFullReductionById(Long id);

    /**
     * 批量删除商品满减信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSkuFullReductionByIds(Long[] ids);
}
