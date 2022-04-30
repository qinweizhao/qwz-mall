package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.domain.UmsGrowthChangeHistory;
import com.qinweizhao.product.mapper.UmsGrowthChangeHistoryMapper;
import com.qinweizhao.product.service.IUmsGrowthChangeHistoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成长值变化历史记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsGrowthChangeHistoryServiceImpl implements IUmsGrowthChangeHistoryService {
    @Resource
    private UmsGrowthChangeHistoryMapper umsGrowthChangeHistoryMapper;

    /**
     * 查询成长值变化历史记录
     *
     * @param id 成长值变化历史记录主键
     * @return 成长值变化历史记录
     */
    @Override
    public UmsGrowthChangeHistory selectUmsGrowthChangeHistoryById(Long id) {
        return umsGrowthChangeHistoryMapper.selectUmsGrowthChangeHistoryById(id);
    }

    /**
     * 查询成长值变化历史记录列表
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录
     */
    @Override
    public List<UmsGrowthChangeHistory> selectUmsGrowthChangeHistoryList(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return umsGrowthChangeHistoryMapper.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
    }

    /**
     * 新增成长值变化历史记录
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    @Override
    public int insertUmsGrowthChangeHistory(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        umsGrowthChangeHistory.setCreateTime(DateUtils.getNowDate());
        return umsGrowthChangeHistoryMapper.insertUmsGrowthChangeHistory(umsGrowthChangeHistory);
    }

    /**
     * 修改成长值变化历史记录
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 结果
     */
    @Override
    public int updateUmsGrowthChangeHistory(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return umsGrowthChangeHistoryMapper.updateUmsGrowthChangeHistory(umsGrowthChangeHistory);
    }

    /**
     * 批量删除成长值变化历史记录
     *
     * @param ids 需要删除的成长值变化历史记录主键
     * @return 结果
     */
    @Override
    public int deleteUmsGrowthChangeHistoryByIds(Long[] ids) {
        return umsGrowthChangeHistoryMapper.deleteUmsGrowthChangeHistoryByIds(ids);
    }

    /**
     * 删除成长值变化历史记录信息
     *
     * @param id 成长值变化历史记录主键
     * @return 结果
     */
    @Override
    public int deleteUmsGrowthChangeHistoryById(Long id) {
        return umsGrowthChangeHistoryMapper.deleteUmsGrowthChangeHistoryById(id);
    }
}
