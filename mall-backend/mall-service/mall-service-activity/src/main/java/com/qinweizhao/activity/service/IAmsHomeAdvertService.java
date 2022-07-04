package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.model.param.AmsHomeAdvertPageParam;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;

/**
 * 首页轮播广告Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsHomeAdvertService extends QwzService<AmsHomeAdvert> {


    /**
     * 分页信息
     * @param pageParam pageParam
     * @return PageResult
     */
    PageResult<AmsHomeAdvert> page(AmsHomeAdvertPageParam pageParam);
}
