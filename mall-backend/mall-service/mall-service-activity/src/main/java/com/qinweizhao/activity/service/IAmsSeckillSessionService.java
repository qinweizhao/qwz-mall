package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsSeckillSession;

import java.util.List;

/**
 * 秒杀活动场次Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSeckillSessionService {
    /**
     * 查询秒杀活动场次
     *
     * @param id 秒杀活动场次主键
     * @return 秒杀活动场次
     */
    AmsSeckillSession selectAmsSeckillSessionById(Long id);

    /**
     * 查询秒杀活动场次列表
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 秒杀活动场次集合
     */
    List<AmsSeckillSession> selectAmsSeckillSessionList(AmsSeckillSession amsSeckillSession);

    /**
     * 新增秒杀活动场次
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 结果
     */
    int insertAmsSeckillSession(AmsSeckillSession amsSeckillSession);

    /**
     * 修改秒杀活动场次
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 结果
     */
    int updateAmsSeckillSession(AmsSeckillSession amsSeckillSession);

    /**
     * 批量删除秒杀活动场次
     *
     * @param ids 需要删除的秒杀活动场次主键集合
     * @return 结果
     */
    int deleteAmsSeckillSessionByIds(Long[] ids);

    /**
     * 删除秒杀活动场次信息
     *
     * @param id 秒杀活动场次主键
     * @return 结果
     */
    int deleteAmsSeckillSessionById(Long id);
}
