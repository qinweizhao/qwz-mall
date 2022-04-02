package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.PmsAttrAttrgroupRelation;
import com.qinweizhao.product.mapper.PmsAttrAttrgroupRelationMapper;
import com.qinweizhao.product.service.IPmsAttrAttrgroupRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 属性&属性分组关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@Service
public class PmsAttrAttrgroupRelationServiceImpl implements IPmsAttrAttrgroupRelationService {
    @Autowired
    private PmsAttrAttrgroupRelationMapper pmsAttrAttrgroupRelationMapper;

    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    @Override
    public PmsAttrAttrgroupRelation selectPmsAttrAttrgroupRelationById(Long id) {
        return pmsAttrAttrgroupRelationMapper.selectPmsAttrAttrgroupRelationById(id);
    }

    /**
     * 查询属性&属性分组关联列表
     *
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 属性&属性分组关联
     */
    @Override
    public List<PmsAttrAttrgroupRelation> selectPmsAttrAttrgroupRelationList(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return pmsAttrAttrgroupRelationMapper.selectPmsAttrAttrgroupRelationList(pmsAttrAttrgroupRelation);
    }

    /**
     * 新增属性&属性分组关联
     *
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int insertPmsAttrAttrgroupRelation(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return pmsAttrAttrgroupRelationMapper.insertPmsAttrAttrgroupRelation(pmsAttrAttrgroupRelation);
    }

    /**
     * 修改属性&属性分组关联
     *
     * @param pmsAttrAttrgroupRelation 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int updatePmsAttrAttrgroupRelation(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
        return pmsAttrAttrgroupRelationMapper.updatePmsAttrAttrgroupRelation(pmsAttrAttrgroupRelation);
    }

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrAttrgroupRelationByIds(Long[] ids) {
        return pmsAttrAttrgroupRelationMapper.deletePmsAttrAttrgroupRelationByIds(ids);
    }

    /**
     * 删除属性&属性分组关联信息
     *
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrAttrgroupRelationById(Long id) {
        return pmsAttrAttrgroupRelationMapper.deletePmsAttrAttrgroupRelationById(id);
    }
}
