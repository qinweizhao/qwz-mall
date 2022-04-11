package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSpuInfoDesc;
import com.qinweizhao.product.mapper.PmsSpuInfoDescMapper;
import com.qinweizhao.product.service.IPmsSpuInfoDescService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu信息介绍Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSpuInfoDescServiceImpl implements IPmsSpuInfoDescService {
    @Resource
    private PmsSpuInfoDescMapper pmsSpuInfoDescMapper;

    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    @Override
    public PmsSpuInfoDesc selectPmsSpuInfoDescBySpuId(Long spuId) {
        return pmsSpuInfoDescMapper.selectPmsSpuInfoDescBySpuId(spuId);
    }

    /**
     * 查询spu信息介绍列表
     *
     * @param pmsSpuInfoDesc spu信息介绍
     * @return spu信息介绍
     */
    @Override
    public List<PmsSpuInfoDesc> selectPmsSpuInfoDescList(PmsSpuInfoDesc pmsSpuInfoDesc) {
        return pmsSpuInfoDescMapper.selectPmsSpuInfoDescList(pmsSpuInfoDesc);
    }

    /**
     * 新增spu信息介绍
     *
     * @param pmsSpuInfoDesc spu信息介绍
     * @return 结果
     */
    @Override
    public int insertPmsSpuInfoDesc(PmsSpuInfoDesc pmsSpuInfoDesc) {
        pmsSpuInfoDesc.setCreateTime(DateUtils.getNowDate());
        return pmsSpuInfoDescMapper.insertPmsSpuInfoDesc(pmsSpuInfoDesc);
    }

    /**
     * 修改spu信息介绍
     *
     * @param pmsSpuInfoDesc spu信息介绍
     * @return 结果
     */
    @Override
    public int updatePmsSpuInfoDesc(PmsSpuInfoDesc pmsSpuInfoDesc) {
        pmsSpuInfoDesc.setUpdateTime(DateUtils.getNowDate());
        return pmsSpuInfoDescMapper.updatePmsSpuInfoDesc(pmsSpuInfoDesc);
    }

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的spu信息介绍主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoDescBySpuIds(Long[] spuIds) {
        return pmsSpuInfoDescMapper.deletePmsSpuInfoDescBySpuIds(spuIds);
    }

    /**
     * 删除spu信息介绍信息
     *
     * @param spuId spu信息介绍主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuInfoDescBySpuId(Long spuId) {
        return pmsSpuInfoDescMapper.deletePmsSpuInfoDescBySpuId(spuId);
    }
}
