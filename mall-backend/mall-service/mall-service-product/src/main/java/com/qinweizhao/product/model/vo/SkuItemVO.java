package com.qinweizhao.product.model.vo;


import com.qinweizhao.product.model.dto.*;
import lombok.Data;

import java.util.List;

/**
 * @author qinweizhao
 */
@Data
public class SkuItemVO {

    boolean hasStock = true;

    /**
     * pms_sku_info
     * sku基本信息获取
     */
    SkuInfoDTO skuInfo;


    /**
     * pms_sku_images
     * sku的图片信息
     */
    List<SkuImageDTO> skuImages;

    /**
     * 获取spu的销售属性组合
     */
    List<SkuItemAttrDTO> saleAttr;

    /**
     * 获取spu的介绍
     */
    SpuInfoDetailDTO spuInfoDetail;

    /**
     * 获取spu的规格参数信息
     */
    List<AttrGroupWithAttrsDTO> groupAttrs;

    /**
     * 当前商品的秒杀优惠信息
     */
//    SeckillInfoVo seckillInfo;


}
