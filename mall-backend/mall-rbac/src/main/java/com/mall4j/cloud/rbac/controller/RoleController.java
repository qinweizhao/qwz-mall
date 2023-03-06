package com.mall4j.cloud.rbac.controller;

import com.mall4j.cloud.common.response.ResponseEnum;
import com.mall4j.cloud.rbac.model.Role;
import com.mall4j.cloud.rbac.service.RoleService;
import com.mall4j.cloud.rbac.vo.RoleVO;
import com.mall4j.cloud.rbac.dto.RoleDTO;
import com.mall4j.cloud.api.auth.bo.UserInfoInTokenBO;
import com.mall4j.cloud.common.database.dto.PageDTO;
import com.mall4j.cloud.common.database.vo.PageVO;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.common.security.AuthUserContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 角色
 *
 * @author FrozenWatermelon
 * @date 2020-09-17 19:15:44
 */
@RestController
@RequestMapping("/role")
@Api(tags = "角色")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
	private MapperFacade mapperFacade;

	@GetMapping("/page")
	@ApiOperation(value = "分页获取角色列表", notes = "分页获取角色列表")
	public ServerResponseEntity<PageVO<RoleVO>> page(@Valid PageDTO pageDTO) {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
		PageVO<RoleVO> rolePage = roleService.page(pageDTO, userInfoInTokenBO.getSysType(), userInfoInTokenBO.getTenantId());
		return ServerResponseEntity.success(rolePage);
	}

    @GetMapping("/list")
    @ApiOperation(value = "获取角色列表", notes = "分页获取角色列表")
    public ServerResponseEntity<List<RoleVO>> list() {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
        return ServerResponseEntity.success(roleService.list(userInfoInTokenBO.getSysType(), userInfoInTokenBO.getTenantId()));
    }

	@GetMapping
    @ApiOperation(value = "获取角色", notes = "根据roleId获取角色")
    public ServerResponseEntity<RoleVO> getByRoleId(@RequestParam Long roleId) {
        return ServerResponseEntity.success(roleService.getByRoleId(roleId));
    }

    @PostMapping
    @ApiOperation(value = "保存角色", notes = "保存角色")
    public ServerResponseEntity<Void> save(@Valid @RequestBody RoleDTO roleDTO) {
        Role role = mapperFacade.map(roleDTO, Role.class);
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();
        role.setBizType(userInfoInTokenBO.getSysType());
        role.setRoleId(null);
        role.setCreateUserId(userInfoInTokenBO.getUserId());
        role.setTenantId(userInfoInTokenBO.getTenantId());
        roleService.save(role, roleDTO.getMenuIds(), roleDTO.getMenuPermissionIds());
        return ServerResponseEntity.success();
    }

    @PutMapping
    @ApiOperation(value = "更新角色", notes = "更新角色")
    public ServerResponseEntity<Void> update(@Valid @RequestBody RoleDTO roleDTO) {

        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();


        RoleVO dbRole = roleService.getByRoleId(roleDTO.getRoleId());

        if (!Objects.equals(dbRole.getBizType(), userInfoInTokenBO.getSysType()) || !Objects.equals(dbRole.getTenantId(), userInfoInTokenBO.getTenantId())) {
            return ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED);
        }
        Role role = mapperFacade.map(roleDTO, Role.class);
        role.setBizType(userInfoInTokenBO.getSysType());

        roleService.update(role, roleDTO.getMenuIds(), roleDTO.getMenuPermissionIds());
        return ServerResponseEntity.success();
    }

    @DeleteMapping
    @ApiOperation(value = "删除角色", notes = "根据角色id删除角色")
    public ServerResponseEntity<Void> delete(@RequestParam Long roleId) {
        UserInfoInTokenBO userInfoInTokenBO = AuthUserContext.get();

        RoleVO dbRole = roleService.getByRoleId(roleId);

        if (!Objects.equals(dbRole.getBizType(), userInfoInTokenBO.getSysType()) || !Objects.equals(dbRole.getTenantId(), userInfoInTokenBO.getTenantId())) {
            return ServerResponseEntity.fail(ResponseEnum.UNAUTHORIZED);
        }
        roleService.deleteById(roleId,userInfoInTokenBO.getSysType());
        return ServerResponseEntity.success();
    }
}
