package com.qinweizhao.user.convert;


import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.user.model.dto.MemberDTO;
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


    /**
     * DO 转 DTO
     *
     * @param member member
     * @return List
     */
    MemberDTO convert(UmsMember member);



    /**
     * DTO 转 LoginUser
     *
     * @param member member
     * @return List
     */
    LoginUser convert(MemberDTO member);

}
