package com.qinweizhao.product.entity.vo;

import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * 属性分组对象 pms_attr_group
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AttrGroupRespVO extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 分组id
     */
    private Long attrGroupId;

    /**
     * 组名
     */
    private String name;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 描述
     */
    private String description;

    /**
     * 组图标
     */
    private List<Long> categoryPath;

    /**
     * 所属分类id
     */
    private Long categoryId;

}
