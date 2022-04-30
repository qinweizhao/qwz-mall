package com.qinweizhao.user.service;

import com.qinweizhao.user.entity.UmsIntegrationChangeHistory;

import java.util.List;

/**
 * 积分变化历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsIntegrationChangeHistoryService {
    /**
     * 查询积分变化历史记录
     *
     * @param id 积分变化历史记录主键
     * @return 积分变化历史记录
     */
    UmsIntegrationChangeHistory selectUmsIntegrationChangeHistoryById(Long id);

    /**
     * 查询积分变化历史记录列表
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录集合
     */
    List<UmsIntegrationChangeHistory> selectUmsIntegrationChangeHistoryList(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 新增积分变化历史记录
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    int insertUmsIntegrationChangeHistory(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 修改积分变化历史记录
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    int updateUmsIntegrationChangeHistory(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 批量删除积分变化历史记录
     *
     * @param ids 需要删除的积分变化历史记录主键集合
     * @return 结果
     */
    int deleteUmsIntegrationChangeHistoryByIds(Long[] ids);

    /**
     * 删除积分变化历史记录信息
     *
     * @param id 积分变化历史记录主键
     * @return 结果
     */
    int deleteUmsIntegrationChangeHistoryById(Long id);
}
