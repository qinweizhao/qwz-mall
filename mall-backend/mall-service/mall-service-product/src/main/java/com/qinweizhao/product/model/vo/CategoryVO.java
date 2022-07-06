package com.qinweizhao.product.model.vo;

import com.qinweizhao.component.core.entity.BaseTree;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author qinweizhao
 * @since 2022/5/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CategoryVO extends BaseTree<CategoryVO> {


    /**
     * id
     */
    private Long categoryId;

    /**
     * label
     */
    private String name;

}
