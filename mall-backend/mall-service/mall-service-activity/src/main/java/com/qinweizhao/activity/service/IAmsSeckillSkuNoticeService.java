package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSeckillSkuNotice;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 秒杀商品通知订阅Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillSkuNoticeService extends QwzService<AmsSeckillSkuNotice> {

    /**
     * 查询秒杀商品通知订阅列表
     *
     * @param amsSeckillSkuNotice 秒杀商品通知订阅
     * @return 秒杀商品通知订阅集合
     */
    List<AmsSeckillSkuNotice> selectAmsSeckillSkuNoticeList(AmsSeckillSkuNotice amsSeckillSkuNotice);


}
