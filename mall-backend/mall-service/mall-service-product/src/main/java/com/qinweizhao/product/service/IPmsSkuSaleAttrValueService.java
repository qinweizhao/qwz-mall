package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.PmsSkuSaleAttrValue;

import java.util.List;

/**
 * sku销售属性&值Service接口
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public interface IPmsSkuSaleAttrValueService {
    /**
     * 查询sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    public PmsSkuSaleAttrValue selectPmsSkuSaleAttrValueById(Long id);

    /**
     * 查询sku销售属性&值列表
     *
     * @param pmsSkuSaleAttrValue sku销售属性&值
     * @return sku销售属性&值集合
     */
    public List<PmsSkuSaleAttrValue> selectPmsSkuSaleAttrValueList(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /**
     * 新增sku销售属性&值
     *
     * @param pmsSkuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    public int insertPmsSkuSaleAttrValue(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /**
     * 修改sku销售属性&值
     *
     * @param pmsSkuSaleAttrValue sku销售属性&值
     * @return 结果
     */
    public int updatePmsSkuSaleAttrValue(PmsSkuSaleAttrValue pmsSkuSaleAttrValue);

    /**
     * 批量删除sku销售属性&值
     *
     * @param ids 需要删除的sku销售属性&值主键集合
     * @return 结果
     */
    public int deletePmsSkuSaleAttrValueByIds(Long[] ids);

    /**
     * 删除sku销售属性&值信息
     *
     * @param id sku销售属性&值主键
     * @return 结果
     */
    public int deletePmsSkuSaleAttrValueById(Long id);
}
