package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsCouponHistory;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 优惠券领取历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponHistoryService extends QwzService<AmsCouponHistory> {

    /**
     * 查询优惠券领取历史记录列表
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录集合
     */
    List<AmsCouponHistory> selectAmsCouponHistoryList(AmsCouponHistory amsCouponHistory);


}
