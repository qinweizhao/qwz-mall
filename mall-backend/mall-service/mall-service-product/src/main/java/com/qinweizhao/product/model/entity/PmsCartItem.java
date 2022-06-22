package com.qinweizhao.product.model.entity;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 购物车对象 pms_cart_item
 * 
 * @author qinweizhao
 * @date 2022-06-16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PmsCartItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String cartItemId;

    /** 店铺ID */
    private Long shopId;

    /** 产品ID */
    private String spuId;

    /** SkuID */
    private Long skuId;

    /** 用户ID */
    private String userId;

    /** 购物车产品个数 */
    private Long count;

    /** 售价，加入购物车时的商品价格 */
    private String priceFee;

    /** 是否已勾选 */
    private Boolean checked;


}
