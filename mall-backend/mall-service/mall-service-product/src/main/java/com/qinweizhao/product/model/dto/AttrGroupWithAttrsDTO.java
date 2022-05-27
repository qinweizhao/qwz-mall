package com.qinweizhao.product.model.dto;

import lombok.Data;

import java.util.List;

/**
 * @author weizhao
 */
@Data
public class AttrGroupWithAttrsDTO {

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
    private String icon;


    /**
     * 属性
     */
    private List<AttrDTO> attrs;
}
