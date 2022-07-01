package com.qinweizhao.order.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.order.model.entity.OmsOrderOperateHistory;

import java.util.List;

/**
 * 订单操作历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderOperateHistoryService extends QwzService<OmsOrderOperateHistory> {

    /**
     * 查询订单操作历史记录列表
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录集合
     */
    List<OmsOrderOperateHistory> selectOmsOrderOperateHistoryList(OmsOrderOperateHistory omsOrderOperateHistory);

}
