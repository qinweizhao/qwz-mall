package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsCouponSpuRelation;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 优惠券与产品关联Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponSpuRelationService extends QwzService<AmsCouponSpuRelation> {


    /**
     * 查询优惠券与产品关联列表
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联集合
     */
    List<AmsCouponSpuRelation> selectAmsCouponSpuRelationList(AmsCouponSpuRelation amsCouponSpuRelation);

}
