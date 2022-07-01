package com.qinweizhao.order.service.impl;

import com.qinweizhao.order.mapper.OmsOrderMapper;
import com.qinweizhao.order.model.entity.OmsOrder;
import com.qinweizhao.order.service.IOmsOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderServiceImpl implements IOmsOrderService {

    @Resource
    private OmsOrderMapper omsOrderMapper;

    /**
     * 查询订单
     *
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public OmsOrder selectOmsOrderById(Long id) {
        return omsOrderMapper.selectOmsOrderById(id);
    }

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

    /**
     * 新增订单
     *
     * @param omsOrder 订单
     * @return 结果
     */
    @Override
    public int insertOmsOrder(OmsOrder omsOrder) {
        omsOrder.setCreateTime(LocalDateTime.now());
        return omsOrderMapper.insertOmsOrder(omsOrder);
    }

    /**
     * 修改订单
     *
     * @param omsOrder 订单
     * @return 结果
     */
    @Override
    public int updateOmsOrder(OmsOrder omsOrder) {
        omsOrder.setUpdateTime(LocalDateTime.now());
        return omsOrderMapper.updateOmsOrder(omsOrder);
    }

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderByIds(Long[] ids) {
        return omsOrderMapper.deleteOmsOrderByIds(ids);
    }

    /**
     * 删除订单信息
     *
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderById(Long id) {
        return omsOrderMapper.deleteOmsOrderById(id);
    }
}
