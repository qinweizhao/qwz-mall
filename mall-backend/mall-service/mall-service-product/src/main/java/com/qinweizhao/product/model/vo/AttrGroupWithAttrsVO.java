package com.qinweizhao.product.model.vo;

import com.qinweizhao.product.model.dto.AttrDTO;
import lombok.Data;

import java.util.List;

/**
 * @author weizhao
 */
@Data
public class AttrGroupWithAttrsVO {

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
