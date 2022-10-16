package com.qinweizhao.sale.convert;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface HomeAdvertConvert {

    HomeAdvertConvert INSTANCE = Mappers.getMapper(HomeAdvertConvert.class);

}
