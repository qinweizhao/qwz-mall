package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsCartItem;

/**
 * 购物车Service接口
 *
 * @author qinweizhao
 * @date 2022-06-16
 */
public interface IPmsCartItemService {
    /**
     * 查询购物车
     *
     * @param cartItemId 购物车主键
     * @return 购物车
     */
        PmsCartItem selectPmsCartItemByCartItemId(String cartItemId);

    /**
     * 查询购物车列表
     *
     * @param pmsCartItem 购物车
     * @return 购物车集合
     */
    List<PmsCartItem> selectPmsCartItemList(PmsCartItem pmsCartItem);

    /**
     * 新增购物车
     *
     * @param pmsCartItem 购物车
     * @return 结果
     */
    int insertPmsCartItem(PmsCartItem pmsCartItem);

    /**
     * 修改购物车
     *
     * @param pmsCartItem 购物车
     * @return 结果
     */
    int updatePmsCartItem(PmsCartItem pmsCartItem);

    /**
     * 批量删除购物车
     *
     * @param cartItemIds 需要删除的购物车主键集合
     * @return 结果
     */
    int deletePmsCartItemByCartItemIds(String[] cartItemIds);

    /**
     * 删除购物车信息
     *
     * @param cartItemId 购物车主键
     * @return 结果
     */
    int deletePmsCartItemByCartItemId(String cartItemId);
}
