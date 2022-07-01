package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsCategoryBounds;
import com.qinweizhao.activity.mapper.AmsCategoryBoundsMapper;
import com.qinweizhao.activity.service.IAmsCategoryBoundsService;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类积分设置Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsCategoryBoundsServiceImpl implements IAmsCategoryBoundsService {
    @Resource
    private AmsCategoryBoundsMapper amsCategoryBoundsMapper;

    /**
     * 查询商品分类积分设置
     *
     * @param id 商品分类积分设置主键
     * @return 商品分类积分设置
     */
    @Override
    public AmsCategoryBounds selectAmsCategoryBoundsById(Long id) {
        return amsCategoryBoundsMapper.selectAmsCategoryBoundsById(id);
    }

    /**
     * 查询商品分类积分设置列表
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 商品分类积分设置
     */
    @Override
    public List<AmsCategoryBounds> selectAmsCategoryBoundsList(AmsCategoryBounds amsCategoryBounds) {
        return amsCategoryBoundsMapper.selectAmsCategoryBoundsList(amsCategoryBounds);
    }

    /**
     * 新增商品分类积分设置
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 结果
     */
    @Override
    public int insertAmsCategoryBounds(AmsCategoryBounds amsCategoryBounds) {
        amsCategoryBounds.setCreateTime(DateUtils.getNowDate());
        return amsCategoryBoundsMapper.insertAmsCategoryBounds(amsCategoryBounds);
    }

    /**
     * 修改商品分类积分设置
     *
     * @param amsCategoryBounds 商品分类积分设置
     * @return 结果
     */
    @Override
    public int updateAmsCategoryBounds(AmsCategoryBounds amsCategoryBounds) {
        amsCategoryBounds.setUpdateTime(DateUtils.getNowDate());
        return amsCategoryBoundsMapper.updateAmsCategoryBounds(amsCategoryBounds);
    }

    /**
     * 批量删除商品分类积分设置
     *
     * @param ids 需要删除的商品分类积分设置主键
     * @return 结果
     */
    @Override
    public int deleteAmsCategoryBoundsByIds(Long[] ids) {
        return amsCategoryBoundsMapper.deleteAmsCategoryBoundsByIds(ids);
    }

    /**
     * 删除商品分类积分设置信息
     *
     * @param id 商品分类积分设置主键
     * @return 结果
     */
    @Override
    public int deleteAmsCategoryBoundsById(Long id) {
        return amsCategoryBoundsMapper.deleteAmsCategoryBoundsById(id);
    }
}
