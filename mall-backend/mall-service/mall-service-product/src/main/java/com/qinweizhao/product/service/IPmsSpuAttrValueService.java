package com.qinweizhao.product.service;

import com.qinweizhao.product.entity.PmsSpuAttrValue;

import java.util.List;

/**
 * spu属性值Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSpuAttrValueService {
    /**
     * 查询spu属性值
     *
     * @param id spu属性值主键
     * @return spu属性值
     */
    PmsSpuAttrValue getById(Long id);

    /**
     * 查询spu属性值列表
     *
     * @param pmsSpuAttrValue spu属性值
     * @return spu属性值集合
     */
    List<PmsSpuAttrValue> list(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 新增spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    int save(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 修改spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    int updateById(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 批量删除spu属性值
     *
     * @param ids 需要删除的spu属性值主键集合
     * @return 结果
     */
    int removeByIds(Long[] ids);

    /**
     * 删除spu属性值信息
     *
     * @param id spu属性值主键
     * @return 结果
     */
    int deletePmsSpuAttrValueById(Long id);
}
