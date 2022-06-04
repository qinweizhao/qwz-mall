package com.qinweizhao.cart.service.impl;

import com.qinweizhao.cart.mapper.CartItemMapper;
import com.qinweizhao.cart.model.entity.CartItem;
import com.qinweizhao.cart.service.CartItemService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/6/4
 */
@Service
public class CartItemServiceImpl extends QwzServiceImpl<CartItemMapper, CartItem> implements CartItemService{

    @Override
    public List<CartItem> listByMemberId(Long memberId) {
        return this.baseMapper.selectListByMemberId(memberId);
    }
}
