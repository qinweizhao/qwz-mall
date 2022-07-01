package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsSeckillSkuRelation;

import java.util.List;

/**
 * 秒杀活动商品关联Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillSkuRelationService {
    /**
     * 查询秒杀活动商品关联
     *
     * @param id 秒杀活动商品关联主键
     * @return 秒杀活动商品关联
     */
    AmsSeckillSkuRelation selectAmsSeckillSkuRelationById(Long id);

    /**
     * 查询秒杀活动商品关联列表
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 秒杀活动商品关联集合
     */
    List<AmsSeckillSkuRelation> selectAmsSeckillSkuRelationList(AmsSeckillSkuRelation amsSeckillSkuRelation);

    /**
     * 新增秒杀活动商品关联
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    int insertAmsSeckillSkuRelation(AmsSeckillSkuRelation amsSeckillSkuRelation);

    /**
     * 修改秒杀活动商品关联
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    int updateAmsSeckillSkuRelation(AmsSeckillSkuRelation amsSeckillSkuRelation);

    /**
     * 批量删除秒杀活动商品关联
     *
     * @param ids 需要删除的秒杀活动商品关联主键集合
     * @return 结果
     */
    int deleteAmsSeckillSkuRelationByIds(Long[] ids);

    /**
     * 删除秒杀活动商品关联信息
     *
     * @param id 秒杀活动商品关联主键
     * @return 结果
     */
    int deleteAmsSeckillSkuRelationById(Long id);
}
