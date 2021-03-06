package com.qinweizhao.product.service;

import com.qinweizhao.product.model.entity.PmsSpuInfo;
import com.qinweizhao.product.model.param.SpuSaveParam;

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
    PmsSpuInfo getById(Long spuId);

    /**
     * 查询spu信息列表
     *
     * @param pmsSpuInfo spu信息
     * @return spu信息集合
     */
    List<PmsSpuInfo> list(PmsSpuInfo pmsSpuInfo);

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
    int updateById(PmsSpuInfo pmsSpuInfo);

    /**
     * 批量删除spu信息
     *
     * @param spuIds 需要删除的spu信息主键集合
     * @return 结果
     */
    int removeByIds(Long[] spuIds);

    /**
     * 删除spu信息信息
     *
     * @param spuId spu信息主键
     * @return 结果
     */
    int deletePmsSpuInfoBySpuId(Long spuId);


    /**
     * 发布商品
     *
     * @param spuSaveParam pmsSpuSaveVO
     * @return boolean
     */
    boolean saveSpu(SpuSaveParam spuSaveParam);


    /**
     * 更改商品状态（上架或下架）
     *
     * @param spuId spuId
     * @return int
     */
    int updateSpuStatus(Long spuId);
}
