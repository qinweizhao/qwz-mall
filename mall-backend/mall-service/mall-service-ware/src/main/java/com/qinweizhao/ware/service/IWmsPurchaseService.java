package com.qinweizhao.ware.service;

import com.qinweizhao.ware.model.entity.WmsPurchase;

import java.util.List;

/**
 * 采购单Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsPurchaseService {
    /**
     * 查询采购单
     *
     * @param id 采购单主键
     * @return 采购单
     */
    WmsPurchase selectWmsPurchaseById(Long id);

    /**
     * 查询采购单列表
     *
     * @param wmsPurchase 采购单
     * @return 采购单集合
     */
    List<WmsPurchase> selectWmsPurchaseList(WmsPurchase wmsPurchase);

    /**
     * 新增采购单
     *
     * @param wmsPurchase 采购单
     * @return 结果
     */
    int insertWmsPurchase(WmsPurchase wmsPurchase);

    /**
     * 修改采购单
     *
     * @param wmsPurchase 采购单
     * @return 结果
     */
    int updateWmsPurchase(WmsPurchase wmsPurchase);

    /**
     * 批量删除采购单
     *
     * @param ids 需要删除的采购单主键集合
     * @return 结果
     */
    int deleteWmsPurchaseByIds(Long[] ids);

    /**
     * 删除采购单信息
     *
     * @param id 采购单主键
     * @return 结果
     */
    int deleteWmsPurchaseById(Long id);
}
