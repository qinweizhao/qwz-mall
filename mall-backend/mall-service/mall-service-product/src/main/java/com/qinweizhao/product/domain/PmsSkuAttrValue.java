package com.qinweizhao.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * sku销售属性&值对象 pms_sku_attr_value
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public class PmsSkuAttrValue extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** sku_id */
    @Excel(name = "sku_id")
    private Long skuId;

    /** attr_id */
    @Excel(name = "attr_id")
    private Long attrId;

    /** 销售属性名 */
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("skuId", getSkuId())
                .append("attrId", getAttrId())
                .append("name", getName())
                .append("value", getValue())
                .append("sort", getSort())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
