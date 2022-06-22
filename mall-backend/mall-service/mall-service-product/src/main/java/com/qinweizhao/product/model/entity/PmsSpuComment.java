package com.qinweizhao.product.model.entity;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品评价对象 pms_spu_comment
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PmsSpuComment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * sku_id
     */
    private Long skuId;

    /**
     * spu_id
     */
    private Long spuId;

    /**
     * 商品名字
     */
    private String spuName;

    /**
     * 会员昵称
     */
    private String memberNickName;

    /**
     * 星级
     */
    private Integer star;

    /**
     * 会员ip
     */
    private String memberIp;

    /**
     * 显示状态[0-不显示，1-显示]
     */
    private Integer showStatus;

    /**
     * 购买时属性组合
     */
    private String spuAttributes;

    /**
     * 点赞数
     */
    private Long likesCount;

    /**
     * 回复数
     */
    private Long replyCount;

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    private String resources;

    /**
     * 内容
     */
    private String content;

    /**
     * 用户头像
     */
    private String memberAvatar;

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    private Long type;

}
