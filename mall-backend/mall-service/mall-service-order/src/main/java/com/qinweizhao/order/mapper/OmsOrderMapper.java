package com.qinweizhao.order.mapper;

import com.qinweizhao.order.model.entity.OmsOrder;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderMapper {
    /**
     * 查询订单
     *
     * @param id 订单主键
     * @return 订单
     */
    OmsOrder selectOmsOrderById(Long id);

    /**
     * 查询订单列表
     *
     * @param omsOrder 订单
     * @return 订单集合
     */
    List<OmsOrder> selectOmsOrderList(OmsOrder omsOrder);

    /**
     * 新增订单
     *
     * @param omsOrder 订单
     * @return 结果
     */
    int insertOmsOrder(OmsOrder omsOrder);

    /**
     * 修改订单
     *
     * @param omsOrder 订单
     * @return 结果
     */
    int updateOmsOrder(OmsOrder omsOrder);

    /**
     * 删除订单
     *
     * @param id 订单主键
     * @return 结果
     */
    int deleteOmsOrderById(Long id);

    /**
     * 批量删除订单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteOmsOrderByIds(Long[] ids);
}
