package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsCoupon;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 优惠券信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsCouponMapper extends QwzBaseMapper<AmsCoupon> {

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
     * 删除优惠券信息
     *
     * @param id 优惠券信息主键
     * @return 结果
     */
    int deleteAmsCouponById(Long id);

    /**
     * 批量删除优惠券信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsCouponByIds(Long[] ids);
}
