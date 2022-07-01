package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSeckillSkuRelationMapper;
import com.qinweizhao.activity.model.entity.AmsSeckillSkuRelation;
import com.qinweizhao.activity.service.IAmsSeckillSkuRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 秒杀活动商品关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSeckillSkuRelationServiceImpl implements IAmsSeckillSkuRelationService {
    @Resource
    private AmsSeckillSkuRelationMapper amsSeckillSkuRelationMapper;

    /**
     * 查询秒杀活动商品关联
     *
     * @param id 秒杀活动商品关联主键
     * @return 秒杀活动商品关联
     */
    @Override
    public AmsSeckillSkuRelation selectAmsSeckillSkuRelationById(Long id) {
        return amsSeckillSkuRelationMapper.selectAmsSeckillSkuRelationById(id);
    }

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

    /**
     * 新增秒杀活动商品关联
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    @Override
    public int insertAmsSeckillSkuRelation(AmsSeckillSkuRelation amsSeckillSkuRelation) {
        amsSeckillSkuRelation.setCreateTime(LocalDateTime.now());
        return amsSeckillSkuRelationMapper.insertAmsSeckillSkuRelation(amsSeckillSkuRelation);
    }

    /**
     * 修改秒杀活动商品关联
     *
     * @param amsSeckillSkuRelation 秒杀活动商品关联
     * @return 结果
     */
    @Override
    public int updateAmsSeckillSkuRelation(AmsSeckillSkuRelation amsSeckillSkuRelation) {
        amsSeckillSkuRelation.setUpdateTime(LocalDateTime.now());
        return amsSeckillSkuRelationMapper.updateAmsSeckillSkuRelation(amsSeckillSkuRelation);
    }

    /**
     * 批量删除秒杀活动商品关联
     *
     * @param ids 需要删除的秒杀活动商品关联主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillSkuRelationByIds(Long[] ids) {
        return amsSeckillSkuRelationMapper.deleteAmsSeckillSkuRelationByIds(ids);
    }

    /**
     * 删除秒杀活动商品关联信息
     *
     * @param id 秒杀活动商品关联主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillSkuRelationById(Long id) {
        return amsSeckillSkuRelationMapper.deleteAmsSeckillSkuRelationById(id);
    }
}
