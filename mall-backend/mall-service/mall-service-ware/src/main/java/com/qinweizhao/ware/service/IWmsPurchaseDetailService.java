package com.qinweizhao.ware.service;

import com.qinweizhao.ware.model.WmsPurchaseDetail;

import java.util.List;

/**
 * 采购单详情Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsPurchaseDetailService {
    /**
     * 查询采购单详情
     *
     * @param id 采购单详情主键
     * @return 采购单详情
     */
    WmsPurchaseDetail selectWmsPurchaseDetailById(Long id);

    /**
     * 查询采购单详情列表
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 采购单详情集合
     */
    List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 新增采购单详情
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 结果
     */
    int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 修改采购单详情
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 结果
     */
    int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 批量删除采购单详情
     *
     * @param ids 需要删除的采购单详情主键集合
     * @return 结果
     */
    int deleteWmsPurchaseDetailByIds(Long[] ids);

    /**
     * 删除采购单详情信息
     *
     * @param id 采购单详情主键
     * @return 结果
     */
    int deleteWmsPurchaseDetailById(Long id);
}
