package com.qinweizhao.product.mapper;

import java.util.List;

import com.qinweizhao.product.domain.PmsSkuAttrValue;

/**
 * sku销售属性&值Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSkuAttrValueMapper {
    /**
     * 查询sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    public PmsSkuAttrValue selectPmsSkuAttrValueById(Long id);

    /**
     * 查询sku销售属性&值列表
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return sku销售属性&值集合
     */
    public List<PmsSkuAttrValue> selectPmsSkuAttrValueList(PmsSkuAttrValue pmsSkuAttrValue);

    /**
     * 新增sku销售属性&值
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return 结果
     */
    public int insertPmsSkuAttrValue(PmsSkuAttrValue pmsSkuAttrValue);

    /**
     * 修改sku销售属性&值
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return 结果
     */
    public int updatePmsSkuAttrValue(PmsSkuAttrValue pmsSkuAttrValue);

    /**
     * 删除sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return 结果
     */
    public int deletePmsSkuAttrValueById(Long id);

    /**
     * 批量删除sku销售属性&值
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePmsSkuAttrValueByIds(Long[] ids);
}
