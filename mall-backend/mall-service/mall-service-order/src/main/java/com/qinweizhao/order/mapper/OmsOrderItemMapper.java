package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsOrderItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单项信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Mapper

public interface OmsOrderItemMapper extends QwzMapper<OmsOrderItem> {

    /**
     * 查询订单项信息列表
     *
     * @param omsOrderItem 订单项信息
     * @return 订单项信息集合
     */
    List<OmsOrderItem> selectOmsOrderItemList(OmsOrderItem omsOrderItem);

}
