package com.qinweizhao.sale.service.impl;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.sale.mapper.SmsHomeAdvertMapper;
import com.qinweizhao.sale.model.entity.SmsHomeAdvert;
import com.qinweizhao.sale.model.param.HomeAdvertPageParam;
import com.qinweizhao.sale.service.SmsHomeAdvertService;
import org.springframework.stereotype.Service;

/**
 * 首页轮播广告Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class SmsHomeAdvertServiceImpl extends QwzServiceImpl<SmsHomeAdvertMapper, SmsHomeAdvert> implements SmsHomeAdvertService {

    @Override
    public PageResult<SmsHomeAdvert> page(HomeAdvertPageParam pageParam) {
        return this.baseMapper.selectPage(pageParam);
    }
}
