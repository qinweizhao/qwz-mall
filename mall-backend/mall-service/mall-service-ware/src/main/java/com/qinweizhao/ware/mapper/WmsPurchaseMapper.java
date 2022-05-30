package com.qinweizhao.ware.mapper;

import com.qinweizhao.ware.model.entity.WmsPurchase;

import java.util.List;

/**
 * 采购单Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface WmsPurchaseMapper {
    /**
     * 查询采购单
     *
     * @param id 采购单主键
     * @return 采购单
     */
    public WmsPurchase selectWmsPurchaseById(Long id);

    /**
     * 查询采购单列表
     *
     * @param wmsPurchase 采购单
     * @return 采购单集合
     */
    public List<WmsPurchase> selectWmsPurchaseList(WmsPurchase wmsPurchase);

    /**
     * 新增采购单
     *
     * @param wmsPurchase 采购单
     * @return 结果
     */
    public int insertWmsPurchase(WmsPurchase wmsPurchase);

    /**
     * 修改采购单
     *
     * @param wmsPurchase 采购单
     * @return 结果
     */
    public int updateWmsPurchase(WmsPurchase wmsPurchase);

    /**
     * 删除采购单
     *
     * @param id 采购单主键
     * @return 结果
     */
    public int deleteWmsPurchaseById(Long id);

    /**
     * 批量删除采购单
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsPurchaseByIds(Long[] ids);
}
