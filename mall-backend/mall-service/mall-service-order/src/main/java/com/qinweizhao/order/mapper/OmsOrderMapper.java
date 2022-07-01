package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsOrder;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderMapper extends QwzBaseMapper<OmsOrder> {

    /**
     * 查询订单列表
     *
     * @param omsOrder 订单
     * @return 订单集合
     */
    List<OmsOrder> selectOmsOrderList(OmsOrder omsOrder);

}
