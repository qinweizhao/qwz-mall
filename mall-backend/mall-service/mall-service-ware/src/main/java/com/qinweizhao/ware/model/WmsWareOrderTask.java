package com.qinweizhao.ware.model;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存工作单对象 wms_ware_order_task
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WmsWareOrderTask extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * order_id
     */
    private Long orderId;

    /**
     * order_sn
     */
    private String orderSn;

    /**
     * 收货人
     */
    private String consignee;

    /**
     * 收货人电话
     */
    private String consigneeTel;

    /**
     * 配送地址
     */
    private String deliveryAddress;

    /**
     * 订单备注
     */
    private String orderComment;

    /**
     * 付款方式【 1:在线付款 2:货到付款】
     */
    private Integer paymentWay;

    /**
     * 任务状态
     */
    private Long taskStatus;

    /**
     * 订单描述
     */
    private String orderBody;

    /**
     * 物流单号
     */
    private String trackingNo;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 工作单备注
     */
    private String taskComment;

}
