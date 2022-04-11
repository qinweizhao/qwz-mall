package com.qinweizhao.product.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * sku信息对象 pms_sku_info
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public class PmsSkuInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** skuId */
    private Long skuId;

    /** spuId */
    @Excel(name = "spuId")
    private Long spuId;

    /** sku名称 */
    @Excel(name = "sku名称")
    private String name;

    /** sku介绍描述 */
    @Excel(name = "sku介绍描述")
    private String desc;

    /** 所属分类id */
    @Excel(name = "所属分类id")
    private Long categoryId;

    /** 品牌id */
    @Excel(name = "品牌id")
    private Long brandId;

    /** 默认图片 */
    @Excel(name = "默认图片")
    private String defaultImg;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subtitle;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private BigDecimal price;

    /**
     * 销量
     */
    @Excel(name = "销量")
    private Long saleCount;

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuId() {
        return skuId;
    }

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

    public void setDefaultImg(String defaultImg) {
        this.defaultImg = defaultImg;
    }

    public String getDefaultImg() {
        return defaultImg;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("skuId", getSkuId())
                .append("spuId", getSpuId())
                .append("name", getName())
                .append("desc", getDesc())
                .append("categoryId", getCategoryId())
                .append("brandId", getBrandId())
                .append("defaultImg", getDefaultImg())
                .append("title", getTitle())
                .append("subtitle", getSubtitle())
                .append("price", getPrice())
                .append("saleCount", getSaleCount())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
