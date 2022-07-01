package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 优惠券领取历史记录对象 ams_coupon_history
 *
 * @author qinweizhao
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_coupon_history")
public class AmsCouponHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 优惠券id
     */
    @Excel(name = "优惠券id")
    private Long couponId;

    /**
     * 会员id
     */
    @Excel(name = "会员id")
    private Long memberId;

    /**
     * 会员名字
     */
    @Excel(name = "会员名字")
    private String memberNickName;

    /**
     * 获取方式[0->后台赠送；1->主动领取]
     */
    @Excel(name = "获取方式[0->后台赠送；1->主动领取]")
    private Integer getType;

    /**
     * 使用状态[0->未使用；1->已使用；2->已过期]
     */
    @Excel(name = "使用状态[0->未使用；1->已使用；2->已过期]")
    private Integer useType;

    /**
     * 使用时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "使用时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date useTime;

    /**
     * 订单id
     */
    @Excel(name = "订单id")
    private Long orderId;

    /**
     * 订单号
     */
    @Excel(name = "订单号")
    private Long orderSn;

}
