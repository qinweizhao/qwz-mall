package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.user.model.entity.UmsGrowthChangeHistory;

import java.util.List;

/**
 * 成长值变化历史记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsGrowthChangeHistoryMapper extends QwzMapper<UmsGrowthChangeHistory> {

    /**
     * 查询成长值变化历史记录列表
     *
     * @param umsGrowthChangeHistory 成长值变化历史记录
     * @return 成长值变化历史记录集合
     */
    List<UmsGrowthChangeHistory> selectUmsGrowthChangeHistoryList(UmsGrowthChangeHistory umsGrowthChangeHistory);


}
