package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 优惠券分类关联对象 ams_coupon_spu_category_relation
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_coupon_spu_category_relation")
public class AmsCouponSpuCategoryRelation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 优惠券id
     */
    @Excel(name = "优惠券id")
    private Long couponId;

    /**
     * 产品分类id
     */
    @Excel(name = "产品分类id")
    private Long categoryId;

    /**
     * 产品分类名称
     */
    @Excel(name = "产品分类名称")
    private String categoryName;

}
