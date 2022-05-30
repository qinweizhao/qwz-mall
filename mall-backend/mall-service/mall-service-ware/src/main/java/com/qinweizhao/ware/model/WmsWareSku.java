package com.qinweizhao.ware.model;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 商品库存对象 wms_ware_sku
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class WmsWareSku extends BaseEntity {
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
     * 仓库id
     */
    private Long wareId;

    /**
     * 库存数
     */
    private Long stock;

    /**
     * sku_name
     */
    private String skuName;

    /**
     * 锁定库存
     */
    private Long stockLocked;

}
