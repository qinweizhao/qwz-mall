package com.qinweizhao.auth.service;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ArrayUtil;
import com.qinweizhao.auth.model.PigUser;
import com.qinweizhao.common.core.SecurityConstants;
import com.qinweizhao.common.core.constant.CommonConstants;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.dto.UserAuthInfo;
import org.springframework.core.Ordered;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lengleng
 * @date 2021/12/21
 */
public interface PigUserDetailsService extends UserDetailsService, Ordered {

	/**
	 * 是否支持此客户端校验
	 * @param clientId 目标客户端
	 * @return true/false
	 */
	default boolean support(String clientId, String grantType) {
		return true;
	}

	/**
	 * 排序值 默认取最大的
	 * @return 排序值
	 */
	default int getOrder() {
		return 0;
	}

	/**
	 * 构建userdetails
	 * @param result 用户信息
	 * @return UserDetails
	 */
	default UserDetails getUserDetails(R<UserAuthInfo> result) {
		UserAuthInfo info = result.getData();
		Set<String> dbAuthsSet = new HashSet<>();
		Set<String> roles = info.getRoles();
		if (ArrayUtil.isNotEmpty(info.getRoles())) {
			// 获取角色
			roles.forEach(role -> dbAuthsSet.add(SecurityConstants.ROLE + role));
			// 获取资源
			dbAuthsSet.addAll(info.getPerms());

		}

		Collection<GrantedAuthority> authorities = AuthorityUtils
				.createAuthorityList(dbAuthsSet.toArray(new String[0]));


		// 构造security用户
		return new PigUser(info.getUserId(), info.getDeptId(), info.getUsername(),
				SecurityConstants.BCRYPT + info.getPassword(), "13512121212", true, true, true,
				CharSequenceUtil.equals(String.valueOf(info.getStatus()), CommonConstants.STATUS_NORMAL), authorities);
	}

	/**
	 * 通过用户实体查询
	 * @param pigUser user
	 * @return
	 */
	default UserDetails loadUserByUser(PigUser pigUser) {
		return this.loadUserByUsername(pigUser.getUsername());
	}

}
