package com.qinweizhao.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 退款信息对象 oms_refund_info
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_refund_info")
public class OmsRefundInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 退款的订单
     */
    @Excel(name = "退款的订单")
    private Long orderReturnId;

    /**
     * 退款金额
     */
    @Excel(name = "退款金额")
    private BigDecimal refund;

    /**
     * 退款交易流水号
     */
    @Excel(name = "退款交易流水号")
    private String refundSn;

    /**
     * 退款状态
     */
    @Excel(name = "退款状态")
    private Integer refundStatus;

    /**
     * 退款渠道[1-支付宝，2-微信，3-银联，4-汇款]
     */
    @Excel(name = "退款渠道[1-支付宝，2-微信，3-银联，4-汇款]")
    private Long refundChannel;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String refundContent;

}
