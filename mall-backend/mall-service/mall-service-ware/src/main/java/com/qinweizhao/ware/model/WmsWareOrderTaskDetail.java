package com.qinweizhao.ware.model;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 库存工作单详情对象 wms_ware_order_task_detail
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WmsWareOrderTaskDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * sku_name
     */
    private String skuName;

    /**
     * 购买个数
     */
    private Long skuNum;

    /**
     * 工作单id
     */
    private Long taskId;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 1-已锁定  2-已解锁  3-扣减
     */
    private Long lockStatus;

}
