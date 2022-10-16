package com.qinweizhao.search.convert;


import com.qinweizhao.api.search.model.param.EsSkuSaveParam;
import com.qinweizhao.search.model.vo.SearchVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


/**
 * <p>
 * 部门表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper(componentModel = "spring")
public interface SearchConvert {

    SearchConvert INSTANCE = Mappers.getMapper(SearchConvert.class);


    /**
     * DTO 转 VO
     *
     * @param esSkuSaveParamList esSkuSaveDTOList
     * @return List
     */
    List<SearchVO.Product> convertToVO(List<EsSkuSaveParam> esSkuSaveParamList);

}
