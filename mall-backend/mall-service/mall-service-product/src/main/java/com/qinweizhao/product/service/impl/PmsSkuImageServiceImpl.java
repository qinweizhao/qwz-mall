package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.domain.PmsSkuImage;
import com.qinweizhao.product.mapper.PmsSkuImageMapper;
import com.qinweizhao.product.service.IPmsSkuImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku图片Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-12
 */
@Service
public class PmsSkuImageServiceImpl implements IPmsSkuImageService {
    @Resource
    private PmsSkuImageMapper pmsSkuImageMapper;

    /**
     * 查询sku图片
     *
     * @param skuId sku图片主键
     * @return sku图片
     */
    @Override
    public PmsSkuImage selectPmsSkuImageBySkuId(Long skuId) {
        return pmsSkuImageMapper.selectPmsSkuImageBySkuId(skuId);
    }

    /**
     * 查询sku图片列表
     *
     * @param pmsSkuImage sku图片
     * @return sku图片
     */
    @Override
    public List<PmsSkuImage> selectPmsSkuImageList(PmsSkuImage pmsSkuImage) {
        return pmsSkuImageMapper.selectPmsSkuImageList(pmsSkuImage);
    }

    /**
     * 新增sku图片
     *
     * @param pmsSkuImage sku图片
     * @return 结果
     */
    @Override
    public int insertPmsSkuImage(PmsSkuImage pmsSkuImage) {
        pmsSkuImage.setCreateTime(DateUtils.getNowDate());
        return pmsSkuImageMapper.insertPmsSkuImage(pmsSkuImage);
    }

    /**
     * 修改sku图片
     *
     * @param pmsSkuImage sku图片
     * @return 结果
     */
    @Override
    public int updatePmsSkuImage(PmsSkuImage pmsSkuImage) {
        pmsSkuImage.setUpdateTime(DateUtils.getNowDate());
        return pmsSkuImageMapper.updatePmsSkuImage(pmsSkuImage);
    }

    /**
     * 批量删除sku图片
     *
     * @param skuIds 需要删除的sku图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuImageBySkuIds(Long[] skuIds) {
        return pmsSkuImageMapper.deletePmsSkuImageBySkuIds(skuIds);
    }

    /**
     * 删除sku图片信息
     *
     * @param skuId sku图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuImageBySkuId(Long skuId) {
        return pmsSkuImageMapper.deletePmsSkuImageBySkuId(skuId);
    }
}
