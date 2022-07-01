package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsOrderMapper;
import com.qinweizhao.order.model.entity.OmsOrder;
import com.qinweizhao.order.service.IOmsOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderServiceImpl extends QwzServiceImpl<OmsOrderMapper, OmsOrder> implements IOmsOrderService {

    @Resource
    private OmsOrderMapper omsOrderMapper;

    /**
     * 查询订单列表
     *
     * @param omsOrder 订单
     * @return 订单
     */
    @Override
    public List<OmsOrder> selectOmsOrderList(OmsOrder omsOrder) {
        return omsOrderMapper.selectOmsOrderList(omsOrder);
    }

}
