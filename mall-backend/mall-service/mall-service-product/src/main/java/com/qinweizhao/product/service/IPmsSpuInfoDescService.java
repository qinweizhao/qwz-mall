package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsSpuInfoDesc;

/**
 * spu信息介绍Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSpuInfoDescService {
    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    PmsSpuInfoDesc selectPmsSpuInfoDescBySpuId(Long spuId);

    /**
     * 查询spu信息介绍列表
     *
     * @param pmsSpuInfoDesc spu信息介绍
     * @return spu信息介绍集合
     */
    List<PmsSpuInfoDesc> selectPmsSpuInfoDescList(PmsSpuInfoDesc pmsSpuInfoDesc);

    /**
     * 新增spu信息介绍
     *
     * @param pmsSpuInfoDesc spu信息介绍
     * @return 结果
     */
    int insertPmsSpuInfoDesc(PmsSpuInfoDesc pmsSpuInfoDesc);

    /**
     * 修改spu信息介绍
     *
     * @param pmsSpuInfoDesc spu信息介绍
     * @return 结果
     */
    int updatePmsSpuInfoDesc(PmsSpuInfoDesc pmsSpuInfoDesc);

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的spu信息介绍主键集合
     * @return 结果
     */
    int deletePmsSpuInfoDescBySpuIds(Long[] spuIds);

    /**
     * 删除spu信息介绍信息
     *
     * @param spuId spu信息介绍主键
     * @return 结果
     */
    int deletePmsSpuInfoDescBySpuId(Long spuId);
}
