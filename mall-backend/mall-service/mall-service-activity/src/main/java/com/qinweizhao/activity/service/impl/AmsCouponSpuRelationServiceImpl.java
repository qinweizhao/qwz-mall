package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsCouponSpuRelationMapper;
import com.qinweizhao.activity.model.entity.AmsCouponSpuRelation;
import com.qinweizhao.activity.service.IAmsCouponSpuRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 优惠券与产品关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCouponSpuRelationServiceImpl implements IAmsCouponSpuRelationService {
    @Resource
    private AmsCouponSpuRelationMapper amsCouponSpuRelationMapper;

    /**
     * 查询优惠券与产品关联
     *
     * @param id 优惠券与产品关联主键
     * @return 优惠券与产品关联
     */
    @Override
    public AmsCouponSpuRelation selectAmsCouponSpuRelationById(Long id) {
        return amsCouponSpuRelationMapper.selectAmsCouponSpuRelationById(id);
    }

    /**
     * 查询优惠券与产品关联列表
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 优惠券与产品关联
     */
    @Override
    public List<AmsCouponSpuRelation> selectAmsCouponSpuRelationList(AmsCouponSpuRelation amsCouponSpuRelation) {
        return amsCouponSpuRelationMapper.selectAmsCouponSpuRelationList(amsCouponSpuRelation);
    }

    /**
     * 新增优惠券与产品关联
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int insertAmsCouponSpuRelation(AmsCouponSpuRelation amsCouponSpuRelation) {
        amsCouponSpuRelation.setCreateTime(LocalDateTime.now());
        return amsCouponSpuRelationMapper.insertAmsCouponSpuRelation(amsCouponSpuRelation);
    }

    /**
     * 修改优惠券与产品关联
     *
     * @param amsCouponSpuRelation 优惠券与产品关联
     * @return 结果
     */
    @Override
    public int updateAmsCouponSpuRelation(AmsCouponSpuRelation amsCouponSpuRelation) {
        amsCouponSpuRelation.setUpdateTime(LocalDateTime.now());
        return amsCouponSpuRelationMapper.updateAmsCouponSpuRelation(amsCouponSpuRelation);
    }

    /**
     * 批量删除优惠券与产品关联
     *
     * @param ids 需要删除的优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponSpuRelationByIds(Long[] ids) {
        return amsCouponSpuRelationMapper.deleteAmsCouponSpuRelationByIds(ids);
    }

    /**
     * 删除优惠券与产品关联信息
     *
     * @param id 优惠券与产品关联主键
     * @return 结果
     */
    @Override
    public int deleteAmsCouponSpuRelationById(Long id) {
        return amsCouponSpuRelationMapper.deleteAmsCouponSpuRelationById(id);
    }
}
