package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.entity.UmsGrowthChangeHistory;

import java.util.List;

/**
 * 成长值变化历史记录Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsGrowthChangeHistoryService extends QwzService<UmsGrowthChangeHistory> {


    /**
     * 查询成长值变化历史记录列表
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录集合
     */
    List<UmsGrowthChangeHistory> selectUmsGrowthChangeHistoryList(UmsGrowthChangeHistory umsGrowthChangeHistory);

}
