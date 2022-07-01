package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 秒杀活动商品关联对象 ams_seckill_sku_relation
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_seckill_sku_relation")
public class AmsSeckillSkuRelation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 活动id
     */
    @Excel(name = "活动id")
    private Long promotionId;

    /**
     * 活动场次id
     */
    @Excel(name = "活动场次id")
    private Long promotionSessionId;

    /**
     * 商品id
     */
    @Excel(name = "商品id")
    private Long skuId;

    /**
     * 秒杀价格
     */
    @Excel(name = "秒杀价格")
    private Long seckillPrice;

    /**
     * 秒杀总量
     */
    @Excel(name = "秒杀总量")
    private Long seckillCount;

    /**
     * 每人限购数量
     */
    @Excel(name = "每人限购数量")
    private Long seckillLimit;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long seckillSort;


}
