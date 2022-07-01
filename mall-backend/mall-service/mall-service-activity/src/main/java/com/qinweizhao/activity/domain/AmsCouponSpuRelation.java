package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 优惠券与产品关联对象 ams_coupon_spu_relation
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsCouponSpuRelation extends BaseEntity {
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
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * spu_name
     */
    @Excel(name = "spu_name")
    private String spuName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSpuName() {
        return spuName;
    }

    public void setSpuName(String spuName) {
        this.spuName = spuName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("couponId", getCouponId())
                .append("spuId", getSpuId())
                .append("spuName", getSpuName())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
