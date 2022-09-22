package com.qinweizhao.user.convert;


import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.user.model.dto.UserDTO;
import com.qinweizhao.user.model.entity.UmsUser;
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
     * @param member member
     * @return List
     */
    UserDTO convert(UmsUser member);



    /**
     * DTO 转 LoginUser
     *
     * @param member member
     * @return List
     */
    LoginUser convert(UserDTO member);

}
