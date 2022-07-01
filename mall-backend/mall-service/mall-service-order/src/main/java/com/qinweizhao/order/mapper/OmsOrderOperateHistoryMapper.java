package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsOrderOperateHistory;

import java.util.List;

/**
 * 订单操作历史记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderOperateHistoryMapper extends QwzBaseMapper<OmsOrderOperateHistory> {

    /**
     * 查询订单操作历史记录列表
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录集合
     */
    List<OmsOrderOperateHistory> selectOmsOrderOperateHistoryList(OmsOrderOperateHistory omsOrderOperateHistory);


}
