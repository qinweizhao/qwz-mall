package com.qinweizhao.api.user.feign;

import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.component.core.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author qinweizhao
 * @since 2022/6/14
 */
@FeignClient(contextId = "memberFeignClient", value = ServiceNameConstants.USER_SERVICE)
public interface MemberFeignClient {

    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @param source   请求来源
     * @return 结果
     */
    @GetMapping("/member/{username}")
    R<LoginUser> getMemberByUsername(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
