package com.qinweizhao.api.search.dto;


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
 * @author weizhao
 */
@Data
public class EsSkuSaveDTO {

    private Long skuId;

    private Long spuId;

    private String skuTitle;

    private Long skuPrice;

    private String skuImg;

    private Long saleCount;

    private Boolean hasStock;

    private Long hotScore;

    private Long brandId;

    private Long categoryId;

    private String brandName;

    private String brandImg;

    private String categoryName;

    private List<Attr> attrs;


    @Data
    public static class Attr{

        private Long attrId;
        private String attrName;
        private String attrValue;
    }

}
