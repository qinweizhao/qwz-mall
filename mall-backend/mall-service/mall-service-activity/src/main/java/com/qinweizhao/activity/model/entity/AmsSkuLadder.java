package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 商品阶梯价格对象 ams_sku_ladder
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_sku_ladder")
public class AmsSkuLadder extends BaseEntity {
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
     * 满几件
     */
    @Excel(name = "满几件")
    private Long fullCount;

    /**
     * 打几折
     */
    @Excel(name = "打几折")
    private BigDecimal discount;

    /**
     * 折后价
     */
    @Excel(name = "折后价")
    private BigDecimal price;

    /**
     * 是否叠加其他优惠[0-不可叠加，1-可叠加]
     */
    @Excel(name = "是否叠加其他优惠[0-不可叠加，1-可叠加]")
    private Integer addOther;


}
