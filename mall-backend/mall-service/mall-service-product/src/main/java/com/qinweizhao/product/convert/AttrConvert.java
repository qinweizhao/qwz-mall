package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.AttrDTO;
import com.qinweizhao.product.model.dto.SkuImageDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.entity.PmsSkuImage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface AttrConvert {

    AttrConvert INSTANCE = Mappers.getMapper(AttrConvert.class);

    /**
     * DO 转 DTO
     *
     * @param pmsSkuImage pmsSkuInfo
     * @return List
     */
    AttrDTO convert(PmsAttr pmsSkuImage);

    /**
     * DO 转 DTO
     *
     * @param pmsSkuImage pmsSkuInfo
     * @return List
     */
    List<AttrDTO> convertToDTO(List<PmsAttr> pmsSkuImage);
}
