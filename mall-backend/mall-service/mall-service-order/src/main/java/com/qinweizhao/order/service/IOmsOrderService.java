package com.qinweizhao.order.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.order.model.entity.OmsOrder;

import java.util.List;

/**
 * 订单Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderService extends QwzService<OmsOrder> {


    /**
     * 查询订单列表
     *
     * @param omsOrder 订单
     * @return 订单集合
     */
    List<OmsOrder> selectOmsOrderList(OmsOrder omsOrder);

}
