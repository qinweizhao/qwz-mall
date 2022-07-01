package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 商品会员价格对象 ams_member_price
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsMemberPrice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private Long skuId;

    /**
     * 会员等级id
     */
    @Excel(name = "会员等级id")
    private Long memberLevelId;

    /**
     * 会员等级名
     */
    @Excel(name = "会员等级名")
    private String memberLevelName;

    /**
     * 会员对应价格
     */
    @Excel(name = "会员对应价格")
    private BigDecimal memberPrice;

    /**
     * 可否叠加其他优惠[0-不可叠加优惠，1-可叠加]
     */
    @Excel(name = "可否叠加其他优惠[0-不可叠加优惠，1-可叠加]")
    private Integer addOther;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getMemberLevelId() {
        return memberLevelId;
    }

    public void setMemberLevelId(Long memberLevelId) {
        this.memberLevelId = memberLevelId;
    }

    public String getMemberLevelName() {
        return memberLevelName;
    }

    public void setMemberLevelName(String memberLevelName) {
        this.memberLevelName = memberLevelName;
    }

    public BigDecimal getMemberPrice() {
        return memberPrice;
    }

    public void setMemberPrice(BigDecimal memberPrice) {
        this.memberPrice = memberPrice;
    }

    public Integer getAddOther() {
        return addOther;
    }

    public void setAddOther(Integer addOther) {
        this.addOther = addOther;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("skuId", getSkuId())
                .append("memberLevelId", getMemberLevelId())
                .append("memberLevelName", getMemberLevelName())
                .append("memberPrice", getMemberPrice())
                .append("addOther", getAddOther())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
