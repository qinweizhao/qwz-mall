package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsSeckillSkuRelation;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 秒杀活动商品关联Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSeckillSkuRelationMapper extends QwzBaseMapper<AmsSeckillSkuRelation> {
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
     * 删除秒杀活动商品关联
     *
     * @param id 秒杀活动商品关联主键
     * @return 结果
     */
    int deleteAmsSeckillSkuRelationById(Long id);

    /**
     * 批量删除秒杀活动商品关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSeckillSkuRelationByIds(Long[] ids);
}
