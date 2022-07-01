package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 首页轮播广告对象 ams_home_advert
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_home_advert")
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


}
