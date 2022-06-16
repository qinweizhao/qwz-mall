package com.qinweizhao.product.mapper;

import java.util.List;
import com.qinweizhao.product.domain.PmsCartItem;

/**
 * 购物车Mapper接口
 * 
 * @author qinweizhao
 * @date 2022-06-16
 */
public interface PmsCartItemMapper 
{
    /**
     * 查询购物车
     * 
     * @param cartItemId 购物车主键
     * @return 购物车
     */
    public PmsCartItem selectPmsCartItemByCartItemId(String cartItemId);

    /**
     * 查询购物车列表
     * 
     * @param pmsCartItem 购物车
     * @return 购物车集合
     */
    public List<PmsCartItem> selectPmsCartItemList(PmsCartItem pmsCartItem);

    /**
     * 新增购物车
     * 
     * @param pmsCartItem 购物车
     * @return 结果
     */
    public int insertPmsCartItem(PmsCartItem pmsCartItem);

    /**
     * 修改购物车
     * 
     * @param pmsCartItem 购物车
     * @return 结果
     */
    public int updatePmsCartItem(PmsCartItem pmsCartItem);

    /**
     * 删除购物车
     * 
     * @param cartItemId 购物车主键
     * @return 结果
     */
    public int deletePmsCartItemByCartItemId(String cartItemId);

    /**
     * 批量删除购物车
     * 
     * @param cartItemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsCartItemByCartItemIds(String[] cartItemIds);
}
