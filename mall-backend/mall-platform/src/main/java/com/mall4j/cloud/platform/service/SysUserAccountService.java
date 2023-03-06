package com.mall4j.cloud.platform.service;

import com.mall4j.cloud.api.auth.vo.AuthAccountVO;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.platform.dto.ChangeAccountDTO;

/**
 * @author lhd
 * @date 2020/12/22
 */
public interface SysUserAccountService {

	/**
	 * 添加账户
	 * @param changeAccountDTO 账户信息
	 * @return void
	 */
	ServerResponseEntity<Void> save(ChangeAccountDTO changeAccountDTO);

	/**
	 * 更新账户
	 * @param changeAccountDTO 账户信息
	 * @return
	 */
	ServerResponseEntity<Void> update(ChangeAccountDTO changeAccountDTO);

	/**
	 * 根据用户id和系统类型获取用户信息
	 * @param userId 用户id
	 * @param sysType 系统类型
	 * @return void
	 */
	ServerResponseEntity<AuthAccountVO> getByUserIdAndSysType(Long userId, Integer sysType);
}
