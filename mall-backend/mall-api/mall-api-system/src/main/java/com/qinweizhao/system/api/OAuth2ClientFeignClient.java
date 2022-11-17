package com.qinweizhao.system.api;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.dto.OAuth2ClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "youlai-admin", contextId = "oauth-client")
public interface OAuth2ClientFeignClient {

    @GetMapping("/api/v1/oauth-clients/getOAuth2ClientById")
    R<OAuth2ClientDTO> getOAuth2ClientById(@RequestParam String clientId);
}
