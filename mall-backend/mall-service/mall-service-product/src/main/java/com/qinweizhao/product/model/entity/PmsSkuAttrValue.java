package com.qinweizhao.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * sku销售属性
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_sku_attr_value")
public class PmsSkuAttrValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 关联编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * sku编号
     */
    private Long skuId;

    /**
     * 属性编号
     */
    private Long attrId;

    /**
     * 销售属性名
     */
    private String name;

    /**
     * 销售属性值
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;

     


}
