package com.qinweizhao.product.mapper;

import java.util.List;

import com.qinweizhao.product.domain.PmsSkuImages;

/**
 * sku图片Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSkuImagesMapper {
    /**
     * 查询sku图片
     *
     * @param skuId sku图片主键
     * @return sku图片
     */
    public PmsSkuImages selectPmsSkuImagesBySkuId(Long skuId);

    /**
     * 查询sku图片列表
     *
     * @param pmsSkuImages sku图片
     * @return sku图片集合
     */
    public List<PmsSkuImages> selectPmsSkuImagesList(PmsSkuImages pmsSkuImages);

    /**
     * 新增sku图片
     *
     * @param pmsSkuImages sku图片
     * @return 结果
     */
    public int insertPmsSkuImages(PmsSkuImages pmsSkuImages);

    /**
     * 修改sku图片
     *
     * @param pmsSkuImages sku图片
     * @return 结果
     */
    public int updatePmsSkuImages(PmsSkuImages pmsSkuImages);

    /**
     * 删除sku图片
     *
     * @param skuId sku图片主键
     * @return 结果
     */
    public int deletePmsSkuImagesBySkuId(Long skuId);

    /**
     * 批量删除sku图片
     *
     * @param skuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSkuImagesBySkuIds(Long[] skuIds);
}
