package com.qinweizhao.product.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/14
 */
@Data
@Accessors(chain = true)
public class CategoryTreeDTO implements Serializable {

    /**
     * id
     */
    private Long categoryId;

    /**
     * id
     */
    private Long parentId;

    /**
     * name
     */
    private String name;


    /**
     * children
     */
    private List<CategoryTreeDTO> children;
}
