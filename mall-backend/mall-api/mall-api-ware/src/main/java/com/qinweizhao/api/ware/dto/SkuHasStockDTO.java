package com.qinweizhao.api.ware.dto;

import lombok.Data;

/**
 * @author weizhao
 */
@Data
public class SkuHasStockDTO {

    /**
     * sku id
     */
    private Long skuId;

    /**
     * 是否有库存
     */
    private Boolean hasStock;
}
