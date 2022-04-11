package com.qinweizhao.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * 品牌对象 pms_brand
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public class PmsBrand extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 品牌id */
    private Long brandId;

    /** 品牌名 */
    @Excel(name = "品牌名")
    private String name;

    /** 品牌logo地址 */
    @Excel(name = "品牌logo地址")
    private String logo;

    /** 介绍 */
    @Excel(name = "介绍")
    private String desc;

    /** 显示状态[0-不显示；1-显示] */
    @Excel(name = "显示状态[0-不显示；1-显示]")
    private Long status;

    /**
     * 检索首字母
     */
    @Excel(name = "检索首字母")
    private String firstLetter;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLogo() {
        return logo;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter;
    }

    public String getFirstLetter() {
        return firstLetter;
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
                .append("brandId", getBrandId())
                .append("name", getName())
                .append("logo", getLogo())
                .append("desc", getDesc())
                .append("status", getStatus())
                .append("firstLetter", getFirstLetter())
                .append("sort", getSort())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
