package com.qinweizhao.product.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * spu信息对象 pms_spu_info
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public class PmsSpuInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 商品id */
    private Long spuId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String name;

    /** 商品描述 */
    @Excel(name = "商品描述")
    private String desc;

    /** 所属分类id */
    @Excel(name = "所属分类id")
    private Long categoryId;

    /** 品牌id */
    @Excel(name = "品牌id")
    private Long brandId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private BigDecimal weight;

    /** 上架状态[0 - 下架，1 - 上架] */
    @Excel(name = "上架状态[0 - 下架，1 - 上架]")
    private Long status;

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("spuId", getSpuId())
                .append("name", getName())
                .append("desc", getDesc())
                .append("categoryId", getCategoryId())
                .append("brandId", getBrandId())
                .append("weight", getWeight())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
