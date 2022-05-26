package com.qinweizhao.user.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 积分变化历史记录对象 ums_integration_change_history
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
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
     * 来源[0->购物；1->管理员修改;2->活动]
     */
    @Excel(name = "来源[0->购物；1->管理员修改;2->活动]")
    private Long sourceType;

}
