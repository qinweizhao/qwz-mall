package com.qinweizhao.product.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qinweizhao
 */
@Data
public class SpuSaveVO {

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 所属分类 id
     */
    private Long categoryId;

    /**
     * 所属品牌 id
     */
    private Long brandId;

    /**
     * 商品重量
     */
    private BigDecimal weight;

    /**
     * 发布状态
     */
    private Long status;


    /**
     * 商品介绍(详情)
     */
    private String details;

    /**
     * 商品图集
     */
    private List<String> images;

    /**
     * 设置积分
     */
    private Bounds bounds;


    /**
     * 规格参数(基础属性)
     */
    private List<BaseAttr> baseAttrs;

    /**
     * Skus
     */
    private List<Skus> skus;


    @Data
    public static class Bounds {

        /**
         * 金币
         */
        private int buyBounds;

        /**
         * 成长值
         */
        private int growBounds;

    }

    @Data
    public static class BaseAttr {

        /**
         * 属性 id
         */
        private Long attrId;

        /**
         * 属性值
         */
        private String attrValues;

        /**
         * 快速展示
         */
        private Integer quickShow;

    }

    @Data
    public static class Skus {

        /**
         * 销售属性
         */
        private List<SaleAttr> saleAttrs;

        /**
         * skuName
         */
        private String name;

        /**
         * 价格
         */
        private BigDecimal price;

        /**
         * 标题
         */
        private String title;

        /**
         * 副标题
         */
        private String subtitle;


        /**
         * 图集
         */
        private List<Images> images;

        /**
         * saleAttr信息
         */
        private List<String> details;


        /**
         * 满 fullCount 件
         */
        private int fullCount;

        /**
         * discount 折
         */
        private int discount;


        /**
         * 可叠加优惠
         */
        private int countStatus;


        /**
         * 满 fullPrice 元
         */
        private int fullPrice;

        /**
         * 减 reducePrice;
         */
        private int reducePrice;
        /**
         * 可叠加优惠
         */
        private int priceStatus;

        /**
         * 会员价格
         */
        private List<MemberPrice> memberPrice;

        @Data
        public static class SaleAttr {

            private int attrId;
            private String name;
            private String value;

        }

        @Data
        public static class Images {

            private String imgUrl;
            private Integer defaultImg;
        }


        @Data
        public static class MemberPrice {
            private int id;
            private String name;
            private int price;
        }
    }
}










