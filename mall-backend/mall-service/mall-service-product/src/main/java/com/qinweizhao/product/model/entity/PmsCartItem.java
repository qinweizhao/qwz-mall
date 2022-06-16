package com.qinweizhao.product.model.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * 购物车对象 pms_cart_item
 * 
 * @author qinweizhao
 * @date 2022-06-16
 */
public class PmsCartItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String cartItemId;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private String spuId;

    /** SkuID */
    @Excel(name = "SkuID")
    private String skuId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 购物车产品个数 */
    @Excel(name = "购物车产品个数")
    private Long count;

    /** 售价，加入购物车时的商品价格 */
    @Excel(name = "售价，加入购物车时的商品价格")
    private String priceFee;

    /** 是否已勾选 */
    @Excel(name = "是否已勾选")
    private Long checked;

    public void setCartItemId(String cartItemId) 
    {
        this.cartItemId = cartItemId;
    }

    public String getCartItemId() 
    {
        return cartItemId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setSpuId(String spuId) 
    {
        this.spuId = spuId;
    }

    public String getSpuId() 
    {
        return spuId;
    }
    public void setSkuId(String skuId) 
    {
        this.skuId = skuId;
    }

    public String getSkuId() 
    {
        return skuId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setPriceFee(String priceFee) 
    {
        this.priceFee = priceFee;
    }

    public String getPriceFee() 
    {
        return priceFee;
    }
    public void setChecked(Long checked) 
    {
        this.checked = checked;
    }

    public Long getChecked() 
    {
        return checked;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("cartItemId", getCartItemId())
            .append("shopId", getShopId())
            .append("spuId", getSpuId())
            .append("skuId", getSkuId())
            .append("userId", getUserId())
            .append("count", getCount())
            .append("priceFee", getPriceFee())
            .append("checked", getChecked())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
