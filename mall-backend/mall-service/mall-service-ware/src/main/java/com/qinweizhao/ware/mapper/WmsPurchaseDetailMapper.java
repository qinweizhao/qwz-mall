package com.qinweizhao.ware.mapper;

import com.qinweizhao.ware.domain.WmsPurchaseDetail;

import java.util.List;

/**
 * 采购单详情Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface WmsPurchaseDetailMapper {
    /**
     * 查询采购单详情
     *
     * @param id 采购单详情主键
     * @return 采购单详情
     */
    public WmsPurchaseDetail selectWmsPurchaseDetailById(Long id);

    /**
     * 查询采购单详情列表
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 采购单详情集合
     */
    public List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 新增采购单详情
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 结果
     */
    public int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 修改采购单详情
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 结果
     */
    public int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail);

    /**
     * 删除采购单详情
     *
     * @param id 采购单详情主键
     * @return 结果
     */
    public int deleteWmsPurchaseDetailById(Long id);

    /**
     * 批量删除采购单详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsPurchaseDetailByIds(Long[] ids);
}
