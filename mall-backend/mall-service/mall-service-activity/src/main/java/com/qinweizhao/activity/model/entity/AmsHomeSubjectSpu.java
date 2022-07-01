package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 专题商品对象 ams_home_subject_spu
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_home_subject_spu")
public class AmsHomeSubjectSpu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 专题名字
     */
    @Excel(name = "专题名字")
    private String name;

    /**
     * 专题id
     */
    @Excel(name = "专题id")
    private Long subjectId;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;


}
