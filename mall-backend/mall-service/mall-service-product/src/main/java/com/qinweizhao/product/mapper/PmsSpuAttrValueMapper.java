package com.qinweizhao.product.mapper;

import java.util.List;

import com.qinweizhao.product.domain.PmsSpuAttrValue;

/**
 * spu属性值Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSpuAttrValueMapper {
    /**
     * 查询spu属性值
     *
     * @param id spu属性值主键
     * @return spu属性值
     */
    public PmsSpuAttrValue selectPmsSpuAttrValueById(Long id);

    /**
     * 查询spu属性值列表
     *
     * @param pmsSpuAttrValue spu属性值
     * @return spu属性值集合
     */
    public List<PmsSpuAttrValue> selectPmsSpuAttrValueList(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 新增spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    public int insertPmsSpuAttrValue(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 修改spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    public int updatePmsSpuAttrValue(PmsSpuAttrValue pmsSpuAttrValue);

    /**
     * 删除spu属性值
     *
     * @param id spu属性值主键
     * @return 结果
     */
    public int deletePmsSpuAttrValueById(Long id);

    /**
     * 批量删除spu属性值
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSpuAttrValueByIds(Long[] ids);
}
