package com.qinweizhao.product.mapper;

import com.qinweizhao.product.model.entity.PmsSpuInfoDetail;

import java.util.List;

/**
 * spu信息介绍Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-02
 */
public interface PmsSpuInfoDetailMapper {
    /**
     * 查询spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return spu信息介绍
     */
    PmsSpuInfoDetail selectPmsSpuInfoDetailBySpuId(Long spuId);

    /**
     * 查询spu信息介绍列表
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return spu信息介绍集合
     */
    List<PmsSpuInfoDetail> selectPmsSpuInfoDetailList(PmsSpuInfoDetail pmsSpuInfoDetail);

    /**
     * 新增spu信息介绍
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return 结果
     */
    int insertPmsSpuInfoDetail(PmsSpuInfoDetail pmsSpuInfoDetail);

    /**
     * 修改spu信息介绍
     *
     * @param pmsSpuInfoDetail spu信息介绍
     * @return 结果
     */
    int updatePmsSpuInfoDetail(PmsSpuInfoDetail pmsSpuInfoDetail);

    /**
     * 删除spu信息介绍
     *
     * @param spuId spu信息介绍主键
     * @return 结果
     */
    int deletePmsSpuInfoDetailBySpuId(Long spuId);

    /**
     * 批量删除spu信息介绍
     *
     * @param spuIds 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsSpuInfoDetailBySpuIds(Long[] spuIds);
}
