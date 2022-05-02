package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSpuImage;
import com.qinweizhao.product.mapper.PmsSpuImageMapper;
import com.qinweizhao.product.service.IPmsSpuImageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu图片Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-03
 */
@Service
public class PmsSpuImageServiceImpl implements IPmsSpuImageService {
    @Resource
    private PmsSpuImageMapper pmsSpuImageMapper;

    /**
     * 查询spu图片
     *
     * @param id spu图片主键
     * @return spu图片
     */
    @Override
    public PmsSpuImage selectPmsSpuImageById(Long id) {
        return pmsSpuImageMapper.selectPmsSpuImageById(id);
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
     * @param ids 需要删除的spu图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuImageByIds(Long[] ids) {
        return pmsSpuImageMapper.deletePmsSpuImageByIds(ids);
    }

    /**
     * 删除spu图片信息
     *
     * @param id spu图片主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuImageById(Long id) {
        return pmsSpuImageMapper.deletePmsSpuImageById(id);
    }
}
