package com.qinweizhao.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付信息对象 oms_payment_info
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_payment_info")
public class OmsPaymentInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 订单号（对外业务号）
     */
    @Excel(name = "订单号", readConverterExp = "对=外业务号")
    private String orderSn;

    /**
     * 订单id
     */
    @Excel(name = "订单id")
    private Long orderId;

    /**
     * 支付宝交易流水号
     */
    @Excel(name = "支付宝交易流水号")
    private String alipayTradeNo;

    /**
     * 支付总金额
     */
    @Excel(name = "支付总金额")
    private BigDecimal totalAmount;

    /**
     * 交易内容
     */
    @Excel(name = "交易内容")
    private String subject;

    /**
     * 支付状态
     */
    @Excel(name = "支付状态")
    private String paymentStatus;

    /**
     * 确认时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date confirmTime;

    /**
     * 回调内容
     */
    @Excel(name = "回调内容")
    private String callbackContent;

    /**
     * 回调时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回调时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date callbackTime;
}
