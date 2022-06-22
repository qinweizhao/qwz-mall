package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 会员统计信息对象 ums_member_statistics_info
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("ums_member_statistics_info")
public class UmsMemberStatisticsInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 会员id
     */
    @Excel(name = "会员id")
    private Long memberId;

    /**
     * 累计消费金额
     */
    @Excel(name = "累计消费金额")
    private BigDecimal consumeAmount;

    /**
     * 累计优惠金额
     */
    @Excel(name = "累计优惠金额")
    private BigDecimal couponAmount;

    /**
     * 订单数量
     */
    @Excel(name = "订单数量")
    private Long orderCount;

    /**
     * 优惠券数量
     */
    @Excel(name = "优惠券数量")
    private Long couponCount;

    /**
     * 评价数
     */
    @Excel(name = "评价数")
    private Long commentCount;

    /**
     * 退货数量
     */
    @Excel(name = "退货数量")
    private Long returnOrderCount;

    /**
     * 登录次数
     */
    @Excel(name = "登录次数")
    private Long loginCount;

    /**
     * 关注数量
     */
    @Excel(name = "关注数量")
    private Long attendCount;

    /**
     * 粉丝数量
     */
    @Excel(name = "粉丝数量")
    private Long fansCount;

    /**
     * 收藏的商品数量
     */
    @Excel(name = "收藏的商品数量")
    private Long collectProductCount;

    /**
     * 收藏的专题活动数量
     */
    @Excel(name = "收藏的专题活动数量")
    private Long collectSubjectCount;

    /**
     * 收藏的评论数量
     */
    @Excel(name = "收藏的评论数量")
    private Long collectCommentCount;

    /**
     * 邀请的朋友数量
     */
    @Excel(name = "邀请的朋友数量")
    private Long inviteFriendCount;

}
