package com.qinweizhao.activity.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】对象 ams_home_subject
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("ams_home_subject")
public class AmsHomeSubject extends BaseEntity {
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
     * 专题标题
     */
    @Excel(name = "专题标题")
    private String title;

    /**
     * 专题副标题
     */
    @Excel(name = "专题副标题")
    private String subTitle;

    /**
     * 显示状态
     */
    @Excel(name = "显示状态")
    private Integer status;

    /**
     * 详情连接
     */
    @Excel(name = "详情连接")
    private String url;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 专题图片地址
     */
    @Excel(name = "专题图片地址")
    private String img;

}
