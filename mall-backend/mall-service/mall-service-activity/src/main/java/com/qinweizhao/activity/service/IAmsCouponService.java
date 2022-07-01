package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsCoupon;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 优惠券信息Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponService extends QwzService<AmsCoupon> {

    /**
     * 查询优惠券信息列表
     *
     * @param amsCoupon 优惠券信息
     * @return 优惠券信息集合
     */
    List<AmsCoupon> selectAmsCouponList(AmsCoupon amsCoupon);


}
