package com.qinweizhao.product.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.product.model.dto.CartItemDTO;
import com.qinweizhao.product.model.entity.PmsCartItem;

import java.util.List;

/**
 * 购物车Service接口
 *
 * @author qinweizhao
 * @date 2022-06-16
 */
public interface PmsCartService extends QwzService<PmsCartItem> {

    /**
     * 查询购物车
     * @param memberId memberId
     * @return memberId
     */
    List<CartItemDTO> listByMemberId(Long memberId);

    /**
     * 清空购物车
     * @return boolean
     */
    boolean removeCart();

    /**
     * 添加商品到购物车
     * @param skuId skuId
     * @return boolean
     */
    boolean saveCartItem(Long skuId);

    /**
     * 全选
     * @param checked checked
     * @return boolean
     */
    boolean checkAll(boolean checked);

    /**
     * 从购物车移除商品
     * @param skuId skuId
     * @return boolean
     */
    boolean removeCartItem(Long skuId);

    /**
     * 更新购物车中的商品
     * @param cartItem cartItem
     * @return boolean
     */
    boolean updateCartItem(PmsCartItem cartItem);
}
