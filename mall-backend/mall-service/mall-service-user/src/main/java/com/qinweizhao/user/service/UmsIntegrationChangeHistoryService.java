package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.entity.UmsIntegrationChangeHistory;

import java.util.List;

/**
 * 积分变化历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsIntegrationChangeHistoryService extends QwzService<UmsIntegrationChangeHistory> {


    /**
     * 查询积分变化历史记录列表
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录集合
     */
    List<UmsIntegrationChangeHistory> selectUmsIntegrationChangeHistoryList(UmsIntegrationChangeHistory umsIntegrationChangeHistory);


}
