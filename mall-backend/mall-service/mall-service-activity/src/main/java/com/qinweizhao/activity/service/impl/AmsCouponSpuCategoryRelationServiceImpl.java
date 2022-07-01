package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsCouponSpuCategoryRelation;
import com.qinweizhao.activity.mapper.AmsCouponSpuCategoryRelationMapper;
import com.qinweizhao.activity.service.IAmsCouponSpuCategoryRelationService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券分类关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCouponSpuCategoryRelationServiceImpl implements IAmsCouponSpuCategoryRelationService {
    @Resource
    private AmsCouponSpuCategoryRelationMapper amsCouponSpuCategoryRelationMapper;

    /**
     * 查询优惠券分类关联
     *
     * @param id 优惠券分类关联主键
     * @return 优惠券分类关联
     */
    @Override
    public AmsCouponSpuCategoryRelation selectAmsCouponSpuCategoryRelationById(Long id) {
        return amsCouponSpuCategoryRelationMapper.selectAmsCouponSpuCategoryRelationById(id);
    }

    /**
     * 查询优惠券分类关联列表
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 优惠券分类关联
     */
    @Override
    public List<AmsCouponSpuCategoryRelation> selectAmsCouponSpuCategoryRelationList(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {
        return amsCouponSpuCategoryRelationMapper.selectAmsCouponSpuCategoryRelationList(amsCouponSpuCategoryRelation);
    }

    /**
     * 新增优惠券分类关联
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    @Override
    public int insertAmsCouponSpuCategoryRelation(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {
        amsCouponSpuCategoryRelation.setCreateTime(DateUtils.getNowDate());
        return amsCouponSpuCategoryRelationMapper.insertAmsCouponSpuCategoryRelation(amsCouponSpuCategoryRelation);
    }

    /**
     * 修改优惠券分类关联
     *
     * @param amsCouponSpuCategoryRelation 优惠券分类关联
     * @return 结果
     */
    @Override
    public int updateAmsCouponSpuCategoryRelation(AmsCouponSpuCategoryRelation amsCouponSpuCategoryRelation) {
        amsCouponSpuCategoryRelation.setUpdateTime(DateUtils.getNowDate());
        return amsCouponSpuCategoryRelationMapper.updateAmsCouponSpuCategoryRelation(amsCouponSpuCategoryRelation);
    }

    /**
     * 批量删除优惠券分类关联
     *
     * @param ids 需要删除的优惠券分类关联主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponSpuCategoryRelationByIds(Long[] ids) {
        return amsCouponSpuCategoryRelationMapper.deleteAmsCouponSpuCategoryRelationByIds(ids);
    }

    /**
     * 删除优惠券分类关联信息
     *
     * @param id 优惠券分类关联主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponSpuCategoryRelationById(Long id) {
        return amsCouponSpuCategoryRelationMapper.deleteAmsCouponSpuCategoryRelationById(id);
    }
}
