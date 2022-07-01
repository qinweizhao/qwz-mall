package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 商品满减信息对象 ams_sku_full_reduction
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsSkuFullReduction extends BaseEntity {
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
     * 满多少
     */
    @Excel(name = "满多少")
    private BigDecimal fullPrice;

    /**
     * 减多少
     */
    @Excel(name = "减多少")
    private BigDecimal reducePrice;

    /**
     * 是否参与其他优惠
     */
    @Excel(name = "是否参与其他优惠")
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

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(BigDecimal fullPrice) {
        this.fullPrice = fullPrice;
    }

    public BigDecimal getReducePrice() {
        return reducePrice;
    }

    public void setReducePrice(BigDecimal reducePrice) {
        this.reducePrice = reducePrice;
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
                .append("fullPrice", getFullPrice())
                .append("reducePrice", getReducePrice())
                .append("addOther", getAddOther())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
