package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
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
@TableName("ums_growth_change_history")
public class UmsGrowthChangeHistory extends BaseEntity {

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
     * 改变的值（正负计数）
     */
    private Long changeCount;


    /**
     * 积分来源[0-购物，1-管理员修改]
     */
    private Long sourceType;

}
