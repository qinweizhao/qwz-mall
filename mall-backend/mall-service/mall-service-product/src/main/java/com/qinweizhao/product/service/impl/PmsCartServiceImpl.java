package com.qinweizhao.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.product.constant.CartConstant;
import com.qinweizhao.product.model.dto.CartItemDTO;
import com.qinweizhao.product.model.entity.PmsSkuInfo;
import com.qinweizhao.product.service.IPmsCartService;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 购物车Service业务层处理
 * 
 * @author qinweizhao
 * @date 2022-06-16
 */
@Service
public class PmsCartServiceImpl implements IPmsCartService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private IPmsSkuInfoService pmsSkuInfoService;

    @Override
    public List<CartItemDTO> listByMemberId(Long memberId) {
        String cartKey = CartConstant.CART_PREFIX + memberId;
        BoundHashOperations<String, Object, CartItemDTO> operations = redisTemplate.boundHashOps(cartKey);
        return operations.values();
    }

    @Override
    public void removeCart() {
        String cartKey = CartConstant.CART_PREFIX + SecurityUtils.getUserId();
        redisTemplate.delete(cartKey);
    }

    @Override
    public void saveCartItem(Long skuId) {
        Long memberId = SecurityUtils.getUserId();
        String cartKey = String.valueOf(memberId);
        BoundHashOperations<String, Object, CartItemDTO> operations = redisTemplate.boundHashOps(cartKey);
        String hKey = skuId + "";

        CartItemDTO cartItem;
        // 购物车已存在该商品，更新商品数量
        if (operations.get(hKey) != null) {
            cartItem = operations.get(hKey);
            // 点击一次“加入购物车”，数量+1
            assert cartItem != null;
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setChecked(1L);
            operations.put(hKey, cartItem);
//            return true;
        }
        // 购物车不存在该商品，添加商品至购物车
        cartItem = new CartItemDTO();
        CartItemDTO finalCartItem = cartItem;
        CompletableFuture<Void> cartItemCompletableFuture = CompletableFuture.runAsync(() -> {
            PmsSkuInfo skuInfo = pmsSkuInfoService.getById(skuId);
            if (skuInfo != null) {
                BeanUtil.copyProperties(skuInfo, finalCartItem);
//                finalCartItem.setStock(skuInfo.getStockNum());
//                finalCartItem.setCount(1);
//                finalCartItem.setChecked(true);
            }
        });
        CompletableFuture.allOf(cartItemCompletableFuture).join();

        Assert.isTrue(cartItem.getSkuId() != null,"商品不存在");
        operations.put(hKey, cartItem);
//        return true;
    }

    @Override
    public boolean checkAll(boolean checked) {
        return false;
    }

    @Override
    public boolean removeCartItem(Long skuId) {
        return false;
    }

    @Override
    public boolean updateCartItem(CartItemDTO cartItem) {
        return false;
    }
}
