package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 商品阶梯价格对象 ams_sku_ladder
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsSkuLadder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long skuId;

    /**
     * 满几件
     */
    @Excel(name = "满几件")
    private Long fullCount;

    /**
     * 打几折
     */
    @Excel(name = "打几折")
    private BigDecimal discount;

    /**
     * 折后价
     */
    @Excel(name = "折后价")
    private BigDecimal price;

    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    @Excel(name = "是否叠加其他优惠[0-不可叠加，1-可叠加]")
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

    public Long getFullCount() {
        return fullCount;
    }

    public void setFullCount(Long fullCount) {
        this.fullCount = fullCount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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
                .append("fullCount", getFullCount())
                .append("discount", getDiscount())
                .append("price", getPrice())
                .append("addOther", getAddOther())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
