package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsSeckillPromotion;
import com.qinweizhao.activity.mapper.AmsSeckillPromotionMapper;
import com.qinweizhao.activity.service.IAmsSeckillPromotionService;
import com.qinweizhao.common.core.utils.DateUtils;
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
public class AmsSeckillPromotionServiceImpl implements IAmsSeckillPromotionService {
    @Resource
    private AmsSeckillPromotionMapper amsSeckillPromotionMapper;

    /**
     * 查询秒杀活动
     *
     * @param id 秒杀活动主键
     * @return 秒杀活动
     */
    @Override
    public AmsSeckillPromotion selectAmsSeckillPromotionById(Long id) {
        return amsSeckillPromotionMapper.selectAmsSeckillPromotionById(id);
    }

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

    /**
     * 新增秒杀活动
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 结果
     */
    @Override
    public int insertAmsSeckillPromotion(AmsSeckillPromotion amsSeckillPromotion) {
        amsSeckillPromotion.setCreateTime(DateUtils.getNowDate());
        return amsSeckillPromotionMapper.insertAmsSeckillPromotion(amsSeckillPromotion);
    }

    /**
     * 修改秒杀活动
     *
     * @param amsSeckillPromotion 秒杀活动
     * @return 结果
     */
    @Override
    public int updateAmsSeckillPromotion(AmsSeckillPromotion amsSeckillPromotion) {
        amsSeckillPromotion.setUpdateTime(DateUtils.getNowDate());
        return amsSeckillPromotionMapper.updateAmsSeckillPromotion(amsSeckillPromotion);
    }

    /**
     * 批量删除秒杀活动
     *
     * @param ids 需要删除的秒杀活动主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillPromotionByIds(Long[] ids) {
        return amsSeckillPromotionMapper.deleteAmsSeckillPromotionByIds(ids);
    }

    /**
     * 删除秒杀活动信息
     *
     * @param id 秒杀活动主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillPromotionById(Long id) {
        return amsSeckillPromotionMapper.deleteAmsSeckillPromotionById(id);
    }
}
