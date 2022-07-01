package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsMemberPriceMapper;
import com.qinweizhao.activity.model.entity.AmsMemberPrice;
import com.qinweizhao.activity.service.IAmsMemberPriceService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品会员价格Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsMemberPriceServiceImpl extends QwzServiceImpl<AmsMemberPriceMapper, AmsMemberPrice> implements IAmsMemberPriceService {
    @Resource
    private AmsMemberPriceMapper amsMemberPriceMapper;


    /**
     * 查询商品会员价格列表
     *
     * @param amsMemberPrice 商品会员价格
     * @return 商品会员价格
     */
    @Override
    public List<AmsMemberPrice> selectAmsMemberPriceList(AmsMemberPrice amsMemberPrice) {
        return amsMemberPriceMapper.selectAmsMemberPriceList(amsMemberPrice);
    }

}
