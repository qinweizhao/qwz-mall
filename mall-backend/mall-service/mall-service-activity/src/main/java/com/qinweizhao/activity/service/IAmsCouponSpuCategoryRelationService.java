package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsCouponSpuCategoryRelation;

import java.util.List;

/**
 * 优惠券分类关联Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCouponSpuCategoryRelationService {
    /**
     * 查询优惠券分类关联
     *
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    AmsCouponSpuCategoryRelation selectAmsCouponSpuCategoryRelationById(Long id);

    /**
     * 查询优惠券分类关联列表
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联集合
     */
    List<AmsCouponSpuCategoryRelation> selectAmsCouponSpuCategoryRelationList(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation);

    /**
     * 新增优惠券分类关联
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    int insertAmsCouponSpuCategoryRelation(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation);

    /**
     * 修改优惠券分类关联
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    int updateAmsCouponSpuCategoryRelation(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation);

    /**
     * 批量删除优惠券分类关联
     *
     * @param ids 需要删除的优惠券分类关联主键集合
     * @return 结果
     */
    int deleteAmsCouponSpuCategoryRelationByIds(Long[] ids);

    /**
     * 删除优惠券分类关联信息
     *
     * @param id 优惠券分类关联主键
     * @return 结果
     */
    int deleteAmsCouponSpuCategoryRelationById(Long id);
}
