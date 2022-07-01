package com.qinweizhao.order.service.impl;

import com.qinweizhao.order.mapper.OmsOrderItemMapper;
import com.qinweizhao.order.model.entity.OmsOrderItem;
import com.qinweizhao.order.service.IOmsOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单项信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderItemServiceImpl implements IOmsOrderItemService {
    @Resource
    private OmsOrderItemMapper omsOrderItemMapper;

    /**
     * 查询订单项信息
     *
     * @param id 订单项信息主键
     * @return 订单项信息
     */
    @Override
    public OmsOrderItem selectOmsOrderItemById(Long id) {
        return omsOrderItemMapper.selectOmsOrderItemById(id);
    }

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

    /**
     * 新增订单项信息
     *
     * @param omsOrderItem 订单项信息
     * @return 结果
     */
    @Override
    public int insertOmsOrderItem(OmsOrderItem omsOrderItem) {
        omsOrderItem.setCreateTime(LocalDateTime.now());
        return omsOrderItemMapper.insertOmsOrderItem(omsOrderItem);
    }

    /**
     * 修改订单项信息
     *
     * @param omsOrderItem 订单项信息
     * @return 结果
     */
    @Override
    public int updateOmsOrderItem(OmsOrderItem omsOrderItem) {
        omsOrderItem.setUpdateTime(LocalDateTime.now());
        return omsOrderItemMapper.updateOmsOrderItem(omsOrderItem);
    }

    /**
     * 批量删除订单项信息
     *
     * @param ids 需要删除的订单项信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderItemByIds(Long[] ids) {
        return omsOrderItemMapper.deleteOmsOrderItemByIds(ids);
    }

    /**
     * 删除订单项信息信息
     *
     * @param id 订单项信息主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderItemById(Long id) {
        return omsOrderItemMapper.deleteOmsOrderItemById(id);
    }
}
