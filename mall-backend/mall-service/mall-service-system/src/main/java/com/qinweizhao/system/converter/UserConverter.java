package com.qinweizhao.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.pojo.entity.SysUser;
import com.qinweizhao.system.pojo.form.UserForm;
import com.qinweizhao.system.pojo.po.UserDetailPO;
import com.qinweizhao.system.pojo.po.UserPO;
import com.qinweizhao.system.pojo.vo.user.LoginUserVO;
import com.qinweizhao.system.pojo.vo.user.UserDetailVO;
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
            @Mapping(target = "genderLabel", expression = "java(com.qinweizhao.system.pojo.IBaseEnum.getLabelByValue(po.getGender(), com.qinweizhao.system.pojo.GenderEnum.class))")
    })
    UserVO po2Vo(UserPO po);

    Page<UserVO> po2Vo(Page<UserPO> po);

    UserDetailVO po2Vo(UserDetailPO po);

    UserForm entity2Form(SysUser entity);

    @InheritInverseConfiguration(name = "entity2Form")
    SysUser form2Entity(UserForm entity);

    @Mappings({
            @Mapping(target = "userId", source = "id")
    })
    LoginUserVO entity2LoginUser(SysUser entity);
}
