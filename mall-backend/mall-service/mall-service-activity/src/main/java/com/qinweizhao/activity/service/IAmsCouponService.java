package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsCoupon;

import java.util.List;

/**
 * 优惠券信息Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponService {
    /**
     * 查询优惠券信息
     *
     * @param id 优惠券信息主键
     * @return 优惠券信息
     */
    AmsCoupon selectAmsCouponById(Long id);

    /**
     * 查询优惠券信息列表
     *
     * @param amsCoupon 优惠券信息
     * @return 优惠券信息集合
     */
    List<AmsCoupon> selectAmsCouponList(AmsCoupon amsCoupon);

    /**
     * 新增优惠券信息
     *
     * @param amsCoupon 优惠券信息
     * @return 结果
     */
    int insertAmsCoupon(AmsCoupon amsCoupon);

    /**
     * 修改优惠券信息
     *
     * @param amsCoupon 优惠券信息
     * @return 结果
     */
    int updateAmsCoupon(AmsCoupon amsCoupon);

    /**
     * 批量删除优惠券信息
     *
     * @param ids 需要删除的优惠券信息主键集合
     * @return 结果
     */
    int deleteAmsCouponByIds(Long[] ids);

    /**
     * 删除优惠券信息信息
     *
     * @param id 优惠券信息主键
     * @return 结果
     */
    int deleteAmsCouponById(Long id);
}
