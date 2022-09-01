package com.qinweizhao.product.model.param;

import lombok.Data;

/**
 * @author qinweizhao
 * @since 2022/4/25
 */
@Data
public class AttrParam {

    /**
     * 属性名
     */
    private String name;

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    private Long searchType;

    /**
     * 属性类型[0-销售属性，1-基本属性，2-既是销售属性又是基本属性]
     */
    private Long type;

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    private Long status;

    /**
     * 所属分类
     */
    private Long categoryId;

}
