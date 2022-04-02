package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.PmsCategoryBrandRelation;
import com.qinweizhao.product.mapper.PmsCategoryBrandRelationMapper;
import com.qinweizhao.product.service.IPmsCategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类&品牌关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@Service
public class PmsCategoryBrandRelationServiceImpl implements IPmsCategoryBrandRelationService {
    @Autowired
    private PmsCategoryBrandRelationMapper pmsCategoryBrandRelationMapper;

    /**
     * 查询分类&品牌关联
     *
     * @param id 分类&品牌关联主键
     * @return 分类&品牌关联
     */
    @Override
    public PmsCategoryBrandRelation selectPmsCategoryBrandRelationById(Long id) {
        return pmsCategoryBrandRelationMapper.selectPmsCategoryBrandRelationById(id);
    }

    /**
     * 查询分类&品牌关联列表
     *
     * @param pmsCategoryBrandRelation 分类&品牌关联
     * @return 分类&品牌关联
     */
    @Override
    public List<PmsCategoryBrandRelation> selectPmsCategoryBrandRelationList(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        return pmsCategoryBrandRelationMapper.selectPmsCategoryBrandRelationList(pmsCategoryBrandRelation);
    }

    /**
     * 新增分类&品牌关联
     *
     * @param pmsCategoryBrandRelation 分类&品牌关联
     * @return 结果
     */
    @Override
    public int insertPmsCategoryBrandRelation(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        return pmsCategoryBrandRelationMapper.insertPmsCategoryBrandRelation(pmsCategoryBrandRelation);
    }

    /**
     * 修改分类&品牌关联
     *
     * @param pmsCategoryBrandRelation 分类&品牌关联
     * @return 结果
     */
    @Override
    public int updatePmsCategoryBrandRelation(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
        return pmsCategoryBrandRelationMapper.updatePmsCategoryBrandRelation(pmsCategoryBrandRelation);
    }

    /**
     * 批量删除分类&品牌关联
     *
     * @param ids 需要删除的分类&品牌关联主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryBrandRelationByIds(Long[] ids) {
        return pmsCategoryBrandRelationMapper.deletePmsCategoryBrandRelationByIds(ids);
    }

    /**
     * 删除分类&品牌关联信息
     *
     * @param id 分类&品牌关联主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryBrandRelationById(Long id) {
        return pmsCategoryBrandRelationMapper.deletePmsCategoryBrandRelationById(id);
    }
}
