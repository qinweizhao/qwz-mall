package com.qinweizhao.product.model.vo;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.product.model.entity.PmsAttr;
import lombok.Data;

import java.util.List;

/**
 * @author weizhao
 */
@Data
public class AttrGroupWithPmsAttrsVO {

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

    private List<PmsAttr> attrs;
}
