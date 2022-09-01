package com.qinweizhao.product.model.dto;

import lombok.Data;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
public class CartItemDTO {


    /**
     * 编号
     */
    private Long id;

    /**
     * spu编号
     */
    private Long spuId;

    /**
     * sku编号
     */
    private Long skuId;

    /**
     * 用户编号
     */
    private Long memberId;

    /**
     * 产品个数
     */
    private Integer count;

    /**
     * 售价;加入购物车时的商品价格
     */
    private Long priceFee;

    /**
     * 是否已勾选
     */
    private Integer checked;


}
