/*
 * Copyright (c) 2020 pig4cloud Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qinweizhao.auth.service.impl;

import com.qinweizhao.auth.service.PigUserDetailsService;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.UserFeignClient;
import com.qinweizhao.system.dto.UserAuthInfo;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户详细信息
 *
 * @author lengleng hccake
 */
@Slf4j
@Primary
@RequiredArgsConstructor
public class PigUserDetailsServiceImpl implements PigUserDetailsService {

	private final UserFeignClient userFeignClient;

	/**
	 * 用户名密码登录
	 * @param username 用户名
	 * @return
	 */
	@Override
	@SneakyThrows
	public UserDetails loadUserByUsername(String username) {
		// todo add cache

		R<UserAuthInfo> userAuthInfo = userFeignClient.getUserAuthInfo(username);

		return getUserDetails(userAuthInfo);
	}

	@Override
	public int getOrder() {
		return Integer.MIN_VALUE;
	}

}
