package com.qinweizhao.gateway.service;

import com.qinweizhao.common.core.exception.CaptchaException;
import com.qinweizhao.component.core.response.R;

import java.io.IOException;

/**
 * 验证码处理
 *
 * @author ruoyi
 */
public interface ValidateCodeService {
    /**
     * 生成验证码
     */
    R<Object> createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    void checkCapcha(String key, String value) throws CaptchaException;
}
