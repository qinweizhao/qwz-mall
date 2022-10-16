package com.qinweizhao.sale.mapper;

import com.qinweizhao.sale.model.entity.SmsHomeAdvert;
import com.qinweizhao.sale.model.param.HomeAdvertPageParam;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;

/**
 * 首页轮播广告Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface SmsHomeAdvertMapper extends QwzMapper<SmsHomeAdvert> {

    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return PageResult
     */
    default PageResult<SmsHomeAdvert> selectPage(HomeAdvertPageParam pageParam){
        return selectPage(pageParam, new QwzLambdaQueryWrapper<SmsHomeAdvert>()
                .likeIfPresent(SmsHomeAdvert::getName, pageParam.getName())
                .eqIfPresent(SmsHomeAdvert::getStatus, pageParam.getStatus())
                .orderByDesc(SmsHomeAdvert::getId));
    }
}
