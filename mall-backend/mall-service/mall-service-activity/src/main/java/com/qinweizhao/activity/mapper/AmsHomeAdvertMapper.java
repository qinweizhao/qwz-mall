package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.domain.AmsHomeAdvert;

import java.util.List;

/**
 * 首页轮播广告Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsHomeAdvertMapper {
    /**
     * 查询首页轮播广告
     *
     * @param id 首页轮播广告主键
     * @return 首页轮播广告
     */
    AmsHomeAdvert selectAmsHomeAdvertById(Long id);

    /**
     * 查询首页轮播广告列表
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 首页轮播广告集合
     */
    List<AmsHomeAdvert> selectAmsHomeAdvertList(AmsHomeAdvert amsHomeAdvert);

    /**
     * 新增首页轮播广告
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 结果
     */
    int insertAmsHomeAdvert(AmsHomeAdvert amsHomeAdvert);

    /**
     * 修改首页轮播广告
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 结果
     */
    int updateAmsHomeAdvert(AmsHomeAdvert amsHomeAdvert);

    /**
     * 删除首页轮播广告
     *
     * @param id 首页轮播广告主键
     * @return 结果
     */
    int deleteAmsHomeAdvertById(Long id);

    /**
     * 批量删除首页轮播广告
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsHomeAdvertByIds(Long[] ids);
}
