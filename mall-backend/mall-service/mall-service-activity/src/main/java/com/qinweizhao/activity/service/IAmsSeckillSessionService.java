package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSeckillSession;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 秒杀活动场次Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillSessionService extends QwzService<AmsSeckillSession> {

    /**
     * 查询秒杀活动场次列表
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 秒杀活动场次集合
     */
    List<AmsSeckillSession> selectAmsSeckillSessionList(AmsSeckillSession amsSeckillSession);
}
