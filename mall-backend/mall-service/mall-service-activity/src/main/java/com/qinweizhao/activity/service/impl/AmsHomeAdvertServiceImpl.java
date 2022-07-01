package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsHomeAdvertMapper;
import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.service.IAmsHomeAdvertService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页轮播广告Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsHomeAdvertServiceImpl extends QwzServiceImpl<AmsHomeAdvertMapper, AmsHomeAdvert> implements IAmsHomeAdvertService {
    @Resource
    private AmsHomeAdvertMapper amsHomeAdvertMapper;


    /**
     * 查询首页轮播广告列表
     *
     * @param amsHomeAdvert 首页轮播广告
     * @return 首页轮播广告
     */
    @Override
    public List<AmsHomeAdvert> selectAmsHomeAdvertList(AmsHomeAdvert amsHomeAdvert) {
        return amsHomeAdvertMapper.selectAmsHomeAdvertList(amsHomeAdvert);
    }
}
