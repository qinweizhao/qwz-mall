package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * spu属性值对象 pms_product_attr_value
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public class PmsProductAttrValue extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 商品id
     */
    @Excel(name = "商品id")
    private Long spuId;

    /**
     * 属性id
     */
    @Excel(name = "属性id")
    private Long attrId;

    /**
     * 属性名
     */
    @Excel(name = "属性名")
    private String attrName;

    /**
     * 属性值
     */
    @Excel(name = "属性值")
    private String attrValue;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long attrSort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @Excel(name = "快速展示【是否展示在介绍上；0-否 1-是】")
    private Long quickShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
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

    public Long getQuickShow() {
        return quickShow;
    }

    public void setQuickShow(Long quickShow) {
        this.quickShow = quickShow;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("spuId" , getSpuId())
                .append("attrId" , getAttrId())
                .append("attrName" , getAttrName())
                .append("attrValue" , getAttrValue())
                .append("attrSort" , getAttrSort())
                .append("quickShow" , getQuickShow())
                .toString();
    }
}
