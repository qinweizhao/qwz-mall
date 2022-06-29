package com.qinweizhao.system.feign;

import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.factory.RemoteUserFallbackFactory;
import com.qinweizhao.system.model.dto.SysUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 用户服务
 *
 * @author qinweizhao
 */
@FeignClient(contextId = "userFeignClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface UserFeignClient {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source   请求来源
     * @return 结果
     */
    @GetMapping("/user/info/{username}")
    R<LoginUser> getUserInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 注册用户信息
     *
     * @param sysUser 用户信息
     * @param source  请求来源
     * @return 结果
     */
    @PostMapping("/user/register")
    R<Boolean> registerUserInfo(@RequestBody SysUserDTO sysUser, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
