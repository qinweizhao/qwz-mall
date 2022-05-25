package com.qinweizhao.system.api.factory;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.RemoteUserService;
import com.qinweizhao.system.api.domain.SysUser;
import com.qinweizhao.system.api.model.LoginUser;
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
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        System.out.println("throwable======="+throwable);
        return new RemoteUserService() {
            @Override
            public R<LoginUser> getUserInfo(String username, String source) {
                // todo
//                return R.failure("获取用户失败:" + throwable.getMessage());
                return R.failure();
            }

            @Override
            public R<Boolean> registerUserInfo(SysUser sysUser, String source) {
//                return R.failure("注册用户失败:" + throwable.getMessage());
                return R.failure();
            }
        };
    }
}
