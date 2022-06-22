package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;

/**
 * spu属性值对象 pms_spu_attr_value
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
public class PmsSpuAttrValue extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 商品id
     */
    @Excel(name = "商品id")
    private Long spuId;

    /**
     * 属性id
     */
    @Excel(name = "属性id")
    private Long attrId;

    /**
     * 属性名
     */
    @Excel(name = "属性名")
    private String name;

    /**
     * 属性值
     */
    @Excel(name = "属性值")
    private String value;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long sort;

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    @Excel(name = "快速展示【是否展示在介绍上；0-否 1-是】")
    private Integer quickShow;

}
