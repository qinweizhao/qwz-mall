
package com.qinweizhao.product.entity.vo;

import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 商品属性对象 pms_attr
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AttrRespVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 属性id
     */
    private Long attrId;
    /**
     * 属性id
     */
    private Long attrGroupId;

    /**
     * 属性名
     */
    private String name;

    /**
     * 属性图标
     */
    private String icon;

    /**
     * 可选值列表[用逗号分隔]
     */
    private String valueSelect;

    /**
     * 值类型[0-单值，1-多值]
     */
    private Long valueType;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    private Long searchType;

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
     * 所属分类
     */
    private List<Long> categoryPath;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    private Long quickShow;

}
