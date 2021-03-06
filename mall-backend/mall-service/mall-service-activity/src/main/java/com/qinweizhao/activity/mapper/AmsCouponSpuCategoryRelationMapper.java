package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsCouponSpuCategoryRelation;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 优惠券分类关联Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsCouponSpuCategoryRelationMapper extends QwzBaseMapper<AmsCouponSpuCategoryRelation> {
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
     * 删除优惠券分类关联
     *
     * @param id 优惠券分类关联主键
     * @return 结果
     */
    int deleteAmsCouponSpuCategoryRelationById(Long id);

    /**
     * 批量删除优惠券分类关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsCouponSpuCategoryRelationByIds(Long[] ids);
}
