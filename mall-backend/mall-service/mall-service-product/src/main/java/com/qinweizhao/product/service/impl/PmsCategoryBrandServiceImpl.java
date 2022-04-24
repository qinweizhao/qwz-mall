package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsCategoryBrand;
import com.qinweizhao.product.mapper.PmsCategoryBrandMapper;
import com.qinweizhao.product.service.IPmsCategoryBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 分类&品牌关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsCategoryBrandServiceImpl implements IPmsCategoryBrandService {
    @Resource
    private PmsCategoryBrandMapper pmsCategoryBrandMapper;

    /**
     * 查询分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 分类&品牌关联
     */
    @Override
    public PmsCategoryBrand selectPmsCategoryBrandById(Long id) {
        return pmsCategoryBrandMapper.selectPmsCategoryBrandById(id);
    }

    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 分类&品牌关联
     */
    @Override
    public List<PmsCategoryBrand> selectPmsCategoryBrandList(PmsCategoryBrand pmsCategoryBrand) {
        return pmsCategoryBrandMapper.selectPmsCategoryBrandList(pmsCategoryBrand);
    }

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    @Override
    public int insertPmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand) {
        pmsCategoryBrand.setCreateTime(DateUtils.getNowDate());
        return pmsCategoryBrandMapper.insertPmsCategoryBrand(pmsCategoryBrand);
    }

    /**
     * 修改分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    @Override
    public int updatePmsCategoryBrand(PmsCategoryBrand pmsCategoryBrand) {
        pmsCategoryBrand.setUpdateTime(DateUtils.getNowDate());
        return pmsCategoryBrandMapper.updatePmsCategoryBrand(pmsCategoryBrand);
    }

    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的分类&品牌关联主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryBrandByIds(Long[] ids) {
        return pmsCategoryBrandMapper.deletePmsCategoryBrandByIds(ids);
    }

    /**
     * 删除分类&品牌关联信息
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryBrandById(Long id) {
        return pmsCategoryBrandMapper.deletePmsCategoryBrandById(id);
    }


    @Override
    public List<PmsCategoryBrand> selectPmsCategoryBrandByBrandId(Long brandId) {
        return pmsCategoryBrandMapper.selectPmsCategoryBrandByBrandId(brandId);
    }
}
