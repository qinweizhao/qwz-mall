package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsSkuImages;

import java.util.List;

/**
 * sku图片Service接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface IPmsSkuImagesService {
    /**
     * 查询sku图片
     *
     * @param id sku图片主键
     * @return sku图片
     */
    public PmsSkuImages selectPmsSkuImagesById(Long id);

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
     * 批量删除sku图片
     *
     * @param ids 需要删除的sku图片主键集合
     * @return 结果
     */
    public int deletePmsSkuImagesByIds(Long[] ids);

    /**
     * 删除sku图片信息
     *
     * @param id sku图片主键
     * @return 结果
     */
    public int deletePmsSkuImagesById(Long id);
}
