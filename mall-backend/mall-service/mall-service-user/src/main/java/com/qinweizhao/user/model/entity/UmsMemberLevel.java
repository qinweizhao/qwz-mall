package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 会员等级对象 ums_member_level
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ums_member_level")
public class UmsMemberLevel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 等级名称
     */
    @Excel(name = "等级名称")
    private String name;

    /**
     * 等级需要的成长值
     */
    @Excel(name = "等级需要的成长值")
    private Long growthPoint;

    /**
     * 是否为默认等级[0->不是；1->是]
     */
    @Excel(name = "是否为默认等级[0->不是；1->是]")
    private Long defaultStatus;

    /**
     * 免运费标准
     */
    @Excel(name = "免运费标准")
    private BigDecimal freeFreightPoint;

    /**
     * 每次评价获取的成长值
     */
    @Excel(name = "每次评价获取的成长值")
    private Long commentGrowthPoint;

    /**
     * 是否有免邮特权
     */
    @Excel(name = "是否有免邮特权")
    private Long privilegeFreeFreight;


    /**
     * 是否有会员价格特权
     */
    @Excel(name = "是否有会员价格特权")
    private Long privilegeMemberPrice;

    /**
     * 是否有生日特权
     */
    @Excel(name = "是否有生日特权")
    private Long privilegeBirthday;

}
