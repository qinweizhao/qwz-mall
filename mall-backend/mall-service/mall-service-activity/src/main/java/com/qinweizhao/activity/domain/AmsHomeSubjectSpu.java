package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 专题商品对象 ams_home_subject_spu
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public class AmsHomeSubjectSpu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 专题名字
     */
    @Excel(name = "专题名字")
    private String name;

    /**
     * 专题id
     */
    @Excel(name = "专题id")
    private Long subjectId;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("subjectId", getSubjectId())
                .append("spuId", getSpuId())
                .append("sort", getSort())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
