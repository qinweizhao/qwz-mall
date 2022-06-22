package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
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
@TableName("ums_integration_change_history")
public class UmsIntegrationChangeHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * member_id
     */
    private Long memberId;

    /**
     * 变化的值
     */
    private Long changeCount;


    /**
     * 来源[0->购物；1->管理员修改;2->活动]
     */
    private Long sourceType;

}
