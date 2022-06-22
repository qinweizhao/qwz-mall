package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员收藏的商品对象 ums_member_collect_spu
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("ums_member_collect_spu")
public class UmsMemberCollectSpu extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 会员id
     */
    @Excel(name = "会员id")
    private Long memberId;

    /**
     * spu_id
     */
    @Excel(name = "spu_id")
    private Long spuId;

    /**
     * spu_name
     */
    @Excel(name = "spu_name")
    private String spuName;

    /**
     * spu_img
     */
    @Excel(name = "spu_img")
    private String spuImg;


}
