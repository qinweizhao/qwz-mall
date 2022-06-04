package com.qinweizhao.cart.controller;

import com.qinweizhao.cart.model.entity.CartItem;
import com.qinweizhao.cart.service.CartItemService;
import com.qinweizhao.cart.service.CartService;
import com.qinweizhao.component.core.response.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/6/2
 */
@RestController
@RequestMapping("/shop-cart")
public class CartController {

    @Resource
    private CartService cartService;

    @Resource
    private CartItemService cartItemService;

    @GetMapping("get")
    public R<?> get() {
        Long memberId = 123L;
        List<CartItem> list = cartItemService.listByMemberId(memberId);
        return R.success();
    }
}
