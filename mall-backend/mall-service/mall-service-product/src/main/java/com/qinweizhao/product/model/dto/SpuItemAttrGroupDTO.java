package com.qinweizhao.product.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Data
public class SpuItemAttrGroupDTO {

    private String name;
    private List<AttrDTO> attrs;


    @Data
    public static class AttrDTO {

        /**
         * 属性id
         */
        private Long attrId;

        /**
         * 属性名
         */
        private String name;


        private String value;

    }
}
