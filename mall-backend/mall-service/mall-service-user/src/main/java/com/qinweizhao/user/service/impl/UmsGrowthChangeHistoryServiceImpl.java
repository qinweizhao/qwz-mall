package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsGrowthChangeHistory;
import com.qinweizhao.user.mapper.UmsGrowthChangeHistoryMapper;
import com.qinweizhao.user.service.UmsGrowthChangeHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 成长值变化历史记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsGrowthChangeHistoryServiceImpl extends QwzServiceImpl<UmsGrowthChangeHistoryMapper, UmsGrowthChangeHistory> implements UmsGrowthChangeHistoryService {


    /**
     * 查询成长值变化历史记录列表
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录
     */
    @Override
    public List<UmsGrowthChangeHistory> selectUmsGrowthChangeHistoryList(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return this.baseMapper.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
    }

}
