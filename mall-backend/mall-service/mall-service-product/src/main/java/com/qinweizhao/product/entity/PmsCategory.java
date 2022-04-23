package com.qinweizhao.product.entity;

import com.qinweizhao.common.core.annotation.Excel;
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
    @Excel(name = "分类名称")
    private String name;

    /**
     * 父分类id
     */
    @Excel(name = "父分类id")
    private Long parentId;

    /**
     * 层级
     */
    @Excel(name = "层级")
    private Long level;

    /**
     * 是否显示[0-不显示，1显示]
     */
    @Excel(name = "是否显示[0-不显示，1显示]")
    private String status;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 计量单位
     */
    @Excel(name = "计量单位")
    private String unit;

    /**
     * 商品数量
     */
    @Excel(name = "商品数量")
    private Long count;

    /**
     * 数据库中不存在
     */
    private List<PmsCategory> children = new ArrayList<>();

}
