package com.qinweizhao.product.mapper;

import com.qinweizhao.product.model.entity.PmsSkuInfo;

import java.util.List;

/**
 * sku信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSkuInfoMapper {
    /**
     * 查询sku信息
     *
     * @param skuId sku信息主键
     * @return sku信息
     */
    PmsSkuInfo selectById(Long skuId);

    /**
     * 查询sku信息列表
     *
     * @param pmsSkuInfo sku信息
     * @return sku信息集合
     */
    List<PmsSkuInfo> selectPmsSkuInfoList(PmsSkuInfo pmsSkuInfo);

    /**
     * 新增sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    int insertPmsSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * 修改sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    int updatePmsSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * 删除sku信息
     *
     * @param skuId sku信息主键
     * @return 结果
     */
    int deletePmsSkuInfoBySkuId(Long skuId);

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsSkuInfoBySkuIds(Long[] skuIds);

    /**
     * 查询列表
     * @param spuId spuId
     * @return List
     */
    List<PmsSkuInfo> selectListBySpuId(Long spuId);
}
