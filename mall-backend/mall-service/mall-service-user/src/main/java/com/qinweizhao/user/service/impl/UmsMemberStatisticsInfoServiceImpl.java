package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.entity.UmsMemberStatisticsInfo;
import com.qinweizhao.user.mapper.UmsMemberStatisticsInfoMapper;
import com.qinweizhao.user.service.UmsMemberStatisticsInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员统计信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsMemberStatisticsInfoServiceImpl extends QwzServiceImpl<UmsMemberStatisticsInfoMapper, UmsMemberStatisticsInfo> implements UmsMemberStatisticsInfoService {

    @Resource
    private UmsMemberStatisticsInfoMapper umsMemberStatisticsInfoMapper;


    /**
     * 查询会员统计信息列表
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 会员统计信息
     */
    @Override
    public List<UmsMemberStatisticsInfo> selectUmsMemberStatisticsInfoList(UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return umsMemberStatisticsInfoMapper.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
    }


}
