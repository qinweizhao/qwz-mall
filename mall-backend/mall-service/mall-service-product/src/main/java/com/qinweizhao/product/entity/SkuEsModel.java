package com.qinweizhao.product.entity;


import jdk.internal.util.xml.impl.Attrs;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * "properties": {
 *       "attrs": {
 *         "type": "nested",
 *         "properties": {
 *           "attrId": {
 *             "type": "long"
 *           },
 *           "attrName": {
 *             "type": "keyword",
 *             "index": false,
 *             "doc_values": false
 *           },
 *           "attrValue": {
 *             "type": "keyword"
 *           }
 *         }
 *       }
 *     }
 *   }
 */
@Data
public class SkuEsModel {

    private Long skuId;

    private Long spuId;

    private String skuTitle;

    private BigDecimal skuPrice;

    private String skuImg;

    private Long saleCount;

    private Boolean hasStock;

    private Long hotScore;

    private Long brandId;

    private Long categoryId;

    private String brandName;

    private String brandImg;

    private String catalogName;

    private List<Attr> attrs;


    @Data
    public static class Attr{

        private Long attrId;
        private String attrName;
        private String attrValue;
    }

}
