package com.qinweizhao.order.service;

import com.qinweizhao.order.model.entity.OmsOrderOperateHistory;

import java.util.List;

/**
 * 订单操作历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderOperateHistoryService {
    /**
     * 查询订单操作历史记录
     *
     * @param id 订单操作历史记录主键
     * @return 订单操作历史记录
     */
    OmsOrderOperateHistory selectOmsOrderOperateHistoryById(Long id);

    /**
     * 查询订单操作历史记录列表
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录集合
     */
    List<OmsOrderOperateHistory> selectOmsOrderOperateHistoryList(OmsOrderOperateHistory omsOrderOperateHistory);

    /**
     * 新增订单操作历史记录
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 结果
     */
    int insertOmsOrderOperateHistory(OmsOrderOperateHistory omsOrderOperateHistory);

    /**
     * 修改订单操作历史记录
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 结果
     */
    int updateOmsOrderOperateHistory(OmsOrderOperateHistory omsOrderOperateHistory);

    /**
     * 批量删除订单操作历史记录
     *
     * @param ids 需要删除的订单操作历史记录主键集合
     * @return 结果
     */
    int deleteOmsOrderOperateHistoryByIds(Long[] ids);

    /**
     * 删除订单操作历史记录信息
     *
     * @param id 订单操作历史记录主键
     * @return 结果
     */
    int deleteOmsOrderOperateHistoryById(Long id);
}
