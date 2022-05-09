package com.qinweizhao.product.mapper;

import com.qinweizhao.product.entity.PmsAttrAttrGroup;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 批量选择关联属性
     *
     * @param pmsAttrAttrGroups pmsAttrAttrGroups
     * @return int
     */
    int insertPmsAttrAttrGroups(@Param("pmsAttrAttrGroups") List<PmsAttrAttrGroup> pmsAttrAttrGroups);

    /**
     * 统计关联个数
     * @param attrId attrId
     * @return int
     */
    int selectCountByAttrId(Long attrId);

    /**
     * 更新关联关系
     * @param attrGroupId attrGroupId
     * @param attrId attrId
     * @return int
     */
    int updateByAttrId(@Param("attrGroupId")Long attrGroupId,@Param("attrId")Long attrId);

    /**
     * 查询
     * @param attrId attrId
     * @return PmsAttrAttrGroup
     */
    PmsAttrAttrGroup selectByAttrId(Long attrId);
}
