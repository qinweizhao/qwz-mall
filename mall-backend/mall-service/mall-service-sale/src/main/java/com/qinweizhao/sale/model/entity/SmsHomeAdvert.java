package com.qinweizhao.sale.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("sms_home_advert")
public class SmsHomeAdvert extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 名字
     */
    private String name;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 点击数
     */
    private Long clickCount;

    /**
     * 广告详情连接地址
     */
    private String url;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 发布者
     */
    private Long publisherId;

    /**
     * 审核者
     */
    private Long authId;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 备注
     */
    private String remark;

}
