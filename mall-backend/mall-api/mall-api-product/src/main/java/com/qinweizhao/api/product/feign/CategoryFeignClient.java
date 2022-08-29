package com.qinweizhao.api.product.feign;

import com.qinweizhao.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author qinweizhao
 * @since 2022/6/14
 */
@FeignClient(contextId = "categoryFeignClient", value = ServiceNameConstants.USER_SERVICE)
public interface CategoryFeignClient {

//    /**
//     * 通过用户名查询用户信息
//     *
//     * @param username 用户名LoginUser
//     * @param source   请求来源
//     * @return 结果
//     */
//    @GetMapping("/member/info/{username}")
//    R<Set<Long>> getMemberInfo(@PathVariable("username") String username, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
