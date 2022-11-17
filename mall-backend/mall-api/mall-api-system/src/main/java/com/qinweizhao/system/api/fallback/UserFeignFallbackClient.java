package com.qinweizhao.system.api.fallback;


import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.UserFeignClient;
import com.qinweizhao.system.dto.UserAuthDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author haoxr
 * @createTime 2021/4/24 21:30
 */
@Component
@Slf4j
public class UserFeignFallbackClient implements UserFeignClient {

    @Override
    public R<UserAuthDTO> getUserByUsername(String username) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return R.failure();
    }
}
