package com.qinweizhao.auth.service;

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
     * @return R
     * @throws IOException e
     * @throws CaptchaException e
     */
    R<Object> createCaptcha() throws IOException, CaptchaException;


    /**
     * 校验验证码
     * @param key key
     * @param value value
     * @throws CaptchaException e
     */
    void checkCapcha(String key, String value) throws CaptchaException;
}
