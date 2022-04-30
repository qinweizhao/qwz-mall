package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.UmsMemberStatisticsInfo;
import com.qinweizhao.product.mapper.UmsMemberStatisticsInfoMapper;
import com.qinweizhao.product.service.IUmsMemberStatisticsInfoService;
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
public class UmsMemberStatisticsInfoServiceImpl implements IUmsMemberStatisticsInfoService {
    @Resource
    private UmsMemberStatisticsInfoMapper umsMemberStatisticsInfoMapper;

    /**
     * 查询会员统计信息
     *
     * @param id 会员统计信息主键
     * @return 会员统计信息
     */
    @Override
    public UmsMemberStatisticsInfo selectUmsMemberStatisticsInfoById(Long id) {
        return umsMemberStatisticsInfoMapper.selectUmsMemberStatisticsInfoById(id);
    }

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

    /**
     * 新增会员统计信息
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    @Override
    public int insertUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return umsMemberStatisticsInfoMapper.insertUmsMemberStatisticsInfo(umsMemberStatisticsInfo);
    }

    /**
     * 修改会员统计信息
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    @Override
    public int updateUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return umsMemberStatisticsInfoMapper.updateUmsMemberStatisticsInfo(umsMemberStatisticsInfo);
    }

    /**
     * 批量删除会员统计信息
     *
     * @param ids 需要删除的会员统计信息主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberStatisticsInfoByIds(Long[] ids) {
        return umsMemberStatisticsInfoMapper.deleteUmsMemberStatisticsInfoByIds(ids);
    }

    /**
     * 删除会员统计信息信息
     *
     * @param id 会员统计信息主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberStatisticsInfoById(Long id) {
        return umsMemberStatisticsInfoMapper.deleteUmsMemberStatisticsInfoById(id);
    }
}
