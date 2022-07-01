package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSkuLadder;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 商品阶梯价格Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSkuLadderService extends QwzService<AmsSkuLadder> {


    /**
     * 查询商品阶梯价格列表
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 商品阶梯价格集合
     */
    List<AmsSkuLadder> selectAmsSkuLadderList(AmsSkuLadder amsSkuLadder);
}
