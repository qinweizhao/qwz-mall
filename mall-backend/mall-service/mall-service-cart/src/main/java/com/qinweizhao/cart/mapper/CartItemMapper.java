package com.qinweizhao.cart.mapper;

import com.qinweizhao.cart.model.entity.CartItem;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/6/4
 */
public interface CartItemMapper extends QwzBaseMapper<CartItem> {

    /**
     * 通过会员 id 查询所有购物车中的购物项
     *
     * @param memberId memberId
     * @return List
     */
    default List<CartItem> selectListByMemberId(Long memberId) {
        return selectList(new QwzLambdaQueryWrapper<CartItem>().eq(CartItem::getUserId, memberId));
    }
}
