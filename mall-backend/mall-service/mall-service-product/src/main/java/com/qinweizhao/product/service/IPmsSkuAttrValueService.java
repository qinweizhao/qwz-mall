package com.qinweizhao.product.service;

import java.util.List;

import com.qinweizhao.product.domain.PmsSkuAttrValue;

/**
 * sku销售属性&值Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface IPmsSkuAttrValueService {
    /**
     * 查询sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    PmsSkuAttrValue selectPmsSkuAttrValueById(Long id);

    /**
     * 查询sku销售属性&值列表
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return sku销售属性&值集合
     */
    List<PmsSkuAttrValue> selectPmsSkuAttrValueList(PmsSkuAttrValue pmsSkuAttrValue);

    /**
     * 新增sku销售属性&值
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return 结果
     */
    int insertPmsSkuAttrValue(PmsSkuAttrValue pmsSkuAttrValue);

    /**
     * 修改sku销售属性&值
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return 结果
     */
    int updatePmsSkuAttrValue(PmsSkuAttrValue pmsSkuAttrValue);

    /**
     * 批量删除sku销售属性&值
     *
     * @param ids 需要删除的sku销售属性&值主键集合
     * @return 结果
     */
    int deletePmsSkuAttrValueByIds(Long[] ids);

    /**
     * 删除sku销售属性&值信息
     *
     * @param id sku销售属性&值主键
     * @return 结果
     */
    int deletePmsSkuAttrValueById(Long id);
}
