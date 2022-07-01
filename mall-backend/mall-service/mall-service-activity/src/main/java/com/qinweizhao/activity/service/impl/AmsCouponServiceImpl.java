package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsCoupon;
import com.qinweizhao.activity.mapper.AmsCouponMapper;
import com.qinweizhao.activity.service.IAmsCouponService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCouponServiceImpl implements IAmsCouponService {
    @Resource
    private AmsCouponMapper amsCouponMapper;

    /**
     * 查询优惠券信息
     *
     * @param id 优惠券信息主键
     * @return 优惠券信息
     */
    @Override
    public AmsCoupon selectAmsCouponById(Long id) {
        return amsCouponMapper.selectAmsCouponById(id);
    }

    /**
     * 查询优惠券信息列表
     *
     * @param amsCoupon 优惠券信息
     * @return 优惠券信息
     */
    @Override
    public List<AmsCoupon> selectAmsCouponList(AmsCoupon amsCoupon) {
        return amsCouponMapper.selectAmsCouponList(amsCoupon);
    }

    /**
     * 新增优惠券信息
     *
     * @param amsCoupon 优惠券信息
     * @return 结果
     */
    @Override
    public int insertAmsCoupon(AmsCoupon amsCoupon) {
        amsCoupon.setCreateTime(DateUtils.getNowDate());
        return amsCouponMapper.insertAmsCoupon(amsCoupon);
    }

    /**
     * 修改优惠券信息
     *
     * @param amsCoupon 优惠券信息
     * @return 结果
     */
    @Override
    public int updateAmsCoupon(AmsCoupon amsCoupon) {
        amsCoupon.setUpdateTime(DateUtils.getNowDate());
        return amsCouponMapper.updateAmsCoupon(amsCoupon);
    }

    /**
     * 批量删除优惠券信息
     *
     * @param ids 需要删除的优惠券信息主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponByIds(Long[] ids) {
        return amsCouponMapper.deleteAmsCouponByIds(ids);
    }

    /**
     * 删除优惠券信息信息
     *
     * @param id 优惠券信息主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponById(Long id) {
        return amsCouponMapper.deleteAmsCouponById(id);
    }
}
