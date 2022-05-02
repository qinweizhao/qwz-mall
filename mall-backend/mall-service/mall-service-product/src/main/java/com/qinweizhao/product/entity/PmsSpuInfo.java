package com.qinweizhao.product.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * spu信息对象 pms_spu_info
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PmsSpuInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 商品名称
     */
    @Excel(name = "商品名称")
    private String name;

    /**
     * 商品描述
     */
    @Excel(name = "商品描述")
    private String description;

    /**
     * 所属分类id
     */
    @Excel(name = "所属分类id")
    private Long categoryId;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * 重量
     */
    @Excel(name = "重量")
    private BigDecimal weight;

    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    @Excel(name = "上架状态[0 - 新建，1 - 上架，2 - 下架]")
    private Long status;

}
