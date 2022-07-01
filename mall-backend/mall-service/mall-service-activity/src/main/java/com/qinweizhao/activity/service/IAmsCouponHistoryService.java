package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsCouponHistory;

import java.util.List;

/**
 * 优惠券领取历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponHistoryService {
    /**
     * 查询优惠券领取历史记录
     *
     * @param id 优惠券领取历史记录主键
     * @return 优惠券领取历史记录
     */
    AmsCouponHistory selectAmsCouponHistoryById(Long id);

    /**
     * 查询优惠券领取历史记录列表
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录集合
     */
    List<AmsCouponHistory> selectAmsCouponHistoryList(AmsCouponHistory amsCouponHistory);

    /**
     * 新增优惠券领取历史记录
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 结果
     */
    int insertAmsCouponHistory(AmsCouponHistory amsCouponHistory);

    /**
     * 修改优惠券领取历史记录
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 结果
     */
    int updateAmsCouponHistory(AmsCouponHistory amsCouponHistory);

    /**
     * 批量删除优惠券领取历史记录
     *
     * @param ids 需要删除的优惠券领取历史记录主键集合
     * @return 结果
     */
    int deleteAmsCouponHistoryByIds(Long[] ids);

    /**
     * 删除优惠券领取历史记录信息
     *
     * @param id 优惠券领取历史记录主键
     * @return 结果
     */
    int deleteAmsCouponHistoryById(Long id);
}
