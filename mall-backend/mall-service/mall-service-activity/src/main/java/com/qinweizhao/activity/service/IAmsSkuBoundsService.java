package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsSkuBounds;

import java.util.List;

/**
 * 商品sku积分设置Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSkuBoundsService {
    /**
     * 查询商品sku积分设置
     *
     * @param id 商品sku积分设置主键
     * @return 商品sku积分设置
     */
    AmsSkuBounds selectAmsSkuBoundsById(Long id);

    /**
     * 查询商品sku积分设置列表
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 商品sku积分设置集合
     */
    List<AmsSkuBounds> selectAmsSkuBoundsList(AmsSkuBounds amsSkuBounds);

    /**
     * 新增商品sku积分设置
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 结果
     */
    int insertAmsSkuBounds(AmsSkuBounds amsSkuBounds);

    /**
     * 修改商品sku积分设置
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 结果
     */
    int updateAmsSkuBounds(AmsSkuBounds amsSkuBounds);

    /**
     * 批量删除商品sku积分设置
     *
     * @param ids 需要删除的商品sku积分设置主键集合
     * @return 结果
     */
    int deleteAmsSkuBoundsByIds(Long[] ids);

    /**
     * 删除商品sku积分设置信息
     *
     * @param id 商品sku积分设置主键
     * @return 结果
     */
    int deleteAmsSkuBoundsById(Long id);
}
