package com.qinweizhao.product.entity;

import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * spu信息介绍对象 pms_spu_info_detail
 *
 * @author qinweizhao
 * @date 2022-05-02
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PmsSpuInfoDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    private Long spuId;

    /**
     * 商品介绍
     */
    @Excel(name = "商品介绍")
    private String detail;

}
