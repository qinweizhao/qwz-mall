package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.SkuImageDTO;
import com.qinweizhao.product.model.entity.PmsSkuImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface SkuImageConvert {

    SkuImageConvert INSTANCE = Mappers.getMapper(SkuImageConvert.class);

    /**
     * DO 转 DTO
     *
     * @param pmsSkuImage pmsSkuInfo
     * @return List
     */
    List<SkuImageDTO> convertToDTO(List<PmsSkuImage> pmsSkuImage);
}
