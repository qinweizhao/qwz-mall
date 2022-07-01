package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSkuBounds;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 商品sku积分设置Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSkuBoundsService extends QwzService<AmsSkuBounds> {

    /**
     * 查询商品sku积分设置列表
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 商品sku积分设置集合
     */
    List<AmsSkuBounds> selectAmsSkuBoundsList(AmsSkuBounds amsSkuBounds);


}
