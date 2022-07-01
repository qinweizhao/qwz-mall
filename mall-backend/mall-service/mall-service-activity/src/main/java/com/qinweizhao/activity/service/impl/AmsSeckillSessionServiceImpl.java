package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSeckillSessionMapper;
import com.qinweizhao.activity.model.entity.AmsSeckillSession;
import com.qinweizhao.activity.service.IAmsSeckillSessionService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
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
public class AmsSeckillSessionServiceImpl extends QwzServiceImpl<AmsSeckillSessionMapper, AmsSeckillSession> implements IAmsSeckillSessionService {
    @Resource
    private AmsSeckillSessionMapper amsSeckillSessionMapper;


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

}
