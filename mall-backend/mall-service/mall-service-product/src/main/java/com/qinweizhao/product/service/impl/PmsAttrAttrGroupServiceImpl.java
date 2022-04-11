package com.qinweizhao.product.service.impl;

import java.util.List;
import com.qinweizhao.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qinweizhao.product.mapper.PmsAttrAttrGroupMapper;
import com.qinweizhao.product.domain.PmsAttrAttrGroup;
import com.qinweizhao.product.service.IPmsAttrAttrGroupService;

/**
 * 属性&属性分组关联Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsAttrAttrGroupServiceImpl implements IPmsAttrAttrGroupService {
    @Autowired
    private PmsAttrAttrGroupMapper pmsAttrAttrGroupMapper;

    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    @Override
    public PmsAttrAttrGroup selectPmsAttrAttrGroupById(Long id) {
        return pmsAttrAttrGroupMapper.selectPmsAttrAttrGroupById(id);
    }

    /**
     * 查询属性&属性分组关联列表
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 属性&属性分组关联
     */
    @Override
    public List<PmsAttrAttrGroup> selectPmsAttrAttrGroupList(PmsAttrAttrGroup pmsAttrAttrGroup) {
        return pmsAttrAttrGroupMapper.selectPmsAttrAttrGroupList(pmsAttrAttrGroup);
    }

    /**
     * 新增属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int insertPmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup) {
        pmsAttrAttrGroup.setCreateTime(DateUtils.getNowDate());
        return pmsAttrAttrGroupMapper.insertPmsAttrAttrGroup(pmsAttrAttrGroup);
    }

    /**
     * 修改属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    @Override
    public int updatePmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup) {
        pmsAttrAttrGroup.setUpdateTime(DateUtils.getNowDate());
        return pmsAttrAttrGroupMapper.updatePmsAttrAttrGroup(pmsAttrAttrGroup);
    }

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrAttrGroupByIds(Long[] ids) {
        return pmsAttrAttrGroupMapper.deletePmsAttrAttrGroupByIds(ids);
    }

    /**
     * 删除属性&属性分组关联信息
     *
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrAttrGroupById(Long id) {
        return pmsAttrAttrGroupMapper.deletePmsAttrAttrGroupById(id);
    }
}
