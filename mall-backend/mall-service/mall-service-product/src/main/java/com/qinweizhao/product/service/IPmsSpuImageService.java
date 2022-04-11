package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsSpuImage;

/**
 * spu图片Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSpuImageService {
    /**
     * 查询spu图片
     *
     * @param spuId spu图片主键
     * @return spu图片
     */
    PmsSpuImage selectPmsSpuImageBySpuId(Long spuId);

    /**
     * 查询spu图片列表
     *
     * @param pmsSpuImage spu图片
     * @return spu图片集合
     */
    List<PmsSpuImage> selectPmsSpuImageList(PmsSpuImage pmsSpuImage);

    /**
     * 新增spu图片
     *
     * @param pmsSpuImage spu图片
     * @return 结果
     */
    int insertPmsSpuImage(PmsSpuImage pmsSpuImage);

    /**
     * 修改spu图片
     *
     * @param pmsSpuImage spu图片
     * @return 结果
     */
    int updatePmsSpuImage(PmsSpuImage pmsSpuImage);

    /**
     * 批量删除spu图片
     *
     * @param spuIds 需要删除的spu图片主键集合
     * @return 结果
     */
    int deletePmsSpuImageBySpuIds(Long[] spuIds);

    /**
     * 删除spu图片信息
     *
     * @param spuId spu图片主键
     * @return 结果
     */
    int deletePmsSpuImageBySpuId(Long spuId);
}
