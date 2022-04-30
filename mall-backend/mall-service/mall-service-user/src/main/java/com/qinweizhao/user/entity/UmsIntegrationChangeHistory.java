package com.qinweizhao.user.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 积分变化历史记录对象 ums_integration_change_history
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public class UmsIntegrationChangeHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * member_id
     */
    @Excel(name = "member_id")
    private Long memberId;

    /**
     * 变化的值
     */
    @Excel(name = "变化的值")
    private Long changeCount;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    /**
     * 来源[0->购物；1->管理员修改;2->活动]
     */
    @Excel(name = "来源[0->购物；1->管理员修改;2->活动]")
    private Long sourceTyoe;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setChangeCount(Long changeCount) {
        this.changeCount = changeCount;
    }

    public Long getChangeCount() {
        return changeCount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setSourceTyoe(Long sourceTyoe) {
        this.sourceTyoe = sourceTyoe;
    }

    public Long getSourceTyoe() {
        return sourceTyoe;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("memberId", getMemberId())
                .append("createTime", getCreateTime())
                .append("changeCount", getChangeCount())
                .append("note", getNote())
                .append("sourceTyoe", getSourceTyoe())
                .toString();
    }
}
