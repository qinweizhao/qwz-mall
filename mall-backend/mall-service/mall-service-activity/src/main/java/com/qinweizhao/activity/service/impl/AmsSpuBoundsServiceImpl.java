package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsSpuBounds;
import com.qinweizhao.activity.mapper.AmsSpuBoundsMapper;
import com.qinweizhao.activity.service.IAmsSpuBoundsService;
import com.qinweizhao.common.core.utils.DateUtils;
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
public class AmsSpuBoundsServiceImpl implements IAmsSpuBoundsService {
    @Resource
    private AmsSpuBoundsMapper amsSpuBoundsMapper;

    /**
     * 查询商品spu积分设置
     *
     * @param id 商品spu积分设置主键
     * @return 商品spu积分设置
     */
    @Override
    public AmsSpuBounds selectAmsSpuBoundsById(Long id) {
        return amsSpuBoundsMapper.selectAmsSpuBoundsById(id);
    }

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

    /**
     * 新增商品spu积分设置
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 结果
     */
    @Override
    public int insertAmsSpuBounds(AmsSpuBounds amsSpuBounds) {
        amsSpuBounds.setCreateTime(DateUtils.getNowDate());
        return amsSpuBoundsMapper.insertAmsSpuBounds(amsSpuBounds);
    }

    /**
     * 修改商品spu积分设置
     *
     * @param amsSpuBounds 商品spu积分设置
     * @return 结果
     */
    @Override
    public int updateAmsSpuBounds(AmsSpuBounds amsSpuBounds) {
        amsSpuBounds.setUpdateTime(DateUtils.getNowDate());
        return amsSpuBoundsMapper.updateAmsSpuBounds(amsSpuBounds);
    }

    /**
     * 批量删除商品spu积分设置
     *
     * @param ids 需要删除的商品spu积分设置主键
     * @return 结果
     */
    @Override
    public int deleteAmsSpuBoundsByIds(Long[] ids) {
        return amsSpuBoundsMapper.deleteAmsSpuBoundsByIds(ids);
    }

    /**
     * 删除商品spu积分设置信息
     *
     * @param id 商品spu积分设置主键
     * @return 结果
     */
    @Override
    public int deleteAmsSpuBoundsById(Long id) {
        return amsSpuBoundsMapper.deleteAmsSpuBoundsById(id);
    }
}
