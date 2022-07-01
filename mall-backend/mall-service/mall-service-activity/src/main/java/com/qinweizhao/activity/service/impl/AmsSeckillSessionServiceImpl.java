package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsSeckillSession;
import com.qinweizhao.activity.mapper.AmsSeckillSessionMapper;
import com.qinweizhao.activity.service.IAmsSeckillSessionService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 秒杀活动场次Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSeckillSessionServiceImpl implements IAmsSeckillSessionService {
    @Resource
    private AmsSeckillSessionMapper amsSeckillSessionMapper;

    /**
     * 查询秒杀活动场次
     *
     * @param id 秒杀活动场次主键
     * @return 秒杀活动场次
     */
    @Override
    public AmsSeckillSession selectAmsSeckillSessionById(Long id) {
        return amsSeckillSessionMapper.selectAmsSeckillSessionById(id);
    }

    /**
     * 查询秒杀活动场次列表
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 秒杀活动场次
     */
    @Override
    public List<AmsSeckillSession> selectAmsSeckillSessionList(AmsSeckillSession amsSeckillSession) {
        return amsSeckillSessionMapper.selectAmsSeckillSessionList(amsSeckillSession);
    }

    /**
     * 新增秒杀活动场次
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 结果
     */
    @Override
    public int insertAmsSeckillSession(AmsSeckillSession amsSeckillSession) {
        amsSeckillSession.setCreateTime(DateUtils.getNowDate());
        return amsSeckillSessionMapper.insertAmsSeckillSession(amsSeckillSession);
    }

    /**
     * 修改秒杀活动场次
     *
     * @param amsSeckillSession 秒杀活动场次
     * @return 结果
     */
    @Override
    public int updateAmsSeckillSession(AmsSeckillSession amsSeckillSession) {
        amsSeckillSession.setUpdateTime(DateUtils.getNowDate());
        return amsSeckillSessionMapper.updateAmsSeckillSession(amsSeckillSession);
    }

    /**
     * 批量删除秒杀活动场次
     *
     * @param ids 需要删除的秒杀活动场次主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillSessionByIds(Long[] ids) {
        return amsSeckillSessionMapper.deleteAmsSeckillSessionByIds(ids);
    }

    /**
     * 删除秒杀活动场次信息
     *
     * @param id 秒杀活动场次主键
     * @return 结果
     */
    @Override
    public int deleteAmsSeckillSessionById(Long id) {
        return amsSeckillSessionMapper.deleteAmsSeckillSessionById(id);
    }
}
