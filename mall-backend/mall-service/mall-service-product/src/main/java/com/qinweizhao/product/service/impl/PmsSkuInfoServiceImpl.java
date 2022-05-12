package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSkuInfo;
import com.qinweizhao.product.mapper.PmsSkuInfoMapper;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSkuInfoServiceImpl implements IPmsSkuInfoService {
    @Resource
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    /**
     * 查询sku信息
     *
     * @param skuId sku信息主键
     * @return sku信息
     */
    @Override
    public PmsSkuInfo getById(Long skuId) {
        return pmsSkuInfoMapper.selectPmsSkuInfoBySkuId(skuId);
    }

    /**
     * 查询sku信息列表
     *
     * @param pmsSkuInfo sku信息
     * @return sku信息
     */
    @Override
    public List<PmsSkuInfo> list(PmsSkuInfo pmsSkuInfo) {
        return pmsSkuInfoMapper.selectPmsSkuInfoList(pmsSkuInfo);
    }

    /**
     * 新增sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    @Override
    public int save(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setCreateTime(DateUtils.getNowDate());
        return pmsSkuInfoMapper.insertPmsSkuInfo(pmsSkuInfo);
    }

    /**
     * 修改sku信息
     *
     * @param pmsSkuInfo sku信息
     * @return 结果
     */
    @Override
    public int updateById(PmsSkuInfo pmsSkuInfo) {
        pmsSkuInfo.setUpdateTime(DateUtils.getNowDate());
        return pmsSkuInfoMapper.updatePmsSkuInfo(pmsSkuInfo);
    }

    /**
     * 批量删除sku信息
     *
     * @param skuIds 需要删除的sku信息主键
     * @return 结果
     */
    @Override
    public int removeByIds(Long[] skuIds) {
        return pmsSkuInfoMapper.deletePmsSkuInfoBySkuIds(skuIds);
    }

    /**
     * 删除sku信息信息
     *
     * @param skuId sku信息主键
     * @return 结果
     */
    @Override
    public int removeById(Long skuId) {
        return pmsSkuInfoMapper.deletePmsSkuInfoBySkuId(skuId);
    }

    @Override
    public List<PmsSkuInfo> listBySpuId(Long spuId) {
        return pmsSkuInfoMapper.selectListBySpuId(spuId);
    }
}
