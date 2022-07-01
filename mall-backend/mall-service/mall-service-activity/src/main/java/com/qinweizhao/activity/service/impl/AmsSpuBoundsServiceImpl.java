package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsSpuBoundsMapper;
import com.qinweizhao.activity.model.entity.AmsSpuBounds;
import com.qinweizhao.activity.service.IAmsSpuBoundsService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品spu积分设置Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsSpuBoundsServiceImpl extends QwzServiceImpl<AmsSpuBoundsMapper, AmsSpuBounds> implements IAmsSpuBoundsService {
    @Resource
    private AmsSpuBoundsMapper amsSpuBoundsMapper;


    /**
     * 查询商品spu积分设置列表
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 商品spu积分设置
     */
    @Override
    public List<AmsSpuBounds> selectAmsSpuBoundsList(AmsSpuBounds amsSpuBounds) {
        return amsSpuBoundsMapper.selectAmsSpuBoundsList(amsSpuBounds);
    }

}
