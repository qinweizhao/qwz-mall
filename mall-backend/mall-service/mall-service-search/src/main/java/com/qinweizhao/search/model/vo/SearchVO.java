package com.qinweizhao.search.model.vo;

import com.qinweizhao.component.core.response.PageResult;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchVO extends PageResult<Object> {

    /**
     * 所有商品信息
     */
    private List<Product> products;

    /**
     * 品牌
     */
    private List<Brand> brands;

    /**
     * 所有涉及到的所有分类
     */
    private List<Category> categories;

    /**
     * 所有涉及到的所有属性
     */
    private List<Attr> attrs;



    @Data
    public static class Product {

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
        public static class Attr {

            private Long attrId;
            private String attrName;
            private String attrValue;
        }

    }


    @Data
    public static class Brand {
        private Long brandId;
        private String brandName;

        private String brandImg;
    }

    @Data
    public static class Category {
        private Long categoryId;
        private String categoryName;
    }

    @Data
    public static class Attr {
        private Long attrId;
        private String attrName;

        private List<String> attrValue;
    }
}
