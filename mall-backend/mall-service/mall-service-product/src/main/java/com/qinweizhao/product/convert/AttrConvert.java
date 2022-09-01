package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.param.AttrParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

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
     * @param param pmsSkuInfo
     * @return List
     */
    PmsAttr convert(AttrParam param);

}
