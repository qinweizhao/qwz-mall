package com.qinweizhao.ware.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 采购单详情对象 wms_purchase_detail
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WmsPurchaseDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * 采购单id
     */
    private Long purchaseId;

    /**
     * 采购商品id
     */
    private Long skuId;

    /**
     * 采购数量
     */
    private Long skuNum;

    /**
     * 采购金额
     */
    private BigDecimal skuPrice;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
     */
    private Long status;

}
