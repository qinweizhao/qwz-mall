package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSkuFullReductionMapper;
import com.qinweizhao.activity.model.entity.AmsSkuFullReduction;
import com.qinweizhao.activity.service.IAmsSkuFullReductionService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品满减信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSkuFullReductionServiceImpl extends QwzServiceImpl<AmsSkuFullReductionMapper, AmsSkuFullReduction> implements IAmsSkuFullReductionService {
    @Resource
    private AmsSkuFullReductionMapper amsSkuFullReductionMapper;


    /**
     * 查询商品满减信息列表
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 商品满减信息
     */
    @Override
    public List<AmsSkuFullReduction> selectAmsSkuFullReductionList(AmsSkuFullReduction amsSkuFullReduction) {
        return amsSkuFullReductionMapper.selectAmsSkuFullReductionList(amsSkuFullReduction);
    }

}
