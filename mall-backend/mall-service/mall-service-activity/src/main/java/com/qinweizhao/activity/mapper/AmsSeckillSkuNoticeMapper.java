package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsSeckillSkuNotice;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 秒杀商品通知订阅Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSeckillSkuNoticeMapper extends QwzBaseMapper<AmsSeckillSkuNotice> {
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
     * 删除秒杀商品通知订阅
     *
     * @param id 秒杀商品通知订阅主键
     * @return 结果
     */
    int deleteAmsSeckillSkuNoticeById(Long id);

    /**
     * 批量删除秒杀商品通知订阅
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSeckillSkuNoticeByIds(Long[] ids);
}
