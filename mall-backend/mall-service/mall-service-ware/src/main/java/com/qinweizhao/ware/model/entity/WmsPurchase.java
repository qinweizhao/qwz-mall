package com.qinweizhao.ware.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * 采购单对象 wms_purchase
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WmsPurchase extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 采购单id
     */
    private Long id;

    /**
     * 采购人id
     */
    private Long assigneeId;

    /**
     * 采购人名
     */
    private String assigneeName;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 优先级
     */
    private Long priority;

    /**
     * 状态
     */
    private Long status;

    /**
     * 仓库id
     */
    private Long wareId;

    /**
     * 总金额
     */
    private BigDecimal amount;

}
