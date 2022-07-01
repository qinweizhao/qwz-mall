package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSeckillPromotion;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 秒杀活动Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillPromotionService extends QwzService<AmsSeckillPromotion> {
    /**
     * 查询秒杀活动列表
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 秒杀活动集合
     */
    List<AmsSeckillPromotion> selectAmsSeckillPromotionList(AmsSeckillPromotion amsSeckillPromotion);

}
