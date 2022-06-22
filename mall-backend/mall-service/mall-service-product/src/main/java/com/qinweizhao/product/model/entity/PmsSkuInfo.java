package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * sku信息对象 pms_sku_info
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsSkuInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * skuId
     */
    private Long skuId;

    /**
     * spuId
     */
    @Excel(name = "spuId")
    private Long spuId;

    /**
     * sku名称
     */
    @Excel(name = "sku名称")
    private String name;

    /**
     * sku介绍描述
     */
    @Excel(name = "sku介绍描述")
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
     * 默认图片
     */
    @Excel(name = "默认图片")
    private String defaultImg;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 副标题
     */
    @Excel(name = "副标题")
    private String subtitle;

    /**
     * 价格
     */
    @Excel(name = "价格")
    private BigDecimal price;

    /**
     * 销量
     */
    @Excel(name = "销量")
    private Long saleCount;

}
