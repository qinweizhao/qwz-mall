package com.qinweizhao.product.model.dto;

import com.qinweizhao.common.core.annotation.Excel;
import lombok.Data;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Data
public class SpuInfoDetailDTO {

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 商品介绍
     */
    @Excel(name = "商品介绍")
    private String detail;
}
