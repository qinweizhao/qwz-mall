package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.AttrDTO;
import com.qinweizhao.product.model.dto.AttrGroupWithAttrsDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.vo.AttrGroupWithAttrsVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/27
 */
@Mapper
public interface AttrGroupConvert {

    AttrGroupConvert INSTANCE = Mappers.getMapper(AttrGroupConvert.class);

    /**
     * DTO 转 VO
     *
     * @param attrGroupWithAttrsDTOList attrGroupWithAttrsDTOList
     * @return List
     */
    List<AttrGroupWithAttrsVO> convertToVO(List<AttrGroupWithAttrsDTO> attrGroupWithAttrsDTOList);
}
