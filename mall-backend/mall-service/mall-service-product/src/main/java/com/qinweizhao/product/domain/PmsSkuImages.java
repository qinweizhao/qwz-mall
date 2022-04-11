package com.qinweizhao.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * sku图片对象 pms_sku_images
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public class PmsSkuImages extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** sku_id */
    private Long skuId;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String url;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 默认图[0 - 不是默认图，1 - 是默认图] */
    @Excel(name = "默认图[0 - 不是默认图，1 - 是默认图]")
    private Long default;

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setDefault(Long default) {
        this.
        default =default
        ;
    }

    public Long getDefault() {
        return
        default
        ;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("skuId", getSkuId())
                .append("url", getUrl())
                .append("sort", getSort())
                .append("default", getDefault())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
