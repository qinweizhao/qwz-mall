package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * sku图片对象 pms_sku_images
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
public class PmsSkuImages extends BaseEntity {
    private static final long serialVersionUID = 1L;

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
    private Long defaultImage;

}
