package com.qinweizhao.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_cart_item")
public class PmsCartItem extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
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
