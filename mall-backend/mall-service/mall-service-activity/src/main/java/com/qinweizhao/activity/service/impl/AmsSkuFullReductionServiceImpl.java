package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsSkuFullReduction;
import com.qinweizhao.activity.mapper.AmsSkuFullReductionMapper;
import com.qinweizhao.activity.service.IAmsSkuFullReductionService;
import com.qinweizhao.common.core.utils.DateUtils;
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
public class AmsSkuFullReductionServiceImpl implements IAmsSkuFullReductionService {
    @Resource
    private AmsSkuFullReductionMapper amsSkuFullReductionMapper;

    /**
     * 查询商品满减信息
     *
     * @param id 商品满减信息主键
     * @return 商品满减信息
     */
    @Override
    public AmsSkuFullReduction selectAmsSkuFullReductionById(Long id) {
        return amsSkuFullReductionMapper.selectAmsSkuFullReductionById(id);
    }

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

    /**
     * 新增商品满减信息
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 结果
     */
    @Override
    public int insertAmsSkuFullReduction(AmsSkuFullReduction amsSkuFullReduction) {
        amsSkuFullReduction.setCreateTime(DateUtils.getNowDate());
        return amsSkuFullReductionMapper.insertAmsSkuFullReduction(amsSkuFullReduction);
    }

    /**
     * 修改商品满减信息
     *
     * @param amsSkuFullReduction 商品满减信息
     * @return 结果
     */
    @Override
    public int updateAmsSkuFullReduction(AmsSkuFullReduction amsSkuFullReduction) {
        amsSkuFullReduction.setUpdateTime(DateUtils.getNowDate());
        return amsSkuFullReductionMapper.updateAmsSkuFullReduction(amsSkuFullReduction);
    }

    /**
     * 批量删除商品满减信息
     *
     * @param ids 需要删除的商品满减信息主键
     * @return 结果
     */
    @Override
    public int deleteAmsSkuFullReductionByIds(Long[] ids) {
        return amsSkuFullReductionMapper.deleteAmsSkuFullReductionByIds(ids);
    }

    /**
     * 删除商品满减信息信息
     *
     * @param id 商品满减信息主键
     * @return 结果
     */
    @Override
    public int deleteAmsSkuFullReductionById(Long id) {
        return amsSkuFullReductionMapper.deleteAmsSkuFullReductionById(id);
    }
}
