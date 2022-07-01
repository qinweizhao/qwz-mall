package com.qinweizhao.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单配置信息对象 oms_order_setting
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_setting")
public class OmsOrderSetting extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 秒杀订单超时关闭时间(分)
     */
    @Excel(name = "秒杀订单超时关闭时间(分)")
    private Long flashOrderOvertime;

    /**
     * 正常订单超时时间(分)
     */
    @Excel(name = "正常订单超时时间(分)")
    private Long normalOrderOvertime;

    /**
     * 发货后自动确认收货时间（天）
     */
    @Excel(name = "发货后自动确认收货时间", readConverterExp = "天=")
    private Long confirmOvertime;

    /**
     * 自动完成交易时间，不能申请退货（天）
     */
    @Excel(name = "自动完成交易时间，不能申请退货", readConverterExp = "天=")
    private Long finishOvertime;

    /**
     * 订单完成后自动好评时间（天）
     */
    @Excel(name = "订单完成后自动好评时间", readConverterExp = "天=")
    private Long commentOvertime;

    /**
     * 会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】
     */
    @Excel(name = "会员等级【0-不限会员等级，全部通用；其他-对应的其他会员等级】")
    private Long memberLevel;

}
