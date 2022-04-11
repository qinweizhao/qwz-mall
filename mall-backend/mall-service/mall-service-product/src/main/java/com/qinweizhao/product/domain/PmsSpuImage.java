package com.qinweizhao.product.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;

/**
 * spu图片对象 pms_spu_image
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public class PmsSpuImage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * 图片名
     */
    @Excel(name = "图片名")
    private String name;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String url;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long sort;

    /** 是否默认图 */
    @Excel(name = "是否默认图")
    private Long default;

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
                .append("spuId", getSpuId())
                .append("name", getName())
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
