package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsSeckillSkuNotice;
import com.qinweizhao.activity.mapper.AmsSeckillSkuNoticeMapper;
import com.qinweizhao.activity.service.IAmsSeckillSkuNoticeService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 秒杀商品通知订阅Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSeckillSkuNoticeServiceImpl implements IAmsSeckillSkuNoticeService {
    @Resource
    private AmsSeckillSkuNoticeMapper amsSeckillSkuNoticeMapper;

    /**
     * 查询秒杀商品通知订阅
     *
     * @param id 秒杀商品通知订阅主键
     * @return 秒杀商品通知订阅
     */
    @Override
    public AmsSeckillSkuNotice selectAmsSeckillSkuNoticeById(Long id) {
        return amsSeckillSkuNoticeMapper.selectAmsSeckillSkuNoticeById(id);
    }

    /**
     * 查询秒杀商品通知订阅列表
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅
     */
    @Override
    public List<AmsSeckillSkuNotice> selectAmsSeckillSkuNoticeList(AmsSeckillSkuNotice amsSeckillSkuNotice) {
        return amsSeckillSkuNoticeMapper.selectAmsSeckillSkuNoticeList(amsSeckillSkuNotice);
    }

    /**
     * 新增秒杀商品通知订阅
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    @Override
    public int insertAmsSeckillSkuNotice(AmsSeckillSkuNotice amsSeckillSkuNotice) {
        amsSeckillSkuNotice.setCreateTime(DateUtils.getNowDate());
        return amsSeckillSkuNoticeMapper.insertAmsSeckillSkuNotice(amsSeckillSkuNotice);
    }

    /**
     * 修改秒杀商品通知订阅
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    @Override
    public int updateAmsSeckillSkuNotice(AmsSeckillSkuNotice amsSeckillSkuNotice) {
        amsSeckillSkuNotice.setUpdateTime(DateUtils.getNowDate());
        return amsSeckillSkuNoticeMapper.updateAmsSeckillSkuNotice(amsSeckillSkuNotice);
    }

    /**
     * 批量删除秒杀商品通知订阅
     *
     * @param ids 需要删除的秒杀商品通知订阅主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillSkuNoticeByIds(Long[] ids) {
        return amsSeckillSkuNoticeMapper.deleteAmsSeckillSkuNoticeByIds(ids);
    }

    /**
     * 删除秒杀商品通知订阅信息
     *
     * @param id 秒杀商品通知订阅主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillSkuNoticeById(Long id) {
        return amsSeckillSkuNoticeMapper.deleteAmsSeckillSkuNoticeById(id);
    }
}
