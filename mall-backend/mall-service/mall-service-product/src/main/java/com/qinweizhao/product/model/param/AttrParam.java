package com.qinweizhao.product.model.param;

import lombok.Data;

/**
 * @author qinweizhao
 * @since 2022/4/25
 */
@Data
public class AttrParam {
    /**
     * 属性id
     */
    private Long attrId;

    /**
     * 属性名
     */
    private String name;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    private Long searchType;

    /**
     * 属性图标
     */
    private String icon;

    /**
     * 可选值列表[用逗号分隔]
     */
    private String valueSelect;

    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    private Long type;

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    private Long status;

    /**
     * 所属分类
     */
    private Long categoryId;

    /**
     * 所属分类三级分类路径
     */
    private String categoryPath;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    private Long quickShow;

    /**
     * add 属性分组 id
     */
    private Long attrGroupId;

}
