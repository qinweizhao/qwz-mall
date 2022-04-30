package com.qinweizhao.product.mapper;

import com.qinweizhao.product.domain.UmsMemberStatisticsInfo;

import java.util.List;

/**
 * 会员统计信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberStatisticsInfoMapper {
    /**
     * 查询会员统计信息
     *
     * @param id 会员统计信息主键
     * @return 会员统计信息
     */
    public UmsMemberStatisticsInfo selectUmsMemberStatisticsInfoById(Long id);

    /**
     * 查询会员统计信息列表
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 会员统计信息集合
     */
    public List<UmsMemberStatisticsInfo> selectUmsMemberStatisticsInfoList(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 新增会员统计信息
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    public int insertUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 修改会员统计信息
     *
     * @param umsMemberStatisticsInfo 会员统计信息
     * @return 结果
     */
    public int updateUmsMemberStatisticsInfo(UmsMemberStatisticsInfo umsMemberStatisticsInfo);

    /**
     * 删除会员统计信息
     *
     * @param id 会员统计信息主键
     * @return 结果
     */
    public int deleteUmsMemberStatisticsInfoById(Long id);

    /**
     * 批量删除会员统计信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsMemberStatisticsInfoByIds(Long[] ids);
}
