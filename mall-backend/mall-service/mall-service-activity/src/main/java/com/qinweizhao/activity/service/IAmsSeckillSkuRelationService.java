package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSeckillSkuRelation;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 秒杀活动商品关联Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillSkuRelationService extends QwzService<AmsSeckillSkuRelation> {


    /**
     * 查询秒杀活动商品关联列表
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联集合
     */
    List<AmsSeckillSkuRelation> selectAmsSeckillSkuRelationList(AmsSeckillSkuRelation amsSeckillSkuRelation);

}
