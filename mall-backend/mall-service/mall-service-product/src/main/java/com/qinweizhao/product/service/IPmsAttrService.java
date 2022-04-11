package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsAttr;

/**
 * 商品属性Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsAttrService {
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
     * 批量删除商品属性
     *
     * @param attrIds 需要删除的商品属性主键集合
     * @return 结果
     */
    int deletePmsAttrByAttrIds(Long[] attrIds);

    /**
     * 删除商品属性信息
     *
     * @param attrId 商品属性主键
     * @return 结果
     */
    int deletePmsAttrByAttrId(Long attrId);
}
