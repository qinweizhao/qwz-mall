package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsCategoryBoundsMapper;
import com.qinweizhao.activity.model.entity.AmsCategoryBounds;
import com.qinweizhao.activity.service.IAmsCategoryBoundsService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品分类积分设置Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCategoryBoundsServiceImpl extends QwzServiceImpl<AmsCategoryBoundsMapper, AmsCategoryBounds> implements IAmsCategoryBoundsService {


    /**
     * 查询商品分类积分设置列表
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 商品分类积分设置
     */
    @Override
    public List<AmsCategoryBounds> selectAmsCategoryBoundsList(AmsCategoryBounds amsCategoryBounds) {
        return this.baseMapper.selectAmsCategoryBoundsList(amsCategoryBounds);
    }


}
