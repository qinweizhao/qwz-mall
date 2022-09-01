package com.qinweizhao.product.model.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
public class SkuDTO {


    /**
     * 编号
     */
    private Long id;

    /**
     * spu编号
     */
    private Long spuId;

    /**
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 体积
     */
    private BigDecimal volume;

    /**
     * 销量
     */
    private Long saleCount;

    /**
     * 价格
     */
    private BigDecimal price;

     


}
