package com.qinweizhao.system.api.factory;

import com.qinweizhao.component.log.SysOperLog;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.RemoteLogService;
import com.qinweizhao.system.api.domain.SysLogininfor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 日志服务降级处理
 *
 * @author ruoyi
 */
@Component
public class RemoteLogFallbackFactory implements FallbackFactory<RemoteLogService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteLogFallbackFactory.class);

    @Override
    public RemoteLogService create(Throwable throwable) {
        log.error("日志服务调用失败:{}", throwable.getMessage());
        return new RemoteLogService() {

            @Override
            public void saveLog(SysOperLog sysOperLog, String source) {
            }

            @Override
            public R<Boolean> saveLogininfor(SysLogininfor sysLogininfor, String source) {
                return null;
            }
        };

    }
}
