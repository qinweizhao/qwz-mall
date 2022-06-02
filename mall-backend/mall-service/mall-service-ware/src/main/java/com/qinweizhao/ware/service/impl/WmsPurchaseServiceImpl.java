package com.qinweizhao.ware.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.ware.model.entity.WmsPurchase;
import com.qinweizhao.ware.mapper.WmsPurchaseMapper;
import com.qinweizhao.ware.service.IWmsPurchaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 采购单Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Service
public class WmsPurchaseServiceImpl implements IWmsPurchaseService {
    @Resource
    private WmsPurchaseMapper wmsPurchaseMapper;

    /**
     * 查询采购单
     *
     * @param id 采购单主键
     * @return 采购单
     */
    @Override
    public WmsPurchase selectWmsPurchaseById(Long id) {
        return wmsPurchaseMapper.selectWmsPurchaseById(id);
    }

    /**
     * 查询采购单列表
     *
     * @param wmsPurchase 采购单
     * @return 采购单
     */
    @Override
    public List<WmsPurchase> selectWmsPurchaseList(WmsPurchase wmsPurchase) {
        return wmsPurchaseMapper.selectWmsPurchaseList(wmsPurchase);
    }

    /**
     * 新增采购单
     *
     * @param wmsPurchase 采购单
     * @return 结果
     */
    @Override
    public int insertWmsPurchase(WmsPurchase wmsPurchase) {
        return wmsPurchaseMapper.insertWmsPurchase(wmsPurchase);
    }

    /**
     * 修改采购单
     *
     * @param wmsPurchase 采购单
     * @return 结果
     */
    @Override
    public int updateWmsPurchase(WmsPurchase wmsPurchase) {
        return wmsPurchaseMapper.updateWmsPurchase(wmsPurchase);
    }

    /**
     * 批量删除采购单
     *
     * @param ids 需要删除的采购单主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseByIds(Long[] ids) {
        return wmsPurchaseMapper.deleteWmsPurchaseByIds(ids);
    }

    /**
     * 删除采购单信息
     *
     * @param id 采购单主键
     * @return 结果
     */
    @Override
    public int deleteWmsPurchaseById(Long id) {
        return wmsPurchaseMapper.deleteWmsPurchaseById(id);
    }
}
