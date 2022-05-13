package com.qinweizhao.product.model.entity;

import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品三级分类对象 pms_category
 *
 * @author qinweizhao
 * @date 2022-04-11
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class PmsCategory extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    private Long categoryId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父分类id
     */
    private Long parentId;

    /**
     * 祖级列表
     */
    private String ancestors;

    /**
     * 层级
     */
    private Long level;

    /**
     * 是否显示[0-不显示，1显示]
     */
    private String status;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 计量单位
     */
    private String unit;

    /**
     * 商品数量
     */
    private Long count;

    /**
     * 数据库中不存在
     */
    private List<PmsCategory> children = new ArrayList<>();

}
