package com.qinweizhao.order.service;

import com.qinweizhao.order.model.entity.OmsOrderItem;

import java.util.List;

/**
 * 订单项信息Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderItemService {
    /**
     * 查询订单项信息
     *
     * @param id 订单项信息主键
     * @return 订单项信息
     */
    OmsOrderItem selectOmsOrderItemById(Long id);

    /**
     * 查询订单项信息列表
     *
     * @param omsOrderItem 订单项信息
     * @return 订单项信息集合
     */
    List<OmsOrderItem> selectOmsOrderItemList(OmsOrderItem omsOrderItem);

    /**
     * 新增订单项信息
     *
     * @param omsOrderItem 订单项信息
     * @return 结果
     */
    int insertOmsOrderItem(OmsOrderItem omsOrderItem);

    /**
     * 修改订单项信息
     *
     * @param omsOrderItem 订单项信息
     * @return 结果
     */
    int updateOmsOrderItem(OmsOrderItem omsOrderItem);

    /**
     * 批量删除订单项信息
     *
     * @param ids 需要删除的订单项信息主键集合
     * @return 结果
     */
    int deleteOmsOrderItemByIds(Long[] ids);

    /**
     * 删除订单项信息信息
     *
     * @param id 订单项信息主键
     * @return 结果
     */
    int deleteOmsOrderItemById(Long id);
}
