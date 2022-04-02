package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * sku信息对象 pms_sku_info
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public class PmsSkuInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * spuId
     */
    @Excel(name = "spuId")
    private Long spuId;

    /**
     * sku名称
     */
    @Excel(name = "sku名称")
    private String skuName;

    /**
     * sku介绍描述
     */
    @Excel(name = "sku介绍描述")
    private String skuDesc;

    /**
     * 所属分类id
     */
    @Excel(name = "所属分类id")
    private Long catalogId;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * 默认图片
     */
    @Excel(name = "默认图片")
    private String skuDefaultImg;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String skuTitle;

    /**
     * 副标题
     */
    @Excel(name = "副标题")
    private String skuSubtitle;

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

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuDesc() {
        return skuDesc;
    }

    public void setSkuDesc(String skuDesc) {
        this.skuDesc = skuDesc;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getSkuDefaultImg() {
        return skuDefaultImg;
    }

    public void setSkuDefaultImg(String skuDefaultImg) {
        this.skuDefaultImg = skuDefaultImg;
    }

    public String getSkuTitle() {
        return skuTitle;
    }

    public void setSkuTitle(String skuTitle) {
        this.skuTitle = skuTitle;
    }

    public String getSkuSubtitle() {
        return skuSubtitle;
    }

    public void setSkuSubtitle(String skuSubtitle) {
        this.skuSubtitle = skuSubtitle;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Long saleCount) {
        this.saleCount = saleCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("skuId" , getSkuId())
                .append("spuId" , getSpuId())
                .append("skuName" , getSkuName())
                .append("skuDesc" , getSkuDesc())
                .append("catalogId" , getCatalogId())
                .append("brandId" , getBrandId())
                .append("skuDefaultImg" , getSkuDefaultImg())
                .append("skuTitle" , getSkuTitle())
                .append("skuSubtitle" , getSkuSubtitle())
                .append("price" , getPrice())
                .append("saleCount" , getSaleCount())
                .toString();
    }
}
