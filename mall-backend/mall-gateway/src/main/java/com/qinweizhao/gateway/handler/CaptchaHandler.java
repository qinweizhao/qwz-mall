package com.qinweizhao.gateway.handler;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.gateway.service.ValidateCodeService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

/**
 * 验证码处理器
 *
 * @author qinweizhao
 * @date 2021/10/4
 */
@Component
@RequiredArgsConstructor
public class CaptchaHandler implements HandlerFunction<ServerResponse> {

    private final ValidateCodeService validateCodeService;


    @Override
    @NonNull
    public Mono<ServerResponse> handle(@NonNull ServerRequest request) {

        Map<String, Object> captcha = validateCodeService.createCaptcha();

        return ServerResponse.ok().body(BodyInserters.fromValue(R.success(captcha)));
    }
}
