package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.entity.UmsMemberStatisticsInfo;

import java.util.List;

/**
 * 会员统计信息Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberStatisticsInfoService extends QwzService<UmsMemberStatisticsInfo> {


    /**
     * 查询会员统计信息列表
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 会员统计信息集合
     */
    List<UmsMemberStatisticsInfo> selectUmsMemberStatisticsInfoList(UmsMemberStatisticsInfo umsMemberStatisticsInfo);


}
