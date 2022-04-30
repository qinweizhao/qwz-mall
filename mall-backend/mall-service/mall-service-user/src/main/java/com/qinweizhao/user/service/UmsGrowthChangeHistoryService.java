package com.qinweizhao.user.service;

import com.qinweizhao.user.entity.UmsGrowthChangeHistory;

import java.util.List;

/**
 * 成长值变化历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsGrowthChangeHistoryService {
    /**
     * 查询成长值变化历史记录
     *
     * @param id 成长值变化历史记录主键
     * @return 成长值变化历史记录
     */
    UmsGrowthChangeHistory selectUmsGrowthChangeHistoryById(Long id);

    /**
     * 查询成长值变化历史记录列表
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录集合
     */
    List<UmsGrowthChangeHistory> selectUmsGrowthChangeHistoryList(UmsGrowthChangeHistory umsGrowthChangeHistory);

    /**
     * 新增成长值变化历史记录
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    int insertUmsGrowthChangeHistory(UmsGrowthChangeHistory umsGrowthChangeHistory);

    /**
     * 修改成长值变化历史记录
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    int updateUmsGrowthChangeHistory(UmsGrowthChangeHistory umsGrowthChangeHistory);

    /**
     * 批量删除成长值变化历史记录
     *
     * @param ids 需要删除的成长值变化历史记录主键集合
     * @return 结果
     */
    int deleteUmsGrowthChangeHistoryByIds(Long[] ids);

    /**
     * 删除成长值变化历史记录信息
     *
     * @param id 成长值变化历史记录主键
     * @return 结果
     */
    int deleteUmsGrowthChangeHistoryById(Long id);
}
