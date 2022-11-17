package com.qinweizhao.gateway.service;

import com.qinweizhao.common.core.exception.CaptchaException;

import java.util.Map;

/**
 * 验证码处理
 *
 * @author ruoyi
 */
public interface ValidateCodeService {

    /**
     * 生成验证码
     * @return R
     * @throws CaptchaException e
     */
    Map<String, Object> createCaptcha() throws CaptchaException;


    /**
     * 校验验证码
     * @param key key
     * @param value value
     * @throws CaptchaException e
     */
    void checkCapcha(String key, String value) throws CaptchaException;
}
