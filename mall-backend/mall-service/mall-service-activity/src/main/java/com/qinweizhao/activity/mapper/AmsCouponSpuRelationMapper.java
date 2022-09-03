package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsCouponSpuRelation;
import com.qinweizhao.component.mybatis.mapper.QwzMapper;

import java.util.List;

/**
 * 优惠券与产品关联Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsCouponSpuRelationMapper extends QwzMapper<AmsCouponSpuRelation> {
    /**
     * 查询优惠券与产品关联
     *
     * @param id 优惠券与产品关联主键
     * @return 优惠券与产品关联
     */
    AmsCouponSpuRelation selectAmsCouponSpuRelationById(Long id);

    /**
     * 查询优惠券与产品关联列表
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联集合
     */
    List<AmsCouponSpuRelation> selectAmsCouponSpuRelationList(AmsCouponSpuRelation amsCouponSpuRelation);

    /**
     * 新增优惠券与产品关联
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    int insertAmsCouponSpuRelation(AmsCouponSpuRelation amsCouponSpuRelation);

    /**
     * 修改优惠券与产品关联
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    int updateAmsCouponSpuRelation(AmsCouponSpuRelation amsCouponSpuRelation);

    /**
     * 删除优惠券与产品关联
     *
     * @param id 优惠券与产品关联主键
     * @return 结果
     */
    int deleteAmsCouponSpuRelationById(Long id);

    /**
     * 批量删除优惠券与产品关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsCouponSpuRelationByIds(Long[] ids);
}
