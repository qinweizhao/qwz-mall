package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.user.model.entity.UmsIntegrationChangeHistory;

import java.util.List;

/**
 * 积分变化历史记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsIntegrationChangeHistoryMapper extends QwzMapper<UmsIntegrationChangeHistory> {


    /**
     * 查询积分变化历史记录列表
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录集合
     */
    List<UmsIntegrationChangeHistory> selectUmsIntegrationChangeHistoryList(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

}
