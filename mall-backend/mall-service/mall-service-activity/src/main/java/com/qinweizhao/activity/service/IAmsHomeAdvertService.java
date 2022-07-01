package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 首页轮播广告Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsHomeAdvertService extends QwzService<AmsHomeAdvert> {

    /**
     * 查询首页轮播广告列表
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 首页轮播广告集合
     */
    List<AmsHomeAdvert> selectAmsHomeAdvertList(AmsHomeAdvert amsHomeAdvert);


}
