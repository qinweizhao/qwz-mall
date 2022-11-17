package com.qinweizhao.system.feign;

/**
 * 日志服务
 *
 * @author qinweizhao
 */
// @FeignClient(contextId = "logFeignClient", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteLogFallbackFactory.class)
//public interface LogFeignClient extends QwzLogService {
public interface LogFeignClient {

//    /**
//     * 保存系统日志
//     *
//     * @param sysOperLog 日志实体
//     * @param source     请求来源
//     */
//    @Override
//    @PostMapping("/operlog")
//    void saveLog(@RequestBody SysOperLog sysOperLog, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
//
//    /**
//     * 保存访问记录
//     *
//     * @param sysLoginInfoParam 访问实体
//     * @param source            请求来源
//     * @return 结果
//     */
//    @PostMapping("/logininfor")
//    R<Boolean> saveLoginInfo(@RequestBody SysLoginInfoParam sysLoginInfoParam, @RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
