package com.qinweizhao.product.entity.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qinweizhao
 */
@Data
public class PmsSpuSaveVO {

    /**
     * 商品名称
     */
    private String spuName;

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
     * 商品介绍
     */
    private List<String> details;

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


}

@Data
class Bounds {

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
class BaseAttr {

    /**
     * 属性 id
     */
    private int attrId;

    /**
     * 属性值
     */
    private String attrValues;

    /**
     * 快速展示
     */
    private String showDesc;

}

@Data
class Skus {

    /**
     * 销售属性
     */
    private List<Attr> attr;

    /**
     * skuName
     */
    private String skuName;

    /**
     * 价格
     */
    private String price;

    /**
     * 标题
     */
    private String skuTitle;

    /**
     * 副标题
     */
    private String skuSubtitle;


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

}

@Data
class Attr {

    private int attrId;
    private String attrName;
    private String attrValue;

}

@Data
class Images {

    private String imgUrl;
    private int defaultImg;
}


@Data
class MemberPrice {
    private int id;
    private String name;
    private int price;
}