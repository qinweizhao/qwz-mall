package com.qinweizhao.product.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 分类&品牌关联对象 pms_category_brand
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsCategoryBrand extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 品牌id
     */
    @Excel(name = "品牌id")
    private Long brandId;

    /**
     * 分类id
     */
    @Excel(name = "分类id")
    private Long categoryId;

    /**
     * 品牌名称
     */
    @Excel(name = "品牌名称")
    private String brandName;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String categoryName;

}
