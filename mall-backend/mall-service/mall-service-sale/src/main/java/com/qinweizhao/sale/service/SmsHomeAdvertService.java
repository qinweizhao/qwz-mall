package com.qinweizhao.sale.service;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.sale.model.entity.SmsHomeAdvert;
import com.qinweizhao.sale.model.param.HomeAdvertPageParam;

/**
 * 首页轮播广告Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface SmsHomeAdvertService extends QwzService<SmsHomeAdvert> {


    /**
     * 分页信息
     *
     * @param pageParam pageParam
     * @return PageResult
     */
    PageResult<SmsHomeAdvert> page(HomeAdvertPageParam pageParam);
}
