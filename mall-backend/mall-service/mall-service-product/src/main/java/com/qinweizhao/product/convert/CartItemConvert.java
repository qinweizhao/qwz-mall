package com.qinweizhao.product.convert;

import com.qinweizhao.product.model.dto.CartItemDTO;
import com.qinweizhao.product.model.entity.PmsCartItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/6/18
 */
@Mapper
public interface CartItemConvert {

    CartItemConvert INSTANCE = Mappers.getMapper(CartItemConvert.class);

    /**
     * DTO 转 VO
     *
     * @param cartItemList cartItemList
     * @return List
     */
    List<CartItemDTO> convertToDTO(List<PmsCartItem> cartItemList);

}
