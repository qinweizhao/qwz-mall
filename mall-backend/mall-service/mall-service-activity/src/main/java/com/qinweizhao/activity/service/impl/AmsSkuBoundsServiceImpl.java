package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsSkuBounds;
import com.qinweizhao.activity.mapper.AmsSkuBoundsMapper;
import com.qinweizhao.activity.service.IAmsSkuBoundsService;
import com.qinweizhao.common.core.utils.DateUtils;
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
public class AmsSkuBoundsServiceImpl implements IAmsSkuBoundsService {
    @Resource
    private AmsSkuBoundsMapper amsSkuBoundsMapper;

    /**
     * 查询商品sku积分设置
     *
     * @param id 商品sku积分设置主键
     * @return 商品sku积分设置
     */
    @Override
    public AmsSkuBounds selectAmsSkuBoundsById(Long id) {
        return amsSkuBoundsMapper.selectAmsSkuBoundsById(id);
    }

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

    /**
     * 新增商品sku积分设置
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 结果
     */
    @Override
    public int insertAmsSkuBounds(AmsSkuBounds amsSkuBounds) {
        amsSkuBounds.setCreateTime(DateUtils.getNowDate());
        return amsSkuBoundsMapper.insertAmsSkuBounds(amsSkuBounds);
    }

    /**
     * 修改商品sku积分设置
     *
     * @param amsSkuBounds 商品sku积分设置
     * @return 结果
     */
    @Override
    public int updateAmsSkuBounds(AmsSkuBounds amsSkuBounds) {
        amsSkuBounds.setUpdateTime(DateUtils.getNowDate());
        return amsSkuBoundsMapper.updateAmsSkuBounds(amsSkuBounds);
    }

    /**
     * 批量删除商品sku积分设置
     *
     * @param ids 需要删除的商品sku积分设置主键
     * @return 结果
     */
    @Override
    public int deleteAmsSkuBoundsByIds(Long[] ids) {
        return amsSkuBoundsMapper.deleteAmsSkuBoundsByIds(ids);
    }

    /**
     * 删除商品sku积分设置信息
     *
     * @param id 商品sku积分设置主键
     * @return 结果
     */
    @Override
    public int deleteAmsSkuBoundsById(Long id) {
        return amsSkuBoundsMapper.deleteAmsSkuBoundsById(id);
    }
}
