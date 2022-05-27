package com.qinweizhao.product.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Data
public class SkuItemAttrDTO {
    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdDTO> attrValues;

    @Data
    public static class AttrValueWithSkuIdDTO {

        private String attrValue;

        private String skuIds;

    }
}