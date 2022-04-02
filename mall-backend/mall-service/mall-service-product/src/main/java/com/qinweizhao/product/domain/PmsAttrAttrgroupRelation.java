package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 属性&属性分组关联对象 pms_attr_attrgroup_relation
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public class PmsAttrAttrgroupRelation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 属性id
     */
    @Excel(name = "属性id")
    private Long attrId;

    /**
     * 属性分组id
     */
    @Excel(name = "属性分组id")
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    @Excel(name = "属性组内排序")
    private Long attrSort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrGroupId() {
        return attrGroupId;
    }

    public void setAttrGroupId(Long attrGroupId) {
        this.attrGroupId = attrGroupId;
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
                .append("attrId" , getAttrId())
                .append("attrGroupId" , getAttrGroupId())
                .append("attrSort" , getAttrSort())
                .toString();
    }
}
