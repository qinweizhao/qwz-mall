package com.qinweizhao.product.mapper;

import com.qinweizhao.product.entity.PmsAttr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品属性Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
public interface PmsAttrMapper {
    /**
     * 查询商品属性
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    PmsAttr selectPmsAttrByAttrId(Long attrId);

    /**
     * 查询商品属性列表
     *
     * @param pmsAttr 商品属性
     * @return 商品属性集合
     */
    List<PmsAttr> selectPmsAttrList(PmsAttr pmsAttr);

    /**
     * 新增商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    int insertPmsAttr(PmsAttr pmsAttr);

    /**
     * 修改商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    int updatePmsAttr(PmsAttr pmsAttr);

    /**
     * 删除商品属性
     *
     * @param attrId 商品属性主键
     * @return 结果
     */
    int deletePmsAttrByAttrId(Long attrId);

    /**
     * 批量删除商品属性
     *
     * @param attrIds 需要删除的数据主键集合
     * @return 结果
     */
    int deletePmsAttrByAttrIds(Long[] attrIds);

    /**
     * 批量查询属性
     *
     * @param ids ids
     * @return 结果
     */
    List<Long> selectIdsByAttrGroupIds(@Param("attrGroupIds") List<Long> ids);

    /**
     * 查询属性
     *
     * @param categoryId     categoryId
     * @param type           type
     * @param excludeAttrIds excludeAttrIds
     * @return 结果
     */
    List<PmsAttr> selectPmsAttrsByCategoryId(@Param("categoryId") Long categoryId, @Param("type") int type, @Param("excludeAttrIds") List<Long> excludeAttrIds);

    /**
     * 批量查询
     *
     * @param attrIds attrIds
     * @return 结果
     */
    List<PmsAttr> selectPmsAttrsByPmsAttrIds(List<Long> attrIds);
}
