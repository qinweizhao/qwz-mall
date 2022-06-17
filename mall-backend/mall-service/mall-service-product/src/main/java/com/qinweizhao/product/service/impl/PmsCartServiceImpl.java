package com.qinweizhao.product.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.product.constant.CartConstant;
import com.qinweizhao.product.convert.CartItemConvert;
import com.qinweizhao.product.model.dto.CartItemDTO;
import com.qinweizhao.product.model.entity.PmsCartItem;
import com.qinweizhao.product.model.entity.PmsSkuInfo;
import com.qinweizhao.product.service.IPmsCartService;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
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
    private StringRedisTemplate redisTemplate;

    @Resource
    private IPmsSkuInfoService pmsSkuInfoService;

    @Override
    public List<CartItemDTO> listByMemberId(Long memberId) {
        BoundHashOperations<String, Object, PmsCartItem> operations = getCartHashOperations(memberId);
        return CartItemConvert.INSTANCE.convertToDTO(operations.values());
    }

    @Override
    public boolean removeCart() {
        String cartKey = CartConstant.CART_PREFIX + SecurityUtils.getUserId();
        return Boolean.TRUE.equals(redisTemplate.delete(cartKey));
    }

    @Override
    public boolean saveCartItem(Long skuId) {
        Long memberId = SecurityUtils.getUserId();
        BoundHashOperations<String, Object, PmsCartItem> operations = this.getCartHashOperations(memberId);
        String hKey = skuId + "";

        PmsCartItem cartItem;
        // 购物车已存在该商品，更新商品数量
        if (operations.get(hKey) != null) {
            cartItem = operations.get(hKey);
            // 点击一次“加入购物车”，数量+1
            assert cartItem != null;
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setChecked(true);
            operations.put(hKey, cartItem);
            return true;
        }
        // 购物车不存在该商品，添加商品至购物车
        cartItem = new PmsCartItem();
        CompletableFuture<Void> cartItemCompletableFuture = CompletableFuture.runAsync(() -> {
            PmsSkuInfo skuInfo = pmsSkuInfoService.getById(skuId);
            if (skuInfo != null) {
                BeanUtil.copyProperties(skuInfo, cartItem);
                cartItem.setCount(1L);
                cartItem.setChecked(true);
            }
        });
        CompletableFuture.allOf(cartItemCompletableFuture).join();

        Assert.isTrue(cartItem.getSkuId() != null, "商品不存在");
        operations.put(hKey, cartItem);
        return true;
    }

    @Override
    public boolean updateCartItem(PmsCartItem cartItem) {
        Long memberId = SecurityUtils.getUserId();
        BoundHashOperations<String, Object, PmsCartItem> cartHashOperations = this.getCartHashOperations(memberId);
        String hKey = cartItem.getSkuId() + "";
        if (cartHashOperations.get(hKey) != null) {
            PmsCartItem cacheCartItem = cartHashOperations.get(hKey);
            assert cacheCartItem != null;
            if (cartItem.getChecked() != null) {
                cacheCartItem.setChecked(cartItem.getChecked());
            }
            if (cartItem.getCount() != null) {
                cacheCartItem.setCount(cartItem.getCount());
            }
            cartHashOperations.put(hKey, cacheCartItem);
        }
        return true;
    }

    @Override
    public boolean checkAll(boolean checked) {
        Long memberId = SecurityUtils.getUserId();
        BoundHashOperations<String, Object, PmsCartItem> cartHashOperations = this.getCartHashOperations(memberId);
        for (PmsCartItem cartItem : Objects.requireNonNull(cartHashOperations.values())) {
            cartItem.setChecked(checked);
            String hKey = cartItem.getSkuId() + "";
            cartHashOperations.put(hKey, cartItem);
        }
        return true;
    }

    @Override
    public boolean removeCartItem(Long skuId) {
        Long memberId = SecurityUtils.getUserId();
        BoundHashOperations<String, Object, PmsCartItem> cartHashOperations = this.getCartHashOperations(memberId);
        String hKey = skuId + "";
        cartHashOperations.delete(hKey);
        return true;
    }

    /**
     * 获取 HashOperations
     *
     * @param memberId memberId
     * @return BoundHashOperations
     */
    private BoundHashOperations<String, Object, PmsCartItem> getCartHashOperations(Long memberId) {
        String cartKey = CartConstant.CART_PREFIX + memberId;
        return redisTemplate.boundHashOps(cartKey);
    }

}
