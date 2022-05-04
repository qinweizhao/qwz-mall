package com.qinweizhao.ware.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.ware.domain.WmsWareInfo;
import com.qinweizhao.ware.mapper.WmsWareInfoMapper;
import com.qinweizhao.ware.service.IWmsWareInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Service
public class WmsWareInfoServiceImpl implements IWmsWareInfoService {
    @Resource
    private WmsWareInfoMapper wmsWareInfoMapper;

    /**
     * 查询仓库信息
     *
     * @param id 仓库信息主键
     * @return 仓库信息
     */
    @Override
    public WmsWareInfo selectWmsWareInfoById(Long id) {
        return wmsWareInfoMapper.selectWmsWareInfoById(id);
    }

    /**
     * 查询仓库信息列表
     *
     * @param wmsWareInfo 仓库信息
     * @return 仓库信息
     */
    @Override
    public List<WmsWareInfo> selectWmsWareInfoList(WmsWareInfo wmsWareInfo) {
        return wmsWareInfoMapper.selectWmsWareInfoList(wmsWareInfo);
    }

    /**
     * 新增仓库信息
     *
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    @Override
    public int insertWmsWareInfo(WmsWareInfo wmsWareInfo) {
        wmsWareInfo.setCreateTime(DateUtils.getNowDate());
        return wmsWareInfoMapper.insertWmsWareInfo(wmsWareInfo);
    }

    /**
     * 修改仓库信息
     *
     * @param wmsWareInfo 仓库信息
     * @return 结果
     */
    @Override
    public int updateWmsWareInfo(WmsWareInfo wmsWareInfo) {
        wmsWareInfo.setUpdateTime(DateUtils.getNowDate());
        return wmsWareInfoMapper.updateWmsWareInfo(wmsWareInfo);
    }

    /**
     * 批量删除仓库信息
     *
     * @param ids 需要删除的仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareInfoByIds(Long[] ids) {
        return wmsWareInfoMapper.deleteWmsWareInfoByIds(ids);
    }

    /**
     * 删除仓库信息信息
     *
     * @param id 仓库信息主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareInfoById(Long id) {
        return wmsWareInfoMapper.deleteWmsWareInfoById(id);
    }
}
