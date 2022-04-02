package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * sku销售属性&值对象 pms_sku_sale_attr_value
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public class PmsSkuSaleAttrValue extends BaseEntity {
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
    private String attrName;

    /**
     * 销售属性值
     */
    @Excel(name = "销售属性值")
    private String attrValue;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long attrSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue;
    }

    public Long getAttrSort() {
        return attrSort;
    }

    public void setAttrSort(Long attrSort) {
        this.attrSort = attrSort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("skuId" , getSkuId())
                .append("attrId" , getAttrId())
                .append("attrName" , getAttrName())
                .append("attrValue" , getAttrValue())
                .append("attrSort" , getAttrSort())
                .toString();
    }
}
