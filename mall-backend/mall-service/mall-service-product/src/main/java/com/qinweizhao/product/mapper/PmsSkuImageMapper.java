package com.qinweizhao.product.mapper;

import com.qinweizhao.product.model.entity.PmsSkuImage;

import java.util.List;

/**
 * sku图片Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-12
 */
public interface PmsSkuImageMapper {
    /**
     * 查询sku图片
     *
     * @param skuId sku图片主键
     * @return sku图片
     */
    PmsSkuImage selectPmsSkuImageBySkuImageId(Long skuId);

    /**
     * 查询sku图片列表
     *
     * @param pmsSkuImage sku图片
     * @return sku图片集合
     */
    List<PmsSkuImage> selectPmsSkuImageList(PmsSkuImage pmsSkuImage);

    /**
     * 新增sku图片
     *
     * @param pmsSkuImage sku图片
     * @return 结果
     */
    int insertPmsSkuImage(PmsSkuImage pmsSkuImage);

    /**
     * 修改sku图片
     *
     * @param pmsSkuImage sku图片
     * @return 结果
     */
    int updatePmsSkuImage(PmsSkuImage pmsSkuImage);

    /**
     * 删除sku图片
     *
     * @param skuId sku图片主键
     * @return 结果
     */
    int deletePmsSkuImageBySkuImageId(Long skuId);

    /**
     * 批量删除sku图片
     *
     * @param skuIds 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsSkuImageBySkuImageIds(Long[] skuIds);
}
