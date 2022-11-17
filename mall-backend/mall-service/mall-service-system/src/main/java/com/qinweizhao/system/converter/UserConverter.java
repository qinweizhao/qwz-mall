package com.qinweizhao.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.pojo.bo.UserBO;
import com.qinweizhao.system.pojo.bo.UserFormBO;
import com.qinweizhao.system.pojo.entity.SysUser;
import com.qinweizhao.system.pojo.form.UserForm;
import com.qinweizhao.system.pojo.vo.user.UserLoginVO;
import com.qinweizhao.system.pojo.vo.user.UserVO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 用户对象转换器
 *
 * @author haoxr
 * @date 2022/6/8
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    @Mappings({
            @Mapping(target = "genderLabel", expression = "java(com.qinweizhao.system.common.base.IBaseEnum.getLabelByValue(po.getGender(),com.qinweizhao.system.common.enums.GenderEnum.class))")
    })
    UserVO po2Vo(UserBO po);

    Page<UserVO> bo2Vo(Page<UserBO> po);

    UserForm bo2Form(UserFormBO po);

    @InheritInverseConfiguration(name = "entity2Form")
    SysUser form2Entity(UserForm entity);

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    UserLoginVO entity2LoginUser(SysUser entity);
}
