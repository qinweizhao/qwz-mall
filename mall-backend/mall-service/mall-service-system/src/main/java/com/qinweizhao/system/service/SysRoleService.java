package com.qinweizhao.system.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.pojo.entity.SysRole;
import com.qinweizhao.system.pojo.form.RoleForm;
import com.qinweizhao.system.pojo.form.RoleResourceForm;
import com.qinweizhao.system.pojo.query.RolePageQuery;
import com.qinweizhao.system.pojo.vo.role.RolePageVO;
import com.qinweizhao.system.pojo.Option;

import java.util.List;

/**
 * 角色业务接口层
 *
 * @author haoxr
 * @date 2022/6/3
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 角色分页列表
     *
     * @param queryParams
     * @return
     */
    Page<RolePageVO> listRolePages(RolePageQuery queryParams);


    /**
     * 角色下拉列表
     *
     * @return
     */
    List<Option> listRoleOptions();

    /**
     * @param roleForm
     * @return
     */
    boolean saveRole(RoleForm roleForm);

    /**
     * 修改角色状态
     *
     * @param roleId
     * @param status
     * @return
     */
    boolean updateRoleStatus(Long roleId, Integer status);

    /**
     * 批量删除角色
     *
     * @param ids
     * @return
     */
    boolean deleteRoles(String ids);


    /**
     * 获取角色的资源ID集合,资源包括菜单和权限
     *
     * @param roleId
     * @return
     */
    RoleResourceForm getRoleResources(Long roleId);


    /**
     * 修改角色的资源权限
     *
     * @param roleId
     * @param roleResourceForm
     * @return
     */
    boolean updateRoleResource(Long roleId, RoleResourceForm roleResourceForm);
}
