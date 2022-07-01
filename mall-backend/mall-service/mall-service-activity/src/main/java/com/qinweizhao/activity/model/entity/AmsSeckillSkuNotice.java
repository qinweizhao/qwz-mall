package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 秒杀商品通知订阅对象 ams_seckill_sku_notice
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_seckill_sku_notice")
public class AmsSeckillSkuNotice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * member_id
     */
    @Excel(name = "member_id")
    private Long memberId;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private Long skuId;

    /**
     * 活动场次id
     */
    @Excel(name = "活动场次id")
    private Long sessionId;

    /**
     * 订阅时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订阅时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date subcribeTime;

    /**
     * 发送时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;

    /**
     * 通知方式[0-短信，1-邮件]
     */
    @Excel(name = "通知方式[0-短信，1-邮件]")
    private Integer noticeType;


}
