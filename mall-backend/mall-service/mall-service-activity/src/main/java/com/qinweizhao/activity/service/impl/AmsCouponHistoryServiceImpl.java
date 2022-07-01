package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsCouponHistory;
import com.qinweizhao.activity.mapper.AmsCouponHistoryMapper;
import com.qinweizhao.activity.service.IAmsCouponHistoryService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券领取历史记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCouponHistoryServiceImpl implements IAmsCouponHistoryService {
    @Resource
    private AmsCouponHistoryMapper amsCouponHistoryMapper;

    /**
     * 查询优惠券领取历史记录
     *
     * @param id 优惠券领取历史记录主键
     * @return 优惠券领取历史记录
     */
    @Override
    public AmsCouponHistory selectAmsCouponHistoryById(Long id) {
        return amsCouponHistoryMapper.selectAmsCouponHistoryById(id);
    }

    /**
     * 查询优惠券领取历史记录列表
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录
     */
    @Override
    public List<AmsCouponHistory> selectAmsCouponHistoryList(AmsCouponHistory amsCouponHistory) {
        return amsCouponHistoryMapper.selectAmsCouponHistoryList(amsCouponHistory);
    }

    /**
     * 新增优惠券领取历史记录
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 结果
     */
    @Override
    public int insertAmsCouponHistory(AmsCouponHistory amsCouponHistory) {
        amsCouponHistory.setCreateTime(DateUtils.getNowDate());
        return amsCouponHistoryMapper.insertAmsCouponHistory(amsCouponHistory);
    }

    /**
     * 修改优惠券领取历史记录
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 结果
     */
    @Override
    public int updateAmsCouponHistory(AmsCouponHistory amsCouponHistory) {
        amsCouponHistory.setUpdateTime(DateUtils.getNowDate());
        return amsCouponHistoryMapper.updateAmsCouponHistory(amsCouponHistory);
    }

    /**
     * 批量删除优惠券领取历史记录
     *
     * @param ids 需要删除的优惠券领取历史记录主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponHistoryByIds(Long[] ids) {
        return amsCouponHistoryMapper.deleteAmsCouponHistoryByIds(ids);
    }

    /**
     * 删除优惠券领取历史记录信息
     *
     * @param id 优惠券领取历史记录主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponHistoryById(Long id) {
        return amsCouponHistoryMapper.deleteAmsCouponHistoryById(id);
    }
}
