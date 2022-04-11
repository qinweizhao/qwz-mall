package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsSpuInfo;

import java.util.List;

/**
 * spu信息Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSpuInfoService {
    /**
     * 查询spu信息
     *
     * @param spuId spu信息主键
     * @return spu信息
     */
    PmsSpuInfo selectPmsSpuInfoBySpuId(Long spuId);

    /**
     * 查询spu信息列表
     *
     * @param pmsSpuInfo spu信息
     * @return spu信息集合
     */
    List<PmsSpuInfo> selectPmsSpuInfoList(PmsSpuInfo pmsSpuInfo);

    /**
     * 新增spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    int insertPmsSpuInfo(PmsSpuInfo pmsSpuInfo);

    /**
     * 修改spu信息
     *
     * @param pmsSpuInfo spu信息
     * @return 结果
     */
    int updatePmsSpuInfo(PmsSpuInfo pmsSpuInfo);

    /**
     * 批量删除spu信息
     *
     * @param spuIds 需要删除的spu信息主键集合
     * @return 结果
     */
    int deletePmsSpuInfoBySpuIds(Long[] spuIds);

    /**
     * 删除spu信息信息
     *
     * @param spuId spu信息主键
     * @return 结果
     */
    int deletePmsSpuInfoBySpuId(Long spuId);
}
