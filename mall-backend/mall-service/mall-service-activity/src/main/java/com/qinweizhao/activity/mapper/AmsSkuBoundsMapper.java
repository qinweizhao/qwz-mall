package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsSkuBounds;
import com.qinweizhao.component.mybatis.mapper.QwzMapper;

import java.util.List;

/**
 * 商品sku积分设置Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsSkuBoundsMapper extends QwzMapper<AmsSkuBounds> {
    /**
     * 查询商品sku积分设置
     *
     * @param id 商品sku积分设置主键
     * @return 商品sku积分设置
     */
    AmsSkuBounds selectAmsSkuBoundsById(Long id);

    /**
     * 查询商品sku积分设置列表
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 商品sku积分设置集合
     */
    List<AmsSkuBounds> selectAmsSkuBoundsList(AmsSkuBounds amsSkuBounds);

    /**
     * 新增商品sku积分设置
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 结果
     */
    int insertAmsSkuBounds(AmsSkuBounds amsSkuBounds);

    /**
     * 修改商品sku积分设置
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 结果
     */
    int updateAmsSkuBounds(AmsSkuBounds amsSkuBounds);

    /**
     * 删除商品sku积分设置
     *
     * @param id 商品sku积分设置主键
     * @return 结果
     */
    int deleteAmsSkuBoundsById(Long id);

    /**
     * 批量删除商品sku积分设置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsSkuBoundsByIds(Long[] ids);
}
