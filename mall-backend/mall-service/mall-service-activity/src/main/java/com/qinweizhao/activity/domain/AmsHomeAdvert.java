package com.qinweizhao.activity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 首页轮播广告对象 ams_home_advert
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsHomeAdvert extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    @Excel(name = "名字")
    private String name;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String pic;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 点击数
     */
    @Excel(name = "点击数")
    private Long clickCount;

    /**
     * 广告详情连接地址
     */
    @Excel(name = "广告详情连接地址")
    private String url;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 发布者
     */
    @Excel(name = "发布者")
    private Long publisherId;

    /**
     * 审核者
     */
    @Excel(name = "审核者")
    private Long authId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("pic", getPic())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("status", getStatus())
                .append("clickCount", getClickCount())
                .append("url", getUrl())
                .append("note", getNote())
                .append("sort", getSort())
                .append("publisherId", getPublisherId())
                .append("authId", getAuthId())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
