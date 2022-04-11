package com.qinweizhao.product.service.impl;

import java.util.List;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qinweizhao.product.mapper.PmsSkuImagesMapper;
import com.qinweizhao.product.domain.PmsSkuImages;
import com.qinweizhao.product.service.IPmsSkuImagesService;

/**
 * sku图片Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSkuImagesServiceImpl implements IPmsSkuImagesService {
    @Resource
    private PmsSkuImagesMapper pmsSkuImagesMapper;

    /**
     * 查询sku图片
     *
     * @param skuId sku图片主键
     * @return sku图片
     */
    @Override
    public PmsSkuImages selectPmsSkuImagesBySkuId(Long skuId) {
        return pmsSkuImagesMapper.selectPmsSkuImagesBySkuId(skuId);
    }

    /**
     * 查询sku图片列表
     *
     * @param pmsSkuImages sku图片
     * @return sku图片
     */
    @Override
    public List<PmsSkuImages> selectPmsSkuImagesList(PmsSkuImages pmsSkuImages) {
        return pmsSkuImagesMapper.selectPmsSkuImagesList(pmsSkuImages);
    }

    /**
     * 新增sku图片
     *
     * @param pmsSkuImages sku图片
     * @return 结果
     */
    @Override
    public int insertPmsSkuImages(PmsSkuImages pmsSkuImages) {
        pmsSkuImages.setCreateTime(DateUtils.getNowDate());
        return pmsSkuImagesMapper.insertPmsSkuImages(pmsSkuImages);
    }

    /**
     * 修改sku图片
     *
     * @param pmsSkuImages sku图片
     * @return 结果
     */
    @Override
    public int updatePmsSkuImages(PmsSkuImages pmsSkuImages) {
        pmsSkuImages.setUpdateTime(DateUtils.getNowDate());
        return pmsSkuImagesMapper.updatePmsSkuImages(pmsSkuImages);
    }

    /**
     * 批量删除sku图片
     *
     * @param skuIds 需要删除的sku图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuImagesBySkuIds(Long[] skuIds) {
        return pmsSkuImagesMapper.deletePmsSkuImagesBySkuIds(skuIds);
    }

    /**
     * 删除sku图片信息
     *
     * @param skuId sku图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuImagesBySkuId(Long skuId) {
        return pmsSkuImagesMapper.deletePmsSkuImagesBySkuId(skuId);
    }
}
