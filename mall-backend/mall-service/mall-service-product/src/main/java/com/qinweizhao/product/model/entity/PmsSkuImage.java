package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * sku图片对象 pms_sku_image
 *
 * @author qinweizhao
 * @date 2022-04-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsSkuImage extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * sku_id
     */
    private Long skuImageId;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String url;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    @Excel(name = "默认图[0 - 不是默认图，1 - 是默认图]")
    private Integer defaultImage;


}
