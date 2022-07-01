package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsOrderItem;

import java.util.List;

/**
 * 订单项信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderItemMapper extends QwzBaseMapper<OmsOrderItem> {

    /**
     * 查询订单项信息列表
     *
     * @param omsOrderItem 订单项信息
     * @return 订单项信息集合
     */
    List<OmsOrderItem> selectOmsOrderItemList(OmsOrderItem omsOrderItem);

}
