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
@Mapper
public interface CategoryConvert {

    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    /**
     * DO 转 DTO
     *
     * @param pmsCategory pmsCategory
     * @return List
     */

    @Mapping(source = "name" ,target = "categoryName")
    List<CategoryTreeDTO> convertToDTO(List<PmsCategory> pmsCategory);

    /**
     * DO 转 DTO
     *
     * @param categoryTreeDTO categoryTreeDTO
     * @return List
     */
    @Mappings({
            @Mapping(source = "categoryId" , target = "id"),
            @Mapping(source = "categoryName" , target = "label")
    })
    List<CategoryTreeRespVO> convertToVO(List<CategoryTreeDTO> categoryTreeDTO);


}
