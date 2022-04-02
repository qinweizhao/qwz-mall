package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品三级分类对象 pms_category
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public class PmsCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    private Long catId;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String name;

    /**
     * 父分类id
     */
    @Excel(name = "父分类id")
    private Long parentCid;

    /**
     * 层级
     */
    @Excel(name = "层级")
    private Long catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    @Excel(name = "是否显示[0-不显示，1显示]")
    private Long showStatus;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 图标地址
     */
    @Excel(name = "图标地址")
    private String icon;

    /**
     * 计量单位
     */
    @Excel(name = "计量单位")
    private String productUnit;

    /**
     * 商品数量
     */
    @Excel(name = "商品数量")
    private Long productCount;

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentCid() {
        return parentCid;
    }

    public void setParentCid(Long parentCid) {
        this.parentCid = parentCid;
    }

    public Long getCatLevel() {
        return catLevel;
    }

    public void setCatLevel(Long catLevel) {
        this.catLevel = catLevel;
    }

    public Long getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Long showStatus) {
        this.showStatus = showStatus;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public Long getProductCount() {
        return productCount;
    }

    public void setProductCount(Long productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("catId" , getCatId())
                .append("name" , getName())
                .append("parentCid" , getParentCid())
                .append("catLevel" , getCatLevel())
                .append("showStatus" , getShowStatus())
                .append("sort" , getSort())
                .append("icon" , getIcon())
                .append("productUnit" , getProductUnit())
                .append("productCount" , getProductCount())
                .toString();
    }
}
