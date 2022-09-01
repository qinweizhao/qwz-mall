package com.qinweizhao.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * spu规格参数
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_spu_attr_value")
public class PmsSpuAttrValue extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * spu编号
     */
    private Long spuId;

    /**
     * 属性编号
     */
    private Long attrId;

    /**
     * 属性名称
     */
    private String attrName;

    /**
     * 值
     */
    private String value;

    /**
     * 顺序
     */
    private Integer sort;

     


}
