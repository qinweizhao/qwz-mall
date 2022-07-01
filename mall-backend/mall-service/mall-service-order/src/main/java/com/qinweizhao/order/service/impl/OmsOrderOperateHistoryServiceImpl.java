package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsOrderOperateHistoryMapper;
import com.qinweizhao.order.model.entity.OmsOrderOperateHistory;
import com.qinweizhao.order.service.IOmsOrderOperateHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单操作历史记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderOperateHistoryServiceImpl extends QwzServiceImpl<OmsOrderOperateHistoryMapper, OmsOrderOperateHistory> implements IOmsOrderOperateHistoryService {

    @Resource
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;

    /**
     * 查询订单操作历史记录列表
     *
     * @param omsOrderOperateHistory 订单操作历史记录
     * @return 订单操作历史记录
     */
    @Override
    public List<OmsOrderOperateHistory> selectOmsOrderOperateHistoryList(OmsOrderOperateHistory omsOrderOperateHistory) {
        return omsOrderOperateHistoryMapper.selectOmsOrderOperateHistoryList(omsOrderOperateHistory);
    }

}
