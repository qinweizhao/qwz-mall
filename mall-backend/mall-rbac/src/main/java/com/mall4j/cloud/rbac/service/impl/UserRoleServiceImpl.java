package com.mall4j.cloud.rbac.service.impl;

import com.mall4j.cloud.rbac.mapper.UserRoleMapper;
import com.mall4j.cloud.rbac.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author FrozenWatermelon
 * @date 2020/6/23
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Resource
	private UserRoleMapper userRoleMapper;

}
