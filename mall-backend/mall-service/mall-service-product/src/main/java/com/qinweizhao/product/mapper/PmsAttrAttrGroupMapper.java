package com.qinweizhao.product.mapper;

import com.qinweizhao.product.domain.PmsAttrAttrGroup;

import java.util.List;

/**
 * 属性&属性分组关联Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsAttrAttrGroupMapper {
    /**
     * 查询属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 属性&属性分组关联
     */
    PmsAttrAttrGroup selectPmsAttrAttrGroupById(Long id);

    /**
     * 查询属性&属性分组关联列表
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 属性&属性分组关联集合
     */
    List<PmsAttrAttrGroup> selectPmsAttrAttrGroupList(PmsAttrAttrGroup pmsAttrAttrGroup);

    /**
     * 新增属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    int insertPmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup);

    /**
     * 修改属性&属性分组关联
     *
     * @param pmsAttrAttrGroup 属性&属性分组关联
     * @return 结果
     */
    int updatePmsAttrAttrGroup(PmsAttrAttrGroup pmsAttrAttrGroup);

    /**
     * 删除属性&属性分组关联
     *
     * @param id 属性&属性分组关联主键
     * @return 结果
     */
    int deletePmsAttrAttrGroupById(Long id);

    /**
     * 批量删除属性&属性分组关联
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsAttrAttrGroupByIds(Long[] ids);
}
