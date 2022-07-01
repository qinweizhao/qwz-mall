package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsCouponSpuRelationMapper;
import com.qinweizhao.activity.model.entity.AmsCouponSpuRelation;
import com.qinweizhao.activity.service.IAmsCouponSpuRelationService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 优惠券与产品关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCouponSpuRelationServiceImpl extends QwzServiceImpl<AmsCouponSpuRelationMapper, AmsCouponSpuRelation> implements IAmsCouponSpuRelationService {
    @Resource
    private AmsCouponSpuRelationMapper amsCouponSpuRelationMapper;

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


}
