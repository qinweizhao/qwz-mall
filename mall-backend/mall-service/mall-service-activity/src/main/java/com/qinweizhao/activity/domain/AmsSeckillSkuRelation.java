package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 秒杀活动商品关联对象 ams_seckill_sku_relation
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsSeckillSkuRelation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 活动id
     */
    @Excel(name = "活动id")
    private Long promotionId;

    /**
     * 活动场次id
     */
    @Excel(name = "活动场次id")
    private Long promotionSessionId;

    /**
     * 商品id
     */
    @Excel(name = "商品id")
    private Long skuId;

    /**
     * 秒杀价格
     */
    @Excel(name = "秒杀价格")
    private Long seckillPrice;

    /**
     * 秒杀总量
     */
    @Excel(name = "秒杀总量")
    private Long seckillCount;

    /**
     * 每人限购数量
     */
    @Excel(name = "每人限购数量")
    private Long seckillLimit;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long seckillSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public Long getPromotionSessionId() {
        return promotionSessionId;
    }

    public void setPromotionSessionId(Long promotionSessionId) {
        this.promotionSessionId = promotionSessionId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSeckillPrice() {
        return seckillPrice;
    }

    public void setSeckillPrice(Long seckillPrice) {
        this.seckillPrice = seckillPrice;
    }

    public Long getSeckillCount() {
        return seckillCount;
    }

    public void setSeckillCount(Long seckillCount) {
        this.seckillCount = seckillCount;
    }

    public Long getSeckillLimit() {
        return seckillLimit;
    }

    public void setSeckillLimit(Long seckillLimit) {
        this.seckillLimit = seckillLimit;
    }

    public Long getSeckillSort() {
        return seckillSort;
    }

    public void setSeckillSort(Long seckillSort) {
        this.seckillSort = seckillSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("promotionId", getPromotionId())
                .append("promotionSessionId", getPromotionSessionId())
                .append("skuId", getSkuId())
                .append("seckillPrice", getSeckillPrice())
                .append("seckillCount", getSeckillCount())
                .append("seckillLimit", getSeckillLimit())
                .append("seckillSort", getSeckillSort())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
