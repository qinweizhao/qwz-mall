package com.qinweizhao.api.product.feign;

import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author qinweizhao
 * @since 2022/9/2
 */
@FeignClient(contextId = "testFeignClient", value = ServiceNameConstants.PRODUCT_SERVICE)
public interface TestFeignClient {

        /**
     * 通过用户名查询用户信息
     *
     * @param source   请求来源
     * @return 结果
     */
    @GetMapping("/admin/attr/test")
    Object getMemberInfo(@RequestHeader(SecurityConstants.FROM_SOURCE) String source);

}
