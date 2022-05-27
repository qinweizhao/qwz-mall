package com.qinweizhao.product.model.dto;

import lombok.Data;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Data
public class SkuImageDTO {
    /**
     * sku_id
     */
    private Long skuId;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    private Integer defaultImage;

}
