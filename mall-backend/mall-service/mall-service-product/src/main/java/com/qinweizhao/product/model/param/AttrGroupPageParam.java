package com.qinweizhao.product.model.param;

import lombok.Data;

/**
 * @author qinweizhao
 * @since 2022/5/9
 */
@Data
public class AttrGroupPageParam {

    /**
     * 组名
     */
    private String name;


    /**
     * 所属分类id
     */
    private Long categoryId;


}
