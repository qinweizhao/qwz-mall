package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsCouponHistoryMapper;
import com.qinweizhao.activity.model.entity.AmsCouponHistory;
import com.qinweizhao.activity.service.IAmsCouponHistoryService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优惠券领取历史记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCouponHistoryServiceImpl extends QwzServiceImpl<AmsCouponHistoryMapper, AmsCouponHistory> implements IAmsCouponHistoryService {


    /**
     * 查询优惠券领取历史记录列表
     *
     * @param amsCouponHistory 优惠券领取历史记录
     * @return 优惠券领取历史记录
     */
    @Override
    public List<AmsCouponHistory> selectAmsCouponHistoryList(AmsCouponHistory amsCouponHistory) {
        return this.baseMapper.selectAmsCouponHistoryList(amsCouponHistory);
    }

}
