package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 会员等级对象 ums_member_level
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public class UmsMemberLevel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 等级名称
     */
    @Excel(name = "等级名称")
    private String name;

    /**
     * 等级需要的成长值
     */
    @Excel(name = "等级需要的成长值")
    private Long growthPoint;

    /**
     * 是否为默认等级[0->不是；1->是]
     */
    @Excel(name = "是否为默认等级[0->不是；1->是]")
    private Long defaultStatus;

    /**
     * 免运费标准
     */
    @Excel(name = "免运费标准")
    private BigDecimal freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    @Excel(name = "每次评价获取的成长值")
    private Long commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    @Excel(name = "是否有免邮特权")
    private Long priviledgeFreeFreight;

    /**
     * 是否有会员价格特权
     */
    @Excel(name = "是否有会员价格特权")
    private Long priviledgeMemberPrice;

    /**
     * 是否有生日特权
     */
    @Excel(name = "是否有生日特权")
    private Long priviledgeBirthday;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGrowthPoint(Long growthPoint) {
        this.growthPoint = growthPoint;
    }

    public Long getGrowthPoint() {
        return growthPoint;
    }

    public void setDefaultStatus(Long defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Long getDefaultStatus() {
        return defaultStatus;
    }

    public void setFreeFreightPoint(BigDecimal freeFreightPoint) {
        this.freeFreightPoint = freeFreightPoint;
    }

    public BigDecimal getFreeFreightPoint() {
        return freeFreightPoint;
    }

    public void setCommentGrowthPoint(Long commentGrowthPoint) {
        this.commentGrowthPoint = commentGrowthPoint;
    }

    public Long getCommentGrowthPoint() {
        return commentGrowthPoint;
    }

    public void setPriviledgeFreeFreight(Long priviledgeFreeFreight) {
        this.priviledgeFreeFreight = priviledgeFreeFreight;
    }

    public Long getPriviledgeFreeFreight() {
        return priviledgeFreeFreight;
    }

    public void setPriviledgeMemberPrice(Long priviledgeMemberPrice) {
        this.priviledgeMemberPrice = priviledgeMemberPrice;
    }

    public Long getPriviledgeMemberPrice() {
        return priviledgeMemberPrice;
    }

    public void setPriviledgeBirthday(Long priviledgeBirthday) {
        this.priviledgeBirthday = priviledgeBirthday;
    }

    public Long getPriviledgeBirthday() {
        return priviledgeBirthday;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("growthPoint", getGrowthPoint())
                .append("defaultStatus", getDefaultStatus())
                .append("freeFreightPoint", getFreeFreightPoint())
                .append("commentGrowthPoint", getCommentGrowthPoint())
                .append("priviledgeFreeFreight", getPriviledgeFreeFreight())
                .append("priviledgeMemberPrice", getPriviledgeMemberPrice())
                .append("priviledgeBirthday", getPriviledgeBirthday())
                .append("note", getNote())
                .toString();
    }
}
