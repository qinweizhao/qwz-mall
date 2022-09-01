package com.qinweizhao.product.model.params;

import lombok.Data;

/**
 * <p>
 * spu信息
 * </p>
 *
 * @author qinweizhao
 * @since 2022-09-01
 */
@Data
public class SpuParam {


    /**
     * 编号
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 分类编号
     */
    private Long categoryId;

    /**
     * 品牌编号
     */
    private Long brandId;

    /**
     * 主图
     */
    private String mainImgUrl;

    /**
     * 图册;多个图片逗号分隔
     */
    private String imgUrls;

    /**
     * 详情
     */
    private String detail;

    /**
     * 状态;[0- 新建，1 - 上架，2 - 下架]
     */
    private Integer status;

     


}
