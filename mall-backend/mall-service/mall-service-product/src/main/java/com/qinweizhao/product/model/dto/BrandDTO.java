package com.qinweizhao.product.model.dto;

import lombok.Data;

/**
 * <p>
 * 品牌
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
public class BrandDTO {


    /**
     * 编号
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 标志
     */
    private String logo;

    /**
     * 介绍
     */
    private String description;

    /**
     * 状态;[0-不显示，1-显示]
     */
    private Integer status;

    /**
     * 检索首字母
     */
    private String firstLetter;

    /**
     * 排序
     */
    private Integer sort;


}
