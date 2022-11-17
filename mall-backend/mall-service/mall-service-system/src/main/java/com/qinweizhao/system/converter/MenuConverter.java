package com.qinweizhao.system.converter;

import com.qinweizhao.system.pojo.entity.SysMenu;
import com.qinweizhao.system.pojo.vo.menu.MenuVO;
import org.mapstruct.Mapper;

/**
 * 菜单对象转换器
 *
 * @author haoxr
 * @date 2022/7/29
 */
@Mapper(componentModel = "spring")
public interface MenuConverter {

    MenuVO entity2VO(SysMenu entity);

}