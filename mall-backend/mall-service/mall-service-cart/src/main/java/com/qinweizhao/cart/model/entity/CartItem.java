package com.qinweizhao.cart.model.entity;


import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车对象 cms_cart_item
 *
 * @author qinweizhao
 * @date 2022-06-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CartItem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String cartItemId;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 产品ID
     */
    private String spuId;

    /**
     * SkuID
     */
    private String skuId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 购物车产品个数
     */
    private Long count;

    /**
     * 售价，加入购物车时的商品价格
     */
    private String priceFee;

    /**
     * 是否已勾选
     */
    private Long checked;

}
