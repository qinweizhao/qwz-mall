package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 会员收藏的专题活动对象 ums_member_collect_subject
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public class UmsMemberCollectSubject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * subject_id
     */
    @Excel(name = "subject_id")
    private Long subjectId;

    /**
     * subject_name
     */
    @Excel(name = "subject_name")
    private String subjectName;

    /**
     * subject_img
     */
    @Excel(name = "subject_img")
    private String subjectImg;

    /**
     * 活动url
     */
    @Excel(name = "活动url")
    private String subjectUrll;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectImg(String subjectImg) {
        this.subjectImg = subjectImg;
    }

    public String getSubjectImg() {
        return subjectImg;
    }

    public void setSubjectUrll(String subjectUrll) {
        this.subjectUrll = subjectUrll;
    }

    public String getSubjectUrll() {
        return subjectUrll;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("subjectId", getSubjectId())
                .append("subjectName", getSubjectName())
                .append("subjectImg", getSubjectImg())
                .append("subjectUrll", getSubjectUrll())
                .toString();
    }
}
