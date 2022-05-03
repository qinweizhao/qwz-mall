package com.qinweizhao.product.service;

import com.qinweizhao.product.entity.PmsAttr;
import com.qinweizhao.product.entity.vo.PmsAttrVO;

import java.util.List;


/**
 * 商品属性Service接口
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
public interface IPmsAttrService {
    /**
     * 查询商品属性
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    PmsAttr getById(Long attrId);

    /**
     * 查询商品属性列表
     *
     * @param pmsAttr 商品属性
     * @return 商品属性集合
     */
    List<PmsAttr> list(PmsAttr pmsAttr);

    /**
     * 新增商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    int save(PmsAttrVO pmsAttr);

    /**
     * 修改商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    int updateById(PmsAttrVO pmsAttr);

    /**
     * 批量删除商品属性
     *
     * @param attrIds 需要删除的商品属性主键集合
     * @return 结果
     */
    int removeByIds(Long[] attrIds);

    /**
     * 删除商品属性信息
     *
     * @param attrId 商品属性主键
     * @return 结果
     */
    int deletePmsAttrByAttrId(Long attrId);

    // todo
    List<PmsAttr> getRelationAttr(Long attrGroupId);
}
