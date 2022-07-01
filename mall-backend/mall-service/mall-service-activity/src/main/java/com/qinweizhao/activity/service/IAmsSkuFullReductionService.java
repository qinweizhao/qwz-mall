package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSkuFullReduction;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 商品满减信息Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSkuFullReductionService extends QwzService<AmsSkuFullReduction> {

    /**
     * 查询商品满减信息列表
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 商品满减信息集合
     */
    List<AmsSkuFullReduction> selectAmsSkuFullReductionList(AmsSkuFullReduction amsSkuFullReduction);

}
