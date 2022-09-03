package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsOrderOperateHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单操作历史记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Mapper

public interface OmsOrderOperateHistoryMapper extends QwzMapper<OmsOrderOperateHistory> {

    /**
     * 查询订单操作历史记录列表
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录集合
     */
    List<OmsOrderOperateHistory> selectOmsOrderOperateHistoryList(OmsOrderOperateHistory omsOrderOperateHistory);


}
