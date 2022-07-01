package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsMemberPrice;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 商品会员价格Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsMemberPriceService extends QwzService<AmsMemberPrice> {
    /**
     * 查询商品会员价格列表
     *
     * @param amsMemberPrice 商品会员价格
     * @return 商品会员价格集合
     */
    List<AmsMemberPrice> selectAmsMemberPriceList(AmsMemberPrice amsMemberPrice);

}
