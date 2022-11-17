package com.qinweizhao.product.model.params;

import lombok.Data;

/**
 * <p>
 * 属性
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
public class AttrParam {

    /**
     * 编号
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型;[0-销售属性，1-基本属性]
     */
    private Integer type;

    /**
     * 是否检索;[0-不需要，1-需要]
     */
    private Integer searchType;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态;[0-禁用，1-启用]
     */
    private Long status;

}