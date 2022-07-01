package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSpuBounds;

import java.util.List;

/**
 * 商品spu积分设置Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSpuBoundsService {
    /**
     * 查询商品spu积分设置
     *
     * @param id 商品spu积分设置主键
     * @return 商品spu积分设置
     */
    AmsSpuBounds selectAmsSpuBoundsById(Long id);

    /**
     * 查询商品spu积分设置列表
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 商品spu积分设置集合
     */
    List<AmsSpuBounds> selectAmsSpuBoundsList(AmsSpuBounds amsSpuBounds);

    /**
     * 新增商品spu积分设置
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 结果
     */
    int insertAmsSpuBounds(AmsSpuBounds amsSpuBounds);

    /**
     * 修改商品spu积分设置
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 结果
     */
    int updateAmsSpuBounds(AmsSpuBounds amsSpuBounds);

    /**
     * 批量删除商品spu积分设置
     *
     * @param ids 需要删除的商品spu积分设置主键集合
     * @return 结果
     */
    int deleteAmsSpuBoundsByIds(Long[] ids);

    /**
     * 删除商品spu积分设置信息
     *
     * @param id 商品spu积分设置主键
     * @return 结果
     */
    int deleteAmsSpuBoundsById(Long id);
}
