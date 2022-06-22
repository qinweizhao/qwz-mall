package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收藏的专题活动对象 ums_member_collect_subject
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("ums_member_collect_subject")
public class UmsMemberCollectSubject extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * subject_id
     */
    @Excel(name = "subject_id")
    private Long subjectId;

    /**
     * subject_name
     */
    @Excel(name = "subject_name")
    private String subjectName;

    /**
     * subject_img
     */
    @Excel(name = "subject_img")
    private String subjectImg;

    /**
     * 活动url
     */
    @Excel(name = "活动url")
    private String subjectUrl;

}
