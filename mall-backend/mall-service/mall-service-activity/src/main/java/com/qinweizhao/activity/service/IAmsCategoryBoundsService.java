package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsCategoryBounds;

import java.util.List;

/**
 * 商品分类积分设置Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCategoryBoundsService {
    /**
     * 查询商品分类积分设置
     *
     * @param id 商品分类积分设置主键
     * @return 商品分类积分设置
     */
    AmsCategoryBounds selectAmsCategoryBoundsById(Long id);

    /**
     * 查询商品分类积分设置列表
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 商品分类积分设置集合
     */
    List<AmsCategoryBounds> selectAmsCategoryBoundsList(AmsCategoryBounds amsCategoryBounds);

    /**
     * 新增商品分类积分设置
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 结果
     */
    int insertAmsCategoryBounds(AmsCategoryBounds amsCategoryBounds);

    /**
     * 修改商品分类积分设置
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 结果
     */
    int updateAmsCategoryBounds(AmsCategoryBounds amsCategoryBounds);

    /**
     * 批量删除商品分类积分设置
     *
     * @param ids 需要删除的商品分类积分设置主键集合
     * @return 结果
     */
    int deleteAmsCategoryBoundsByIds(Long[] ids);

    /**
     * 删除商品分类积分设置信息
     *
     * @param id 商品分类积分设置主键
     * @return 结果
     */
    int deleteAmsCategoryBoundsById(Long id);
}
