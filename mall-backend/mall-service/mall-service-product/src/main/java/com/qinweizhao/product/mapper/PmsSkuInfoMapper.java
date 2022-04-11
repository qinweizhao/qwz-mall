package com.qinweizhao.product.mapper;

import java.util.List;
import com.qinweizhao.product.domain.PmsSkuInfo;

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
    public PmsSkuInfo selectPmsSkuInfoBySkuId(Long skuId);

    /**
     * 查询sku信息列表
     *
     * @param pmsSkuInfo sku信息
     * @return sku信息集合
     */
    public List<PmsSkuInfo> selectPmsSkuInfoList(PmsSkuInfo pmsSkuInfo);

    /**
     * 新增sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    public int insertPmsSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * 修改sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    public int updatePmsSkuInfo(PmsSkuInfo pmsSkuInfo);

    /**
     * 删除sku信息
     *
     * @param skuId sku信息主键
     * @return 结果
     */
    public int deletePmsSkuInfoBySkuId(Long skuId);

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSkuInfoBySkuIds(Long[] skuIds);
}
