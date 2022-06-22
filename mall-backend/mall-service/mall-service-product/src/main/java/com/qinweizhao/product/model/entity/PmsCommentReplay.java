package com.qinweizhao.product.model.entity;

import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 商品评价回复关系对象 pms_comment_replay
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PmsCommentReplay extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 评论id
     */
    private Long commentId;

    /**
     * 回复id
     */
    private Long replayId;

}
