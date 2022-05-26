package com.qinweizhao.user.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 成长值变化历史记录对象 ums_growth_change_history
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UmsGrowthChangeHistory extends BaseEntity {
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
     * 改变的值（正负计数）
     */
    @Excel(name = "改变的值", readConverterExp = "正=负计数")
    private Long changeCount;


    /**
     * 积分来源[0-购物，1-管理员修改]
     */
    @Excel(name = "积分来源[0-购物，1-管理员修改]")
    private Long sourceType;

}
