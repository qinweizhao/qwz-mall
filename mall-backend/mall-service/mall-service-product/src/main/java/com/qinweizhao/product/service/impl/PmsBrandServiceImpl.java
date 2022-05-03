package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsBrand;
import com.qinweizhao.product.mapper.PmsBrandMapper;
import com.qinweizhao.product.mapper.PmsCategoryBrandMapper;
import com.qinweizhao.product.service.IPmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 品牌Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsBrandServiceImpl implements IPmsBrandService {
    @Resource
    private PmsBrandMapper pmsBrandMapper;

    @Resource
    private PmsCategoryBrandMapper pmsCategoryBrandMapper;

    /**
     * 查询品牌
     *
     * @param brandId 品牌主键
     * @return 品牌
     */
    @Override
    public PmsBrand getById(Long brandId) {
        return pmsBrandMapper.selectPmsBrandByBrandId(brandId);
    }

    /**
     * 查询品牌列表
     *
     * @param pmsBrand 品牌
     * @return 品牌
     */
    @Override
    public List<PmsBrand> list(PmsBrand pmsBrand) {
        return pmsBrandMapper.selectPmsBrandList(pmsBrand);
    }

    /**
     * 新增品牌
     *
     * @param pmsBrand 品牌
     * @return 结果
     */
    @Override
    public int save(PmsBrand pmsBrand) {
        pmsBrand.setCreateTime(DateUtils.getNowDate());
        return pmsBrandMapper.insertPmsBrand(pmsBrand);
    }

    /**
     * 修改品牌
     *
     * @param pmsBrand 品牌
     * @return 结果
     */
    @Override
    public int updateById(PmsBrand pmsBrand) {
        pmsBrand.setUpdateTime(DateUtils.getNowDate());
        return pmsBrandMapper.updatePmsBrand(pmsBrand);
    }

    /**
     * 批量删除品牌
     *
     * @param brandIds 需要删除的品牌主键
     * @return 结果
     */
    @Override
    public int deleteByIds(Long[] brandIds) {
        return pmsBrandMapper.deletePmsBrandByBrandIds(brandIds);
    }

    /**
     * 删除品牌信息
     *
     * @param brandId 品牌主键
     * @return 结果
     */
    @Override
    public int removeById(Long brandId) {
        return pmsBrandMapper.deletePmsBrandByBrandId(brandId);
    }

}
