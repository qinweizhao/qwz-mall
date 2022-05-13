package com.qinweizhao.product.mapper;

import com.qinweizhao.product.model.entity.PmsSpuImage;

import java.util.List;

/**
 * spu图片Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-03
 */
public interface PmsSpuImageMapper {
    /**
     * 查询spu图片
     *
     * @param id spu图片主键
     * @return spu图片
     */
    public PmsSpuImage selectPmsSpuImageById(Long id);

    /**
     * 查询spu图片列表
     *
     * @param pmsSpuImage spu图片
     * @return spu图片集合
     */
    public List<PmsSpuImage> selectPmsSpuImageList(PmsSpuImage pmsSpuImage);

    /**
     * 新增spu图片
     *
     * @param pmsSpuImage spu图片
     * @return 结果
     */
    public int insertPmsSpuImage(PmsSpuImage pmsSpuImage);

    /**
     * 修改spu图片
     *
     * @param pmsSpuImage spu图片
     * @return 结果
     */
    public int updatePmsSpuImage(PmsSpuImage pmsSpuImage);

    /**
     * 删除spu图片
     *
     * @param id spu图片主键
     * @return 结果
     */
    public int deletePmsSpuImageById(Long id);

    /**
     * 批量删除spu图片
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSpuImageByIds(Long[] ids);
}
