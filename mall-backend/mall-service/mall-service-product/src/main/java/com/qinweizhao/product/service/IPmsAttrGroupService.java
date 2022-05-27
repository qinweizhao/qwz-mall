package com.qinweizhao.product.service;

import com.qinweizhao.product.model.dto.SpuItemAttrGroupDTO;
import com.qinweizhao.product.model.entity.PmsAttrGroup;
import com.qinweizhao.product.model.vo.AttrGroupWithPmsAttrsVO;

import java.util.List;

/**
 * 属性分组Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsAttrGroupService {
    /**
     * 查询属性分组
     *
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    PmsAttrGroup getById(Long attrGroupId);

    /**
     * 查询属性分组列表
     *
     * @param pmsAttrGroup 属性分组
     * @return 属性分组集合
     */
    List<PmsAttrGroup> list(PmsAttrGroup pmsAttrGroup);

    /**
     * 新增属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    int save(PmsAttrGroup pmsAttrGroup);

    /**
     * 修改属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    int updateById(PmsAttrGroup pmsAttrGroup);

    /**
     * 批量删除属性分组
     *
     * @param attrGroupIds 需要删除的属性分组主键集合
     * @return 结果
     */
    int removeByIds(Long[] attrGroupIds);

    /**
     * 删除属性分组信息
     *
     * @param attrGroupId 属性分组主键
     * @return 结果
     */
    int removeById(Long attrGroupId);


    /**
     * 查询分组属性和属性(不包含属性值)
     * 此方法用于发布商品时填写 spu attr 时使用
     * @param categoryId categoryId
     * @return 结果
     */
    List<AttrGroupWithPmsAttrsVO> listAttrGroupWithAttrsByCategoryId(Long categoryId);

    /**
     * 查询分组属性和属性(包含属性值)
     * 此方法用于发布商品时填写 spu attr 时使用
     * @param categoryId categoryId
     * @param spuId spuId
     * @return 结果
     */
    List<SpuItemAttrGroupDTO> listAttrGroupWithAttrsByCategoryId(Long categoryId, Long spuId);
}
