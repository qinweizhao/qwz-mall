package com.qinweizhao.system.feign;

import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.SysOperLog;
import com.qinweizhao.component.log.service.QwzLogService;
import com.qinweizhao.system.factory.RemoteLogFallbackFactory;
import com.qinweizhao.system.model.param.SysLoginInfoParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * 日志服务
 *
 * @author qinweizhao
 */
@FeignClient(contextId = "logFeignClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
public interface LogFeignClient extends QwzLogService {

    /**
     * 保存系统日志
     *
     * @param sysOperLog 日志实体
     * @param source     请求来源
     */
    @Override
    @PostMapping("/operlog")
    void saveLog(@RequestBody SysOperLog sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);

    /**
     * 保存访问记录
     *
     * @param sysLoginInfoParam 访问实体
     * @param source            请求来源
     * @return 结果
     */
    @PostMapping("/logininfor")
    R<Boolean> saveLoginInfo(@RequestBody SysLoginInfoParam sysLoginInfoParam, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
