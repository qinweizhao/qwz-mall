package com.qinweizhao.product.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 属性&属性分组关联对象 pms_attr_attr_group
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Data
public class AttrAttrGroupSaveBatchVO {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 属性id
     */
    private String attrIds;

    /**
     * 属性分组id
     */
    private Long attrGroupId;

    /**
     * 属性组内排序
     */
    private Long sort;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}
