package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsCouponMapper;
import com.qinweizhao.activity.model.entity.AmsCoupon;
import com.qinweizhao.activity.service.IAmsCouponService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
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
public class AmsCouponServiceImpl extends QwzServiceImpl<AmsCouponMapper, AmsCoupon> implements IAmsCouponService {
    @Resource
    private AmsCouponMapper amsCouponMapper;


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


}
