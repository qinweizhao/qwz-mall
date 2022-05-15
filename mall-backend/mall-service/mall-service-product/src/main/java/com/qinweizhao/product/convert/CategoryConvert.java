package com.qinweizhao.product.convert;


import com.qinweizhao.product.model.dto.CategoryTreeDTO;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.model.vo.CategoryTreeRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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
public interface CategoryConvert {

    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    /**
     * DO 转 DTO
     *
     * @param pmsCategoryList pmsCategory
     * @return List
     */
    List<CategoryTreeDTO> convertToDTO(List<PmsCategory> pmsCategoryList);

    /**
     * DTO 转 VO
     *
     * @param categoryTreeDTOList categoryTreeDTOList
     * @return List
     */
    List<CategoryTreeRespVO> convertToVO(List<CategoryTreeDTO> categoryTreeDTOList);

}
