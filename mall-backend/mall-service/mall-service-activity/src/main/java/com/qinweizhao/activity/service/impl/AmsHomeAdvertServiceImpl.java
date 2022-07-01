package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsHomeAdvert;
import com.qinweizhao.activity.mapper.AmsHomeAdvertMapper;
import com.qinweizhao.activity.service.IAmsHomeAdvertService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页轮播广告Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsHomeAdvertServiceImpl implements IAmsHomeAdvertService {
    @Resource
    private AmsHomeAdvertMapper amsHomeAdvertMapper;

    /**
     * 查询首页轮播广告
     *
     * @param id 首页轮播广告主键
     * @return 首页轮播广告
     */
    @Override
    public AmsHomeAdvert selectAmsHomeAdvertById(Long id) {
        return amsHomeAdvertMapper.selectAmsHomeAdvertById(id);
    }

    /**
     * 查询首页轮播广告列表
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 首页轮播广告
     */
    @Override
    public List<AmsHomeAdvert> selectAmsHomeAdvertList(AmsHomeAdvert amsHomeAdvert) {
        return amsHomeAdvertMapper.selectAmsHomeAdvertList(amsHomeAdvert);
    }

    /**
     * 新增首页轮播广告
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 结果
     */
    @Override
    public int insertAmsHomeAdvert(AmsHomeAdvert amsHomeAdvert) {
        amsHomeAdvert.setCreateTime(DateUtils.getNowDate());
        return amsHomeAdvertMapper.insertAmsHomeAdvert(amsHomeAdvert);
    }

    /**
     * 修改首页轮播广告
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 结果
     */
    @Override
    public int updateAmsHomeAdvert(AmsHomeAdvert amsHomeAdvert) {
        amsHomeAdvert.setUpdateTime(DateUtils.getNowDate());
        return amsHomeAdvertMapper.updateAmsHomeAdvert(amsHomeAdvert);
    }

    /**
     * 批量删除首页轮播广告
     *
     * @param ids 需要删除的首页轮播广告主键
     * @return 结果
     */
    @Override
    public int deleteAmsHomeAdvertByIds(Long[] ids) {
        return amsHomeAdvertMapper.deleteAmsHomeAdvertByIds(ids);
    }

    /**
     * 删除首页轮播广告信息
     *
     * @param id 首页轮播广告主键
     * @return 结果
     */
    @Override
    public int deleteAmsHomeAdvertById(Long id) {
        return amsHomeAdvertMapper.deleteAmsHomeAdvertById(id);
    }
}
