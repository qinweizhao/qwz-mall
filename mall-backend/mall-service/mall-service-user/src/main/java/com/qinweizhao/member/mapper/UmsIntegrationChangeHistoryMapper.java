package com.qinweizhao.product.mapper;

import com.qinweizhao.product.domain.UmsIntegrationChangeHistory;

import java.util.List;

/**
 * 积分变化历史记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsIntegrationChangeHistoryMapper {
    /**
     * 查询积分变化历史记录
     *
     * @param id 积分变化历史记录主键
     * @return 积分变化历史记录
     */
    public UmsIntegrationChangeHistory selectUmsIntegrationChangeHistoryById(Long id);

    /**
     * 查询积分变化历史记录列表
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 积分变化历史记录集合
     */
    public List<UmsIntegrationChangeHistory> selectUmsIntegrationChangeHistoryList(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 新增积分变化历史记录
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    public int insertUmsIntegrationChangeHistory(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 修改积分变化历史记录
     *
     * @param umsIntegrationChangeHistory 积分变化历史记录
     * @return 结果
     */
    public int updateUmsIntegrationChangeHistory(UmsIntegrationChangeHistory umsIntegrationChangeHistory);

    /**
     * 删除积分变化历史记录
     *
     * @param id 积分变化历史记录主键
     * @return 结果
     */
    public int deleteUmsIntegrationChangeHistoryById(Long id);

    /**
     * 批量删除积分变化历史记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsIntegrationChangeHistoryByIds(Long[] ids);
}
