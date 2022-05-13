package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * spu图片对象 pms_spu_image
 *
 * @author qinweizhao
 * @date 2022-05-03
 */
public class PmsSpuImage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** spu_id */
    @Excel(name = "spu_id")
    private Long spuId;

    /** 图片名 */
    @Excel(name = "图片名")
    private String name;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String url;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long sort;

    /** 是否默认图 */
    @Excel(name = "是否默认图")
    private Long defaultImage;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public void setDefaultImage(Long defaultImage) {
        this.defaultImage = defaultImage;
    }

    public Long getDefaultImage() {
        return defaultImage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("spuId", getSpuId())
                .append("name", getName())
                .append("url", getUrl())
                .append("sort", getSort())
                .append("defaultImage", getDefaultImage())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
