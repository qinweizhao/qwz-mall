package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSeckillSkuNotice;

import java.util.List;

/**
 * 秒杀商品通知订阅Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillSkuNoticeService {
    /**
     * 查询秒杀商品通知订阅
     *
     * @param id 秒杀商品通知订阅主键
     * @return 秒杀商品通知订阅
     */
    AmsSeckillSkuNotice selectAmsSeckillSkuNoticeById(Long id);

    /**
     * 查询秒杀商品通知订阅列表
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅集合
     */
    List<AmsSeckillSkuNotice> selectAmsSeckillSkuNoticeList(AmsSeckillSkuNotice amsSeckillSkuNotice);

    /**
     * 新增秒杀商品通知订阅
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    int insertAmsSeckillSkuNotice(AmsSeckillSkuNotice amsSeckillSkuNotice);

    /**
     * 修改秒杀商品通知订阅
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 结果
     */
    int updateAmsSeckillSkuNotice(AmsSeckillSkuNotice amsSeckillSkuNotice);

    /**
     * 批量删除秒杀商品通知订阅
     *
     * @param ids 需要删除的秒杀商品通知订阅主键集合
     * @return 结果
     */
    int deleteAmsSeckillSkuNoticeByIds(Long[] ids);

    /**
     * 删除秒杀商品通知订阅信息
     *
     * @param id 秒杀商品通知订阅主键
     * @return 结果
     */
    int deleteAmsSeckillSkuNoticeById(Long id);
}
