package com.mall4j.cloud.rbac.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 菜单资源DTO
 *
 * @author FrozenWatermelon
 * @date 2020-09-15 16:35:01
 */
public class MenuPermissionDTO {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单资源用户id")
    private Long menuPermissionId;

    @NotNull(message = "menuId NotNull")
    @ApiModelProperty("资源关联菜单")
    private Long menuId;

	@NotBlank(message = "permission NotBlank")
    @ApiModelProperty("权限对应的编码")
    private String permission;

    @ApiModelProperty("资源名称")
    private String name;

    @ApiModelProperty("资源对应服务器路径")
	@NotBlank(message = "uri NotBlank")
    private String uri;

	@NotNull(message = "method NotNull")
    @ApiModelProperty("请求方法 1.GET 2.POST 3.PUT 4.DELETE")
    private Integer method;

	public Long getMenuPermissionId() {
		return menuPermissionId;
	}

	public void setMenuPermissionId(Long menuPermissionId) {
		this.menuPermissionId = menuPermissionId;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getMethod() {
		return method;
	}

	public void setMethod(Integer method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "MenuPermissionVO{" +
				"menuPermissionId=" + menuPermissionId +
				",menuId=" + menuId +
				",permission=" + permission +
				",name=" + name +
				",uri=" + uri +
				",method=" + method +
				'}';
	}
}
