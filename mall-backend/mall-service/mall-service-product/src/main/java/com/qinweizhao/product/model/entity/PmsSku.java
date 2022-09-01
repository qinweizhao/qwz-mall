package com.qinweizhao.product.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_sku")
public class PmsSku extends BaseEntity {

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
     * 名称
     */
    private String name;

    /**
     * 图片
     */
    private String imgUrl;

    /**
     * 体积
     */
    private BigDecimal volume;

    /**
     * 销量
     */
    private Long saleCount;

    /**
     * 价格
     */
    private BigDecimal price;

     


}
