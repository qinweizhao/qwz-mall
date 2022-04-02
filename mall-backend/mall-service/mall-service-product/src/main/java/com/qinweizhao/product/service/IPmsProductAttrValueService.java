package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsProductAttrValue;

import java.util.List;

/**
 * spu属性值Service接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface IPmsProductAttrValueService {
    /**
     * 查询spu属性值
     *
     * @param id spu属性值主键
     * @return spu属性值
     */
    public PmsProductAttrValue selectPmsProductAttrValueById(Long id);

    /**
     * 查询spu属性值列表
     *
     * @param pmsProductAttrValue spu属性值
     * @return spu属性值集合
     */
    public List<PmsProductAttrValue> selectPmsProductAttrValueList(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 新增spu属性值
     *
     * @param pmsProductAttrValue spu属性值
     * @return 结果
     */
    public int insertPmsProductAttrValue(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 修改spu属性值
     *
     * @param pmsProductAttrValue spu属性值
     * @return 结果
     */
    public int updatePmsProductAttrValue(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 批量删除spu属性值
     *
     * @param ids 需要删除的spu属性值主键集合
     * @return 结果
     */
    public int deletePmsProductAttrValueByIds(Long[] ids);

    /**
     * 删除spu属性值信息
     *
     * @param id spu属性值主键
     * @return 结果
     */
    public int deletePmsProductAttrValueById(Long id);
}
