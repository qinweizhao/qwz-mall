package com.qinweizhao.product.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/14
 */
@Data
public class CategoryTreeRespVO {


    /**
     * id
     */
    private Long categoryId;

    /**
     * label
     */
    private String name;


    /**
     * children
     */
    private List<CategoryTreeRespVO> children;

}
