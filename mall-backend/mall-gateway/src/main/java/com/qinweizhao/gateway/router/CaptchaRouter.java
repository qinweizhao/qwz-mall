package com.qinweizhao.gateway.router;


import com.qinweizhao.gateway.handler.CaptchaHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * 验证码路由
 *
 * @author qinweizhao
 * @date 2022/5/17
 */
@Configuration
public class CaptchaRouter {

    @Bean
    public RouterFunction<ServerResponse> captchaRouterFunction(CaptchaHandler captchaHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/captcha").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), captchaHandler);
    }

}
