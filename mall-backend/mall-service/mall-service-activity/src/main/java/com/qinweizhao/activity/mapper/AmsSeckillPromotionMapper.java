package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsSeckillPromotion;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 秒杀活动Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSeckillPromotionMapper extends QwzBaseMapper<AmsSeckillPromotion> {
    /**
     * 查询秒杀活动
     *
     * @param id 秒杀活动主键
     * @return 秒杀活动
     */
    AmsSeckillPromotion selectAmsSeckillPromotionById(Long id);

    /**
     * 查询秒杀活动列表
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 秒杀活动集合
     */
    List<AmsSeckillPromotion> selectAmsSeckillPromotionList(AmsSeckillPromotion amsSeckillPromotion);

    /**
     * 新增秒杀活动
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 结果
     */
    int insertAmsSeckillPromotion(AmsSeckillPromotion amsSeckillPromotion);

    /**
     * 修改秒杀活动
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 结果
     */
    int updateAmsSeckillPromotion(AmsSeckillPromotion amsSeckillPromotion);

    /**
     * 删除秒杀活动
     *
     * @param id 秒杀活动主键
     * @return 结果
     */
    int deleteAmsSeckillPromotionById(Long id);

    /**
     * 批量删除秒杀活动
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSeckillPromotionByIds(Long[] ids);
}
