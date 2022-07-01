package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSeckillPromotionMapper;
import com.qinweizhao.activity.model.entity.AmsSeckillPromotion;
import com.qinweizhao.activity.service.IAmsSeckillPromotionService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 秒杀活动Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSeckillPromotionServiceImpl extends QwzServiceImpl<AmsSeckillPromotionMapper, AmsSeckillPromotion> implements IAmsSeckillPromotionService {
    @Resource
    private AmsSeckillPromotionMapper amsSeckillPromotionMapper;

    /**
     * 查询秒杀活动列表
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 秒杀活动
     */
    @Override
    public List<AmsSeckillPromotion> selectAmsSeckillPromotionList(AmsSeckillPromotion amsSeckillPromotion) {
        return amsSeckillPromotionMapper.selectAmsSeckillPromotionList(amsSeckillPromotion);
    }

}
