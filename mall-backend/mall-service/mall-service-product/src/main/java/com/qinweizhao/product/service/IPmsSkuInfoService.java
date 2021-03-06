package com.qinweizhao.product.service;

import com.qinweizhao.product.model.entity.PmsSkuInfo;
import com.qinweizhao.product.model.vo.SkuItemVO;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * sku信息Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSkuInfoService {

    /**
     * 查询sku信息
     *
     * @param skuId sku信息主键
     * @return sku信息
     */
    PmsSkuInfo getById(Long skuId);

    /**
     * 查询sku信息列表
     *
     * @param pmsSkuInfo sku信息
     * @return sku信息集合
     */
    List<PmsSkuInfo> list(PmsSkuInfo pmsSkuInfo);

    /**
     * 新增sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    int save(PmsSkuInfo pmsSkuInfo);

    /**
     * 修改sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    int updateById(PmsSkuInfo pmsSkuInfo);

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的sku信息主键集合
     * @return 结果
     */
    int removeByIds(Long[] skuIds);

    /**
     * 删除sku信息信息
     *
     * @param skuId sku信息主键
     * @return 结果
     */
    int removeById(Long skuId);

    /**
     * 查询列表
     *
     * @param spuId spuId
     * @return List
     */
    List<PmsSkuInfo> listBySpuId(Long spuId);


    /**
     * 获取商品详情
     * @param skuId skuId
     * @return SkuItemVO
     * @throws ExecutionException e
     * @throws InterruptedException e
     */
    SkuItemVO getItemById(Long skuId) throws ExecutionException, InterruptedException;
}
