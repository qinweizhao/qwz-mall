package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.entity.PmsSpu;
import com.qinweizhao.product.model.params.SpuParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface SpuConvert {

    SpuConvert INSTANCE = Mappers.getMapper(SpuConvert.class);


    /**
     * DO 转 DTO
     *
     * @param param param
     * @return PmsSpu
     */
    PmsSpu convert(SpuParam param);

}
