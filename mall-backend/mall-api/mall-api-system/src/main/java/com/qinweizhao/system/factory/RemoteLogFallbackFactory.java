package com.qinweizhao.system.factory;

import com.qinweizhao.system.feign.LogFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;

/**
 * 日志服务降级处理
 *
 * @author ruoyi
 */
// @Component
public class RemoteLogFallbackFactory implements FallbackFactory<LogFeignClient> {
    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);

    @Override
    public LogFeignClient create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
//        return new LogFeignClient() {
//
//            @Override
//            public void saveLog(SysOperLog sysOperLog, String source) {
//            }
//
//            @Override
//            public R<Boolean> saveLoginInfo(SysLoginInfoParam sysLoginInfoParam, String source) {
//                return null;
//            }
//        };

        return null;

    }
}
