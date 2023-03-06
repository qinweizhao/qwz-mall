package com.mall4j.cloud.search.bo;

import cn.throwx.canal.gule.annotation.CanalModel;
import cn.throwx.canal.gule.common.FieldNamingPolicy;

/**
 * 商品信息
 *
 * @author YXF
 * @date 2020-12-23 15:27:24
 */
@CanalModel(database = "mall4cloud_product", table = "spu", fieldNamingPolicy = FieldNamingPolicy.LOWER_UNDERSCORE)
public class SpuBO {
    /**
     * spu id
     */
    private Long spuId;

    /**
     * 品牌ID
     */
    private Long brandId;

    /**
     * 分类ID
     */
    private Long categoryId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * spu名称
     */
    private String name;

    /**
     * 卖点
     */
    private String sellingPoint;

    /**
     * 主图
     */
    private String mainImgUrl;

    /**
     * 商品图片 多个图片逗号分隔
     */
    private String imgUrls;

    /**
     * 商品视频
     */
    private String video;

    /**
     * 售价，整数方式保存
     */
    private Long priceFee;

    /**
     * 市场价，整数方式保存
     */
    private Long marketPriceFee;

    /**
     * 状态 1:enable, 0:disable, -1:deleted
     */
    private Integer status;

    private Integer hasSkuImg;

    /**
     * 序号
     */
    private Integer seq;

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Long getPriceFee() {
        return priceFee;
    }

    public void setPriceFee(Long priceFee) {
        this.priceFee = priceFee;
    }

    public Long getMarketPriceFee() {
        return marketPriceFee;
    }

    public void setMarketPriceFee(Long marketPriceFee) {
        this.marketPriceFee = marketPriceFee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public Integer getHasSkuImg() {
        return hasSkuImg;
    }

    public void setHasSkuImg(Integer hasSkuImg) {
        this.hasSkuImg = hasSkuImg;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "SpuBO{" +
                "spuId=" + spuId +
                ", brandId=" + brandId +
                ", categoryId=" + categoryId +
                ", shopId=" + shopId +
                ", name='" + name + '\'' +
                ", sellingPoint='" + sellingPoint + '\'' +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", imgUrls='" + imgUrls + '\'' +
                ", video='" + video + '\'' +
                ", priceFee=" + priceFee +
                ", marketPriceFee=" + marketPriceFee +
                ", status=" + status +
                ", hasSkuImg=" + hasSkuImg +
                ", seq=" + seq +
                '}';
    }
}
