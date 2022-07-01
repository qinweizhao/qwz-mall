package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsCategoryBounds;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 商品分类积分设置Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsCategoryBoundsService extends QwzService<AmsCategoryBounds> {


    /**
     * 查询商品分类积分设置列表
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 商品分类积分设置集合
     */
    List<AmsCategoryBounds> selectAmsCategoryBoundsList(AmsCategoryBounds amsCategoryBounds);


}
