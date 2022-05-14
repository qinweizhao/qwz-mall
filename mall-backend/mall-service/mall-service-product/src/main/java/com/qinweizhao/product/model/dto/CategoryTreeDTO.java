package com.qinweizhao.product.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/14
 */
@Data
public class CategoryTreeDTO {

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
    private String categoryName;


    /**
     * children
     */
    private List<CategoryTreeDTO> children;
}
