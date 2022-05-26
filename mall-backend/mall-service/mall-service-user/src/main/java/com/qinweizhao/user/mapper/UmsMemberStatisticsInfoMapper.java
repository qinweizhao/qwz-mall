package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.user.model.entity.UmsMemberStatisticsInfo;

import java.util.List;

/**
 * 会员统计信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberStatisticsInfoMapper extends QwzBaseMapper<UmsMemberStatisticsInfo> {


    /**
     * 查询会员统计信息列表
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 会员统计信息集合
     */
    List<UmsMemberStatisticsInfo> selectUmsMemberStatisticsInfoList(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

}
