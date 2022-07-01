package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsOrderItemMapper;
import com.qinweizhao.order.model.entity.OmsOrderItem;
import com.qinweizhao.order.service.IOmsOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单项信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderItemServiceImpl extends QwzServiceImpl<OmsOrderItemMapper, OmsOrderItem> implements IOmsOrderItemService {
    @Resource
    private OmsOrderItemMapper omsOrderItemMapper;

    /**
     * 查询订单项信息列表
     *
     * @param omsOrderItem 订单项信息
     * @return 订单项信息
     */
    @Override
    public List<OmsOrderItem> selectOmsOrderItemList(OmsOrderItem omsOrderItem) {
        return omsOrderItemMapper.selectOmsOrderItemList(omsOrderItem);
    }

}
