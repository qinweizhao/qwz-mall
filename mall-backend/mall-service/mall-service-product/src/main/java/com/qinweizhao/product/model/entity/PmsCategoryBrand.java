package com.qinweizhao.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类&品牌
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_category_brand")
public class PmsCategoryBrand extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关联编号;
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 品牌编号
     */
    private Long brandId;

    /**
     * 分类编号
     */
    private Long categoryId;



}
