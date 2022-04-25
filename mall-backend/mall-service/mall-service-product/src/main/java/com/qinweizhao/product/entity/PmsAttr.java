package com.qinweizhao.product.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品属性对象 pms_attr
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
public class PmsAttr extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性名
     */
    @Excel(name = "属性名")
    private String name;

    /**
     * 属性图标
     */
    @Excel(name = "属性图标")
    private String icon;

    /**
     * 可选值列表[用逗号分隔]
     */
    @Excel(name = "可选值列表[用逗号分隔]")
    private String valueSelect;

    /**
     * 值类型[0-单值，1-多值]
     */
    @Excel(name = "值类型[0-单值，1-多值]")
    private Long valueType;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    @Excel(name = "是否需要检索[0-不需要，1-需要]")
    private Long searchType;

    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    @Excel(name = "属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]")
    private Long type;

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    @Excel(name = "启用状态[0 - 禁用，1 - 启用]")
    private Long status;

    /**
     * 所属分类
     */
    @Excel(name = "所属分类")
    private Long categoryId;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    @Excel(name = "快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整")
    private Long quickShow;

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

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setValueSelect(String valueSelect) {
        this.valueSelect = valueSelect;
    }

    public String getValueSelect() {
        return valueSelect;
    }

    public void setValueType(Long valueType) {
        this.valueType = valueType;
    }

    public Long getValueType() {
        return valueType;
    }

    public void setSearchType(Long searchType) {
        this.searchType = searchType;
    }

    public Long getSearchType() {
        return searchType;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getType() {
        return type;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setQuickShow(Long quickShow) {
        this.quickShow = quickShow;
    }

    public Long getQuickShow() {
        return quickShow;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("attrId", getAttrId())
                .append("name", getName())
                .append("icon", getIcon())
                .append("valueSelect", getValueSelect())
                .append("valueType", getValueType())
                .append("searchType", getSearchType())
                .append("type", getType())
                .append("status", getStatus())
                .append("categoryId", getCategoryId())
                .append("quickShow", getQuickShow())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
