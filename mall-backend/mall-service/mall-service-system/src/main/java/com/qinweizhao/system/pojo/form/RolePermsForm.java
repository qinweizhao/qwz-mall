package com.qinweizhao.system.pojo.form;

import lombok.Data;

import java.util.List;

/**
 * 角色权限传输层对象
 *
 * @author haoxr
 * @date 2021/12/19 11:46
 */
@Data
public class RolePermsForm {

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 权限ID集合
     */
    private List<Long> permIds;

}
