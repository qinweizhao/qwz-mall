package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.mapper.PmsCategoryBrandMapper;
import com.qinweizhao.product.model.entity.PmsCategoryBrand;
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
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 分类&品牌关联
     */
    @Override
    public List<PmsCategoryBrand> list(PmsCategoryBrand pmsCategoryBrand) {
        return pmsCategoryBrandMapper.selectList(pmsCategoryBrand);
    }

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrand 分类&品牌关联
     * @return 结果
     */
    @Override
    public int save(PmsCategoryBrand pmsCategoryBrand) {
        return pmsCategoryBrandMapper.insert(pmsCategoryBrand);
    }


    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的分类&品牌关联主键
     * @return 结果
     */
    @Override
    public int removeByIds(Long[] ids) {
        return pmsCategoryBrandMapper.deleteByIds(ids);
    }

    /**
     * 删除分类&品牌关联信息
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    @Override
    public int removeById(Long id) {
        return pmsCategoryBrandMapper.deleteById(id);
    }

}
