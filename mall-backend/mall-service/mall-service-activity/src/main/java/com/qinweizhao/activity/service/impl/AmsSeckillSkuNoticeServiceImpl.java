package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSeckillSkuNoticeMapper;
import com.qinweizhao.activity.model.entity.AmsSeckillSkuNotice;
import com.qinweizhao.activity.service.IAmsSeckillSkuNoticeService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
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
public class AmsSeckillSkuNoticeServiceImpl extends QwzServiceImpl<AmsSeckillSkuNoticeMapper, AmsSeckillSkuNotice> implements IAmsSeckillSkuNoticeService {
    @Resource
    private AmsSeckillSkuNoticeMapper amsSeckillSkuNoticeMapper;


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


}
