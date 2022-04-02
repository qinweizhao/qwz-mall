package com.qinweizhao.product.domain;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * spu图片对象 pms_spu_images
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
public class PmsSpuImages extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * 图片名
     */
    @Excel(name = "图片名")
    private String imgName;

    /**
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String imgUrl;

    /**
     * 顺序
     */
    @Excel(name = "顺序")
    private Long imgSort;

    /**
     * 是否默认图
     */
    @Excel(name = "是否默认图")
    private Long defaultImg;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getImgSort() {
        return imgSort;
    }

    public void setImgSort(Long imgSort) {
        this.imgSort = imgSort;
    }

    public Long getDefaultImg() {
        return defaultImg;
    }

    public void setDefaultImg(Long defaultImg) {
        this.defaultImg = defaultImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id" , getId())
                .append("spuId" , getSpuId())
                .append("imgName" , getImgName())
                .append("imgUrl" , getImgUrl())
                .append("imgSort" , getImgSort())
                .append("defaultImg" , getDefaultImg())
                .toString();
    }
}
