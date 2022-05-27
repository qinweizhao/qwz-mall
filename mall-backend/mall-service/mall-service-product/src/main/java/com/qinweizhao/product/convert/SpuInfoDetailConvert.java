package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.SkuInfoDTO;
import com.qinweizhao.product.model.dto.SpuInfoDetailDTO;
import com.qinweizhao.product.model.entity.PmsSkuInfo;
import com.qinweizhao.product.model.entity.PmsSpuInfoDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface SpuInfoDetailConvert {

    SpuInfoDetailConvert INSTANCE = Mappers.getMapper(SpuInfoDetailConvert.class);


    /**
     * DO 转 DTO
     *
     * @param pmsSpuInfoDetail pmsSpuInfoDetail
     * @return List
     */
    SpuInfoDetailDTO convert(PmsSpuInfoDetail pmsSpuInfoDetail);

}
