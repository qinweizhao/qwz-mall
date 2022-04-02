package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.domain.PmsSpuInfo;
import com.qinweizhao.product.mapper.PmsSpuInfoMapper;
import com.qinweizhao.product.service.IPmsSpuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * spu信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@Service
public class PmsSpuInfoServiceImpl implements IPmsSpuInfoService {
    @Autowired
    private PmsSpuInfoMapper pmsSpuInfoMapper;

    /**
     * 查询spu信息
     *
     * @param id spu信息主键
     * @return spu信息
     */
    @Override
    public PmsSpuInfo selectPmsSpuInfoById(Long id) {
        return pmsSpuInfoMapper.selectPmsSpuInfoById(id);
    }

    /**
     * 查询spu信息列表
     *
     * @param pmsSpuInfo spu信息
     * @return spu信息
     */
    @Override
    public List<PmsSpuInfo> selectPmsSpuInfoList(PmsSpuInfo pmsSpuInfo) {
        return pmsSpuInfoMapper.selectPmsSpuInfoList(pmsSpuInfo);
    }

    /**
     * 新增spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    @Override
    public int insertPmsSpuInfo(PmsSpuInfo pmsSpuInfo) {
        pmsSpuInfo.setCreateTime(DateUtils.getNowDate());
        return pmsSpuInfoMapper.insertPmsSpuInfo(pmsSpuInfo);
    }

    /**
     * 修改spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    @Override
    public int updatePmsSpuInfo(PmsSpuInfo pmsSpuInfo) {
        pmsSpuInfo.setUpdateTime(DateUtils.getNowDate());
        return pmsSpuInfoMapper.updatePmsSpuInfo(pmsSpuInfo);
    }

    /**
     * 批量删除spu信息
     *
     * @param ids 需要删除的spu信息主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoByIds(Long[] ids) {
        return pmsSpuInfoMapper.deletePmsSpuInfoByIds(ids);
    }

    /**
     * 删除spu信息信息
     *
     * @param id spu信息主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoById(Long id) {
        return pmsSpuInfoMapper.deletePmsSpuInfoById(id);
    }
}
