package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSpuInfo;
import com.qinweizhao.product.mapper.PmsSpuInfoMapper;
import com.qinweizhao.product.service.IPmsSpuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSpuInfoServiceImpl implements IPmsSpuInfoService {
    @Resource
    private PmsSpuInfoMapper pmsSpuInfoMapper;

    /**
     * 查询spu信息
     *
     * @param spuId spu信息主键
     * @return spu信息
     */
    @Override
    public PmsSpuInfo selectPmsSpuInfoBySpuId(Long spuId) {
        return pmsSpuInfoMapper.selectPmsSpuInfoBySpuId(spuId);
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
     * @param spuIds 需要删除的spu信息主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoBySpuIds(Long[] spuIds) {
        return pmsSpuInfoMapper.deletePmsSpuInfoBySpuIds(spuIds);
    }

    /**
     * 删除spu信息信息
     *
     * @param spuId spu信息主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoBySpuId(Long spuId) {
        return pmsSpuInfoMapper.deletePmsSpuInfoBySpuId(spuId);
    }
}
