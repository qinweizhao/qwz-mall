package com.qinweizhao.user.convert;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.user.model.entity.UmsMember;
import com.qinweizhao.user.model.vo.MemberVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;



/**
 * <p>
 * 部门表
 * </p>
 *
 * @author qinweizhao
 * @since 2021-12-06
 */
@Mapper(componentModel = "spring")
public interface MemberConvert {

    MemberConvert INSTANCE = Mappers.getMapper(MemberConvert.class);

    /**
     * DO 转 DTO
     *
     * @param pageResult pageResult
     * @return List
     */
    PageResult<MemberVO> convertToVO(PageResult<UmsMember> pageResult);



}
