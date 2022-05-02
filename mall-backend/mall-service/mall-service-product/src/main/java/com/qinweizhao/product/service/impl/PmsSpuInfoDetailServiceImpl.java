package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSpuInfoDetail;
import com.qinweizhao.product.mapper.PmsSpuInfoDetailMapper;
import com.qinweizhao.product.service.IPmsSpuInfoDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu信息介绍Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-02
 */
@Service
public class PmsSpuInfoDetailServiceImpl implements IPmsSpuInfoDetailService {
    @Resource
    private PmsSpuInfoDetailMapper pmsSpuInfoDetailMapper;

    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    @Override
    public PmsSpuInfoDetail selectPmsSpuInfoDetailBySpuId(Long spuId) {
        return pmsSpuInfoDetailMapper.selectPmsSpuInfoDetailBySpuId(spuId);
    }

    /**
     * 查询spu信息介绍列表
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return spu信息介绍
     */
    @Override
    public List<PmsSpuInfoDetail> selectPmsSpuInfoDetailList(PmsSpuInfoDetail pmsSpuInfoDetail) {
        return pmsSpuInfoDetailMapper.selectPmsSpuInfoDetailList(pmsSpuInfoDetail);
    }

    /**
     * 新增spu信息介绍
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return 结果
     */
    @Override
    public int insertPmsSpuInfoDetail(PmsSpuInfoDetail pmsSpuInfoDetail) {
        pmsSpuInfoDetail.setCreateTime(DateUtils.getNowDate());
        return pmsSpuInfoDetailMapper.insertPmsSpuInfoDetail(pmsSpuInfoDetail);
    }

    /**
     * 修改spu信息介绍
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return 结果
     */
    @Override
    public int updatePmsSpuInfoDetail(PmsSpuInfoDetail pmsSpuInfoDetail) {
        pmsSpuInfoDetail.setUpdateTime(DateUtils.getNowDate());
        return pmsSpuInfoDetailMapper.updatePmsSpuInfoDetail(pmsSpuInfoDetail);
    }

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的spu信息介绍主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoDetailBySpuIds(Long[] spuIds) {
        return pmsSpuInfoDetailMapper.deletePmsSpuInfoDetailBySpuIds(spuIds);
    }

    /**
     * 删除spu信息介绍信息
     *
     * @param spuId spu信息介绍主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoDetailBySpuId(Long spuId) {
        return pmsSpuInfoDetailMapper.deletePmsSpuInfoDetailBySpuId(spuId);
    }
}
