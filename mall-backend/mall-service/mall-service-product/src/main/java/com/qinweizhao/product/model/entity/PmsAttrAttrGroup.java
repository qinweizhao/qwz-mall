package com.qinweizhao.product.model.entity;

import com.qinweizhao.component.core.entity.BaseEntity;
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
    private Long attrId;

    /**
     * 属性分组id
     */
    private Long attrGroupId;


}
