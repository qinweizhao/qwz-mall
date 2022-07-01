package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsSpuBounds;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 商品spu积分设置Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsSpuBoundsService extends QwzService<AmsSpuBounds> {

    /**
     * 查询商品spu积分设置列表
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 商品spu积分设置集合
     */
    List<AmsSpuBounds> selectAmsSpuBoundsList(AmsSpuBounds amsSpuBounds);


}
