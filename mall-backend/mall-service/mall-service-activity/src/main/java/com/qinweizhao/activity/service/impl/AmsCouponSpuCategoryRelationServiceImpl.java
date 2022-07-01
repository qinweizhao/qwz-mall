package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsCouponSpuCategoryRelationMapper;
import com.qinweizhao.activity.model.entity.AmsCouponSpuCategoryRelation;
import com.qinweizhao.activity.service.IAmsCouponSpuCategoryRelationService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
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
public class AmsCouponSpuCategoryRelationServiceImpl extends QwzServiceImpl<AmsCouponSpuCategoryRelationMapper, AmsCouponSpuCategoryRelation> implements IAmsCouponSpuCategoryRelationService {
    @Resource
    private AmsCouponSpuCategoryRelationMapper amsCouponSpuCategoryRelationMapper;


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


}
