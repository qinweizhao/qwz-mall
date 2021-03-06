package com.qinweizhao.product.controller.app;

import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.model.dto.CartItemDTO;
import com.qinweizhao.product.model.entity.PmsCartItem;
import com.qinweizhao.product.service.IPmsCartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/6/17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/app/cart")
public class CartController {

    private final IPmsCartService pmsCartItemService;

    @GetMapping
    public R<List<CartItemDTO>> getCart() {
        Long memberId = SecurityUtils.getUserId();
        List<CartItemDTO> result = pmsCartItemService.listByMemberId(memberId);
        return R.success(result);
    }

    @DeleteMapping
    public R<Boolean> removeAll() {
        boolean result = pmsCartItemService.removeCart();
        return R.success(result);
    }

    @PostMapping
    public R<Boolean> addCartItem(@RequestParam Long skuId) {
        boolean result = pmsCartItemService.saveCartItem(skuId);
        return R.success(result);
    }

    @PutMapping("/skuId/{skuId}")
    public R<?> updateCartItem(@PathVariable Long skuId, @RequestBody PmsCartItem cartItem) {
        cartItem.setSkuId(skuId);
        boolean result = pmsCartItemService.updateCartItem(cartItem);
        return R.success(result);
    }

    @DeleteMapping("/skuId/{skuId}")
    public R<?> removeCartItem(@PathVariable Long skuId) {
        boolean result = pmsCartItemService.removeCartItem(skuId);
        return R.success(result);
    }

    @PatchMapping("/check")
    public R<?> check(boolean checked) {
        boolean result = pmsCartItemService.checkAll(checked);
        return R.success(result);
    }

}
