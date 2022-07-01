package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSeckillSkuRelationMapper;
import com.qinweizhao.activity.model.entity.AmsSeckillSkuRelation;
import com.qinweizhao.activity.service.IAmsSeckillSkuRelationService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 秒杀活动商品关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSeckillSkuRelationServiceImpl extends QwzServiceImpl<AmsSeckillSkuRelationMapper, AmsSeckillSkuRelation> implements IAmsSeckillSkuRelationService {
    @Resource
    private AmsSeckillSkuRelationMapper amsSeckillSkuRelationMapper;


    /**
     * 查询秒杀活动商品关联列表
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联
     */
    @Override
    public List<AmsSeckillSkuRelation> selectAmsSeckillSkuRelationList(AmsSeckillSkuRelation amsSeckillSkuRelation) {
        return amsSeckillSkuRelationMapper.selectAmsSeckillSkuRelationList(amsSeckillSkuRelation);
    }

}
