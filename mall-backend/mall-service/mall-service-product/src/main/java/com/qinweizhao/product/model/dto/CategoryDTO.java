package com.qinweizhao.product.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 分类
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("pms_category")
public class CategoryDTO extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父编号
     */
    private Long parentId;

    /**
     * 图标
     */
    private String icon;

    /**
     * 层级
     */
    private Integer level;

    /**
     * 状态;[0-停用，1-启用]
     */
    private String status;

    /**
     * 排序
     */
    private Integer sort;

     


}
