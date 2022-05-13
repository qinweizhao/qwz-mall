package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 品牌对象 pms_brand
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsBrand extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌id
     */
    private Long brandId;

    /**
     * 品牌名
     */
    @Excel(name = "品牌名")
    private String name;

    /**
     * 品牌logo地址
     */
    @Excel(name = "品牌logo地址")
    private String logo;

    /**
     * 介绍
     */
    @Excel(name = "介绍")
    private String description;

    /**
     * 显示状态[0-不显示；1-显示]
     */
    @Excel(name = "显示状态[0-不显示；1-显示]")
    private Long status;

    /**
     * 检索首字母
     */
    @Excel(name = "检索首字母")
    private String firstLetter;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;


}
