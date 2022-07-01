package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSkuBoundsMapper;
import com.qinweizhao.activity.model.entity.AmsSkuBounds;
import com.qinweizhao.activity.service.IAmsSkuBoundsService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品sku积分设置Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSkuBoundsServiceImpl extends QwzServiceImpl<AmsSkuBoundsMapper, AmsSkuBounds> implements IAmsSkuBoundsService {
    @Resource
    private AmsSkuBoundsMapper amsSkuBoundsMapper;


    /**
     * 查询商品sku积分设置列表
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 商品sku积分设置
     */
    @Override
    public List<AmsSkuBounds> selectAmsSkuBoundsList(AmsSkuBounds amsSkuBounds) {
        return amsSkuBoundsMapper.selectAmsSkuBoundsList(amsSkuBounds);
    }
}
