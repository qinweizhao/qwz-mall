package com.qinweizhao.product.service.impl;

import java.util.List;
import com.qinweizhao.common.core.utils.DateUtils;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.qinweizhao.product.mapper.PmsCartItemMapper;
import com.qinweizhao.product.domain.PmsCartItem;
import com.qinweizhao.product.service.IPmsCartItemService;

/**
 * 购物车Service业务层处理
 * 
 * @author qinweizhao
 * @date 2022-06-16
 */
@Service
public class PmsCartItemServiceImpl implements IPmsCartItemService {
    @Resource
    private PmsCartItemMapper pmsCartItemMapper;

    /**
     * 查询购物车
     * 
     * @param cartItemId 购物车主键
     * @return 购物车
     */
    @Override
    public PmsCartItem selectPmsCartItemByCartItemId(String cartItemId)
    {
        return pmsCartItemMapper.selectPmsCartItemByCartItemId(cartItemId);
    }

    /**
     * 查询购物车列表
     * 
     * @param pmsCartItem 购物车
     * @return 购物车
     */
    @Override
    public List<PmsCartItem> selectPmsCartItemList(PmsCartItem pmsCartItem)
    {
        return pmsCartItemMapper.selectPmsCartItemList(pmsCartItem);
    }

    /**
     * 新增购物车
     * 
     * @param pmsCartItem 购物车
     * @return 结果
     */
    @Override
    public int insertPmsCartItem(PmsCartItem pmsCartItem)
    {
        pmsCartItem.setCreateTime(DateUtils.getNowDate());
        return pmsCartItemMapper.insertPmsCartItem(pmsCartItem);
    }

    /**
     * 修改购物车
     * 
     * @param pmsCartItem 购物车
     * @return 结果
     */
    @Override
    public int updatePmsCartItem(PmsCartItem pmsCartItem)
    {
        pmsCartItem.setUpdateTime(DateUtils.getNowDate());
        return pmsCartItemMapper.updatePmsCartItem(pmsCartItem);
    }

    /**
     * 批量删除购物车
     * 
     * @param cartItemIds 需要删除的购物车主键
     * @return 结果
     */
    @Override
    public int deletePmsCartItemByCartItemIds(String[] cartItemIds)
    {
        return pmsCartItemMapper.deletePmsCartItemByCartItemIds(cartItemIds);
    }

    /**
     * 删除购物车信息
     * 
     * @param cartItemId 购物车主键
     * @return 结果
     */
    @Override
    public int deletePmsCartItemByCartItemId(String cartItemId)
    {
        return pmsCartItemMapper.deletePmsCartItemByCartItemId(cartItemId);
    }
}
