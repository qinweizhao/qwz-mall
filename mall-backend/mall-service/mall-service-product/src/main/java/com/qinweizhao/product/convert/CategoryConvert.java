package com.qinweizhao.product.convert;


import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.model.vo.CategoryVO;
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
@Mapper
public interface CategoryConvert {

    CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);

    /**
     * convert VO
     *
     * @param list list
     * @return CategoryVO
     */
    List<CategoryVO> convertToVO(List<PmsCategory> list);
}
