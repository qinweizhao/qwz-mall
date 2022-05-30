package com.qinweizhao.ware.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.ware.model.entity.WmsPurchaseDetail;
import com.qinweizhao.ware.mapper.WmsPurchaseDetailMapper;
import com.qinweizhao.ware.service.IWmsPurchaseDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 采购单详情Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Service
public class WmsPurchaseDetailServiceImpl implements IWmsPurchaseDetailService {
    @Resource
    private WmsPurchaseDetailMapper wmsPurchaseDetailMapper;

    /**
     * 查询采购单详情
     *
     * @param id 采购单详情主键
     * @return 采购单详情
     */
    @Override
    public WmsPurchaseDetail selectWmsPurchaseDetailById(Long id) {
        return wmsPurchaseDetailMapper.selectWmsPurchaseDetailById(id);
    }

    /**
     * 查询采购单详情列表
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 采购单详情
     */
    @Override
    public List<WmsPurchaseDetail> selectWmsPurchaseDetailList(WmsPurchaseDetail wmsPurchaseDetail) {
        return wmsPurchaseDetailMapper.selectWmsPurchaseDetailList(wmsPurchaseDetail);
    }

    /**
     * 新增采购单详情
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 结果
     */
    @Override
    public int insertWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail) {
        wmsPurchaseDetail.setCreateTime(DateUtils.getNowDate());
        return wmsPurchaseDetailMapper.insertWmsPurchaseDetail(wmsPurchaseDetail);
    }

    /**
     * 修改采购单详情
     *
     * @param wmsPurchaseDetail 采购单详情
     * @return 结果
     */
    @Override
    public int updateWmsPurchaseDetail(WmsPurchaseDetail wmsPurchaseDetail) {
        wmsPurchaseDetail.setUpdateTime(DateUtils.getNowDate());
        return wmsPurchaseDetailMapper.updateWmsPurchaseDetail(wmsPurchaseDetail);
    }

    /**
     * 批量删除采购单详情
     *
     * @param ids 需要删除的采购单详情主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseDetailByIds(Long[] ids) {
        return wmsPurchaseDetailMapper.deleteWmsPurchaseDetailByIds(ids);
    }

    /**
     * 删除采购单详情信息
     *
     * @param id 采购单详情主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseDetailById(Long id) {
        return wmsPurchaseDetailMapper.deleteWmsPurchaseDetailById(id);
    }
}
