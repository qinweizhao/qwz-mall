package com.qinweizhao.system.api;


import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.fallback.UserFeignFallbackClient;
import com.qinweizhao.system.dto.UserAuthDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = ServiceNameConstants.SYSTEM_SERVICE, fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    R<UserAuthDTO> getUserByUsername(@PathVariable(value = "username") String username);
}
