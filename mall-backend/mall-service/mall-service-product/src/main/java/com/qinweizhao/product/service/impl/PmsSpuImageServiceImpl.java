package com.qinweizhao.product.service.impl;

import java.util.List;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qinweizhao.product.mapper.PmsSpuImageMapper;
import com.qinweizhao.product.domain.PmsSpuImage;
import com.qinweizhao.product.service.IPmsSpuImageService;

/**
 * spu图片Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSpuImageServiceImpl implements IPmsSpuImageService {
    @Autowired
    private PmsSpuImageMapper pmsSpuImageMapper;

    /**
     * 查询spu图片
     *
     * @param spuId spu图片主键
     * @return spu图片
     */
    @Override
    public PmsSpuImage selectPmsSpuImageBySpuId(Long spuId) {
        return pmsSpuImageMapper.selectPmsSpuImageBySpuId(spuId);
    }

    /**
     * 查询spu图片列表
     *
     * @param pmsSpuImage spu图片
     * @return spu图片
     */
    @Override
    public List<PmsSpuImage> selectPmsSpuImageList(PmsSpuImage pmsSpuImage) {
        return pmsSpuImageMapper.selectPmsSpuImageList(pmsSpuImage);
    }

    /**
     * 新增spu图片
     *
     * @param pmsSpuImage spu图片
     * @return 结果
     */
    @Override
    public int insertPmsSpuImage(PmsSpuImage pmsSpuImage) {
        pmsSpuImage.setCreateTime(DateUtils.getNowDate());
        return pmsSpuImageMapper.insertPmsSpuImage(pmsSpuImage);
    }

    /**
     * 修改spu图片
     *
     * @param pmsSpuImage spu图片
     * @return 结果
     */
    @Override
    public int updatePmsSpuImage(PmsSpuImage pmsSpuImage) {
        pmsSpuImage.setUpdateTime(DateUtils.getNowDate());
        return pmsSpuImageMapper.updatePmsSpuImage(pmsSpuImage);
    }

    /**
     * 批量删除spu图片
     *
     * @param spuIds 需要删除的spu图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuImageBySpuIds(Long[] spuIds) {
        return pmsSpuImageMapper.deletePmsSpuImageBySpuIds(spuIds);
    }

    /**
     * 删除spu图片信息
     *
     * @param spuId spu图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuImageBySpuId(Long spuId) {
        return pmsSpuImageMapper.deletePmsSpuImageBySpuId(spuId);
    }
}
