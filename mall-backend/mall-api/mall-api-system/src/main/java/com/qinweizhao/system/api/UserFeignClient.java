package com.qinweizhao.system.api;


import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.fallback.UserFeignFallbackClient;
import com.qinweizhao.system.dto.UserAuthInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "youlai-system", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users/{username}/authinfo")
    R<UserAuthInfo> getUserAuthInfo(@PathVariable String username);
}
