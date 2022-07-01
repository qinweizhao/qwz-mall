package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsCouponSpuCategoryRelation;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 优惠券分类关联Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponSpuCategoryRelationService extends QwzService<AmsCouponSpuCategoryRelation> {

    /**
     * 查询优惠券分类关联列表
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联集合
     */
    List<AmsCouponSpuCategoryRelation> selectAmsCouponSpuCategoryRelationList(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation);

}
