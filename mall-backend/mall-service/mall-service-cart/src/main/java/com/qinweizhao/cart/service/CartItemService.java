package com.qinweizhao.cart.service;

import com.qinweizhao.cart.model.entity.CartItem;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/6/4
 */
public interface CartItemService extends QwzService<CartItem> {

    /**
     * 通过会员 id 查询所有购物车中的购物项
     * @param memberId memberId
     * @return List
     */
    List<CartItem> listByMemberId(Long memberId);
}
