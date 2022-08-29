package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsHomeAdvertMapper;
import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.model.param.HomeAdvertPageParam;
import com.qinweizhao.activity.service.IAmsHomeAdvertService;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 首页轮播广告Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsHomeAdvertServiceImpl extends QwzServiceImpl<AmsHomeAdvertMapper, AmsHomeAdvert> implements IAmsHomeAdvertService {

    @Override
    public PageResult<AmsHomeAdvert> page(HomeAdvertPageParam pageParam) {
        return this.baseMapper.selectPage(pageParam);
    }
}
