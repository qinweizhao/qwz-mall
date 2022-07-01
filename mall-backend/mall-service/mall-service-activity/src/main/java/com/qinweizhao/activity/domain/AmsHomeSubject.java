package com.qinweizhao.activity.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】对象 ams_home_subject
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("title", getTitle())
                .append("subTitle", getSubTitle())
                .append("status", getStatus())
                .append("url", getUrl())
                .append("sort", getSort())
                .append("img", getImg())
                .append("createBy", getCreateBy())
                .append("updateBy", getUpdateBy())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
