package com.qinweizhao.product.service;

import com.qinweizhao.product.model.entity.PmsSpuInfoDetail;

import java.util.List;


/**
 * spu信息介绍Service接口
 *
 * @author qinweizhao
 * @date 2022-05-02
 */
public interface IPmsSpuInfoDetailService {
    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    PmsSpuInfoDetail getById(Long spuId);

    /**
     * 查询spu信息介绍列表
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return spu信息介绍集合
     */
    List<PmsSpuInfoDetail> list(PmsSpuInfoDetail pmsSpuInfoDetail);

    /**
     * 新增spu信息介绍
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return 结果
     */
    int save(PmsSpuInfoDetail pmsSpuInfoDetail);

    /**
     * 修改spu信息介绍
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return 结果
     */
    int updateById(PmsSpuInfoDetail pmsSpuInfoDetail);

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的spu信息介绍主键集合
     * @return 结果
     */
    int removeByIds(Long[] spuIds);

    /**
     * 删除spu信息介绍信息
     *
     * @param spuId spu信息介绍主键
     * @return 结果
     */
    int deletePmsSpuInfoDetailBySpuId(Long spuId);
}
