package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.model.param.AmsHomeAdvertPageParam;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;

/**
 * 首页轮播广告Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsHomeAdvertMapper extends QwzBaseMapper<AmsHomeAdvert> {

    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return PageResult
     */
    default PageResult<AmsHomeAdvert> selectPage(AmsHomeAdvertPageParam pageParam){
        return selectPage(pageParam, new QwzLambdaQueryWrapper<AmsHomeAdvert>()
                .likeIfPresent(AmsHomeAdvert::getName, pageParam.getName())
                .eqIfPresent(AmsHomeAdvert::getStatus, pageParam.getStatus())
                .orderByDesc(AmsHomeAdvert::getId));
    }
}
