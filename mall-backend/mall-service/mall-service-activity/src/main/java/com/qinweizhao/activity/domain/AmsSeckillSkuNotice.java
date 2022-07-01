package com.qinweizhao.activity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 秒杀商品通知订阅对象 ams_seckill_sku_notice
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public Date getSubcribeTime() {
        return subcribeTime;
    }

    public void setSubcribeTime(Date subcribeTime) {
        this.subcribeTime = subcribeTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("memberId", getMemberId())
                .append("skuId", getSkuId())
                .append("sessionId", getSessionId())
                .append("subcribeTime", getSubcribeTime())
                .append("sendTime", getSendTime())
                .append("noticeType", getNoticeType())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
