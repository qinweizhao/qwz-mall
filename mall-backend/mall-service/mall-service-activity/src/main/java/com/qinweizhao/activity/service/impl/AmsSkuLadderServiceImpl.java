package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSkuLadderMapper;
import com.qinweizhao.activity.model.entity.AmsSkuLadder;
import com.qinweizhao.activity.service.IAmsSkuLadderService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品阶梯价格Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSkuLadderServiceImpl extends QwzServiceImpl<AmsSkuLadderMapper, AmsSkuLadder> implements IAmsSkuLadderService {
    @Resource
    private AmsSkuLadderMapper amsSkuLadderMapper;


    /**
     * 查询商品阶梯价格列表
     *
     * @param amsSkuLadder 商品阶梯价格
     * @return 商品阶梯价格
     */
    @Override
    public List<AmsSkuLadder> selectAmsSkuLadderList(AmsSkuLadder amsSkuLadder) {
        return amsSkuLadderMapper.selectAmsSkuLadderList(amsSkuLadder);
    }

}
