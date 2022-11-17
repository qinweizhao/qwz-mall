package com.qinweizhao.gateway.service.impl;

import com.google.code.kaptcha.Producer;
import com.qinweizhao.common.core.constant.Constants;
import com.qinweizhao.common.core.exception.CaptchaException;
import com.qinweizhao.common.core.utils.IdUtils;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.common.core.utils.sign.Base64;
import com.qinweizhao.component.redis.service.RedisService;
import com.qinweizhao.gateway.config.properties.CaptchaProperties;
import com.qinweizhao.gateway.service.ValidateCodeService;
import org.springframework.stereotype.Service;
import org.springframework.util.FastByteArrayOutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 验证码实现处理
 *
 * @author qinweizhao
 */
@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Resource
    private RedisService redisService;

    @Resource
    private CaptchaProperties captchaProperties;

    /**
     * 生成验证码
     */
    @Override
    public Map<String, Object> createCaptcha() throws CaptchaException {
        Map<String, Object> map = new LinkedHashMap<>();

        boolean captchaOnOff = captchaProperties.getEnabled();

        map.put("captchaOnOff", captchaOnOff);

        if (!captchaOnOff) {
            return map;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;

        String capStr;
        String code = null;
        BufferedImage image = null;

        String captchaType = captchaProperties.getType();
        // 生成验证码
        if ("math".equals(captchaType)) {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        } else if ("char".equals(captchaType)) {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisService.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();

        try {
            assert image != null;
            ImageIO.write(image, "jpg", os);
        } catch (Exception e) {
            throw new CaptchaException("生成验证码失败");
        }

        map.put("verifyCodeKey", uuid);
        map.put("verifyCodeImg", "data:image/png;base64," + Base64.encode(os.toByteArray()));

        return map;
    }

    /**
     * 校验验证码
     */
    @Override
    public void checkCapcha(String code, String uuid) throws CaptchaException {
        if (StringUtils.isEmpty(code)) {
            throw new CaptchaException("验证码不能为空");
        }
        if (StringUtils.isEmpty(uuid)) {
            throw new CaptchaException("验证码已失效");
        }
        String verifyKey = Constants.CAPTCHA_CODE_KEY + uuid;
        String captcha = redisService.getCacheObject(verifyKey);
        redisService.deleteObject(verifyKey);

        if (!code.equalsIgnoreCase(captcha)) {
            throw new CaptchaException("验证码错误");
        }
    }
}
