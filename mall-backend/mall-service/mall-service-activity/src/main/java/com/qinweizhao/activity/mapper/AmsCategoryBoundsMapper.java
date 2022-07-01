package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsCategoryBounds;

import java.util.List;

/**
 * 商品分类积分设置Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsCategoryBoundsMapper {
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
     * 删除商品分类积分设置
     *
     * @param id 商品分类积分设置主键
     * @return 结果
     */
    int deleteAmsCategoryBoundsById(Long id);

    /**
     * 批量删除商品分类积分设置
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsCategoryBoundsByIds(Long[] ids);
}
