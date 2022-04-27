package com.qinweizhao.product.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 属性&属性分组关联对象 pms_attr_attr_group
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsAttrAttrGroup extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 属性id
     */
    @Excel(name = "属性id")
    private Long attrId;

    /**
     * 属性分组id
     */
    @Excel(name = "属性分组id")
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    @Excel(name = "属性组内排序")
    private Long sort;

}
