package com.qinweizhao.system.factory;

import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.feign.UserFeignClient;
import com.qinweizhao.system.model.dto.SysUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<UserFeignClient> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        System.out.println("throwable======="+throwable);
        return new UserFeignClient() {
            @Override
            public R<LoginUser> getUserInfo(String username, String source) {
                // todo
//                return R.failure("获取用户失败:" + throwable.getMessage());
                return R.failure();
            }

            @Override
            public R<Boolean> registerUserInfo(SysUserDTO sysUser, String source) {
//                return R.failure("注册用户失败:" + throwable.getMessage());
                return R.failure();
            }
        };
    }
}
