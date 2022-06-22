package com.qinweizhao.product.model.entity;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu图片对象 pms_spu_image
 *
 * @author qinweizhao
 * @date 2022-05-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PmsSpuImage extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * 图片名
     */
    private String name;

    /**
     * 图片地址
     */
    private String url;

    /**
     * 顺序
     */
    private Long sort;

    /**
     * 是否默认图
     */
    private Long defaultImage;

}
