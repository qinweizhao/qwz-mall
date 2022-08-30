package com.qinweizhao.product.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Data
public class SkuInfoDTO {

    /**
     * skuId
     */
    private Long skuId;

    /**
     * spuId
     */
    private Long spuId;

    /**
     * sku名称
     */
    private String name;

    /**
     * sku介绍描述
     */
    private String description;

    /**
     * 所属分类id
     */
    private Long categoryId;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 默认图片
     */
    private String defaultImg;

    /**
     * 标题
     */
    private String title;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 销量
     */
    private Long saleCount;


    /**
     * 库存
     */
    private Long stock;

}