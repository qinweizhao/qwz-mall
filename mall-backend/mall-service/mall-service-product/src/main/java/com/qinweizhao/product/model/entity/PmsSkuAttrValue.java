package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku销售属性&值对象 pms_sku_attr_value
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PmsSkuAttrValue extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * sku_id
     */
    @Excel(name = "sku_id")
    private Long skuId;

    /**
     * attr_id
     */
    @Excel(name = "attr_id")
    private Long attrId;

    /**
     * 销售属性名
     */
    @Excel(name = "销售属性名")
    private String name;

    /**
     * 销售属性值
     */
    @Excel(name = "销售属性值")
    private String value;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long sort;

}
