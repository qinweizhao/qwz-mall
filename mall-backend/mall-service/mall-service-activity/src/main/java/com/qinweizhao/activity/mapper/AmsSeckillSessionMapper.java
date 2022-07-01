package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsSeckillSession;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 秒杀活动场次Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSeckillSessionMapper extends QwzBaseMapper<AmsSeckillSession> {
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
     * 删除秒杀活动场次
     *
     * @param id 秒杀活动场次主键
     * @return 结果
     */
    int deleteAmsSeckillSessionById(Long id);

    /**
     * 批量删除秒杀活动场次
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSeckillSessionByIds(Long[] ids);
}
