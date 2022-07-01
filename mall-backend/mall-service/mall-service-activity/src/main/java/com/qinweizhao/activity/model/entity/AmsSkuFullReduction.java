package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 商品满减信息对象 ams_sku_full_reduction
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_sku_full_reduction")
public class AmsSkuFullReduction extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long skuId;

    /**
     * 满多少
     */
    @Excel(name = "满多少")
    private BigDecimal fullPrice;

    /**
     * 减多少
     */
    @Excel(name = "减多少")
    private BigDecimal reducePrice;

    /**
     * 是否参与其他优惠
     */
    @Excel(name = "是否参与其他优惠")
    private Integer addOther;


}
