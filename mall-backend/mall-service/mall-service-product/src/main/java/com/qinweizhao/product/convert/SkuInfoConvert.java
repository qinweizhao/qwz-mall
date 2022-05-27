package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.SkuInfoDTO;
import com.qinweizhao.product.model.entity.PmsSkuInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface SkuInfoConvert {

    SkuInfoConvert INSTANCE = Mappers.getMapper(SkuInfoConvert.class);


    /**
     * DO 转 DTO
     *
     * @param pmsSkuInfo pmsSkuInfo
     * @return List
     */
    SkuInfoDTO convert(PmsSkuInfo pmsSkuInfo);

}
