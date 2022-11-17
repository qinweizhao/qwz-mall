package com.qinweizhao.system.converter;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.common.model.Option;
import com.qinweizhao.system.pojo.entity.SysRole;
import com.qinweizhao.system.pojo.form.RoleForm;
import com.qinweizhao.system.pojo.vo.role.RolePageVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * 角色对象转换器
 *
 * @author haoxr
 * @date 2022/5/29
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    Page<RolePageVO> entity2Page(Page<SysRole> page);

    @Mappings({
            @Mapping(target = "value", source = "id"),
            @Mapping(target = "label", source = "name")
    })
    Option role2Option(SysRole role);


    List<Option> roles2Options(List<SysRole> roles);

    SysRole form2Entity(RoleForm roleForm);
}