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
 * 订单退货申请对象 oms_order_return_apply
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_return_apply")
public class OmsOrderReturnApply extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * order_id
     */
    @Excel(name = "order_id")
    private Long orderId;

    /**
     * 退货商品id
     */
    @Excel(name = "退货商品id")
    private Long skuId;

    /**
     * 订单编号
     */
    @Excel(name = "订单编号")
    private String orderSn;

    /**
     * 会员用户名
     */
    @Excel(name = "会员用户名")
    private String memberUsername;

    /**
     * 退款金额
     */
    @Excel(name = "退款金额")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     */
    @Excel(name = "退货人姓名")
    private String returnName;

    /**
     * 退货人电话
     */
    @Excel(name = "退货人电话")
    private String returnPhone;

    /**
     * 申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]
     */
    @Excel(name = "申请状态[0->待处理；1->退货中；2->已完成；3->已拒绝]")
    private Integer status;

    /**
     * 处理时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleTime;

    /**
     * 商品图片
     */
    @Excel(name = "商品图片")
    private String skuImg;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String skuName;

    /**
     * 商品品牌
     */
    @Excel(name = "商品品牌")
    private String skuBrand;

    /**
     * 商品销售属性(JSON)
     */
    @Excel(name = "商品销售属性(JSON)")
    private String skuAttrsVals;

    /**
     * 退货数量
     */
    @Excel(name = "退货数量")
    private Long skuCount;

    /**
     * 商品单价
     */
    @Excel(name = "商品单价")
    private BigDecimal skuPrice;

    /**
     * 商品实际支付单价
     */
    @Excel(name = "商品实际支付单价")
    private BigDecimal skuRealPrice;

    /**
     * 原因
     */
    @Excel(name = "原因")
    private String reason;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 凭证图片，以逗号隔开
     */
    @Excel(name = "凭证图片，以逗号隔开")
    private String descPics;

    /**
     * 处理备注
     */
    @Excel(name = "处理备注")
    private String handleNote;

    /**
     * 处理人员
     */
    @Excel(name = "处理人员")
    private String handleMan;

    /**
     * 收货人
     */
    @Excel(name = "收货人")
    private String receiveMan;

    /**
     * 收货时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveTime;

    /**
     * 收货备注
     */
    @Excel(name = "收货备注")
    private String receiveNote;

    /**
     * 收货电话
     */
    @Excel(name = "收货电话")
    private String receivePhone;

    /**
     * 公司收货地址
     */
    @Excel(name = "公司收货地址")
    private String companyAddress;

}
