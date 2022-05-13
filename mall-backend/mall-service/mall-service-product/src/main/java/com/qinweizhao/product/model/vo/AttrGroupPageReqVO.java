package com.qinweizhao.product.model.vo;

import lombok.Data;

/**
 * @author qinweizhao
 * @since 2022/5/9
 */
@Data
public class AttrGroupPageReqVO {

    /**
     * 组名
     */
    private String name;


    /**
     * 所属分类id
     */
    private Long categoryId;


}
