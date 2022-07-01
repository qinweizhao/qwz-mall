package com.qinweizhao.order.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 退货原因对象 oms_order_return_reason
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oms_order_return_reason")
public class OmsOrderReturnReason extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 退货原因名
     */
    @Excel(name = "退货原因名")
    private String name;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 启用状态
     */
    @Excel(name = "启用状态")
    private Integer status;

}
