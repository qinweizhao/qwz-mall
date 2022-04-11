package com.qinweizhao.product.mapper;

import com.qinweizhao.product.domain.PmsSpuInfo;

import java.util.List;

/**
 * spu信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSpuInfoMapper {
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
     * 删除spu信息
     *
     * @param spuId spu信息主键
     * @return 结果
     */
    int deletePmsSpuInfoBySpuId(Long spuId);

    /**
     * 批量删除spu信息
     *
     * @param spuIds 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsSpuInfoBySpuIds(Long[] spuIds);
}
