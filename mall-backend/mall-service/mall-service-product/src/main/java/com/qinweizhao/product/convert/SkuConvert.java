package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.SkuDTO;
import com.qinweizhao.product.model.params.SkuParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface SkuConvert {

    SkuConvert INSTANCE = Mappers.getMapper(SkuConvert.class);


    /**
     * DO 转 DTO
     *
     * @param param param
     * @return List
     */
    SkuDTO convert(SkuParam param);

}
