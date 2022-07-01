package com.qinweizhao.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 订单操作历史记录对象 oms_order_operate_history
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_operate_history")
public class OmsOrderOperateHistory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 订单id
     */
    @Excel(name = "订单id")
    private Long orderId;

    /**
     * 订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
     */
    @Excel(name = "订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】")
    private Long orderStatus;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

}
