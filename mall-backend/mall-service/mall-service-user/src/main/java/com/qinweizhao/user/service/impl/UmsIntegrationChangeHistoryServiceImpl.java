package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.entity.UmsIntegrationChangeHistory;
import com.qinweizhao.user.mapper.UmsIntegrationChangeHistoryMapper;
import com.qinweizhao.user.service.UmsIntegrationChangeHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 积分变化历史记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsIntegrationChangeHistoryServiceImpl extends QwzServiceImpl<UmsIntegrationChangeHistoryMapper, UmsIntegrationChangeHistory> implements UmsIntegrationChangeHistoryService {



    /**
     * 查询积分变化历史记录列表
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录
     */
    @Override
    public List<UmsIntegrationChangeHistory> selectUmsIntegrationChangeHistoryList(UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return this.baseMapper.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
    }
}
