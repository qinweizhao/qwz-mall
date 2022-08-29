package com.qinweizhao.activity.convert;


import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.model.vo.HomeAdvertVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface HomeAdvertConvert {

    HomeAdvertConvert INSTANCE = Mappers.getMapper(HomeAdvertConvert.class);


    /**
     * DO 转 DTO
     *
     * @param homeAdvertList homeAdvertList
     * @return List
     */
    List<HomeAdvertVO> convertToVO(List<AmsHomeAdvert> homeAdvertList);
}
