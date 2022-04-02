package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.PmsSkuImages;
import com.qinweizhao.product.mapper.PmsSkuImagesMapper;
import com.qinweizhao.product.service.IPmsSkuImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * sku图片Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@Service
public class PmsSkuImagesServiceImpl implements IPmsSkuImagesService {
    @Autowired
    private PmsSkuImagesMapper pmsSkuImagesMapper;

    /**
     * 查询sku图片
     *
     * @param id sku图片主键
     * @return sku图片
     */
    @Override
    public PmsSkuImages selectPmsSkuImagesById(Long id) {
        return pmsSkuImagesMapper.selectPmsSkuImagesById(id);
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
        return pmsSkuImagesMapper.updatePmsSkuImages(pmsSkuImages);
    }

    /**
     * 批量删除sku图片
     *
     * @param ids 需要删除的sku图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuImagesByIds(Long[] ids) {
        return pmsSkuImagesMapper.deletePmsSkuImagesByIds(ids);
    }

    /**
     * 删除sku图片信息
     *
     * @param id sku图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSkuImagesById(Long id) {
        return pmsSkuImagesMapper.deletePmsSkuImagesById(id);
    }
}
