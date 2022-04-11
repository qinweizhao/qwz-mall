package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsSkuImages;

/**
 * sku图片Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSkuImagesService {
    /**
     * 查询sku图片
     *
     * @param skuId sku图片主键
     * @return sku图片
     */
    PmsSkuImages selectPmsSkuImagesBySkuId(Long skuId);

    /**
     * 查询sku图片列表
     *
     * @param pmsSkuImages sku图片
     * @return sku图片集合
     */
    List<PmsSkuImages> selectPmsSkuImagesList(PmsSkuImages pmsSkuImages);

    /**
     * 新增sku图片
     *
     * @param pmsSkuImages sku图片
     * @return 结果
     */
    int insertPmsSkuImages(PmsSkuImages pmsSkuImages);

    /**
     * 修改sku图片
     *
     * @param pmsSkuImages sku图片
     * @return 结果
     */
    int updatePmsSkuImages(PmsSkuImages pmsSkuImages);

    /**
     * 批量删除sku图片
     *
     * @param skuIds 需要删除的sku图片主键集合
     * @return 结果
     */
    int deletePmsSkuImagesBySkuIds(Long[] skuIds);

    /**
     * 删除sku图片信息
     *
     * @param skuId sku图片主键
     * @return 结果
     */
    int deletePmsSkuImagesBySkuId(Long skuId);
}
