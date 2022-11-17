package com.qinweizhao.auth.controller;


import com.qinweizhao.auth.constant.SysTypeEnum;
import com.qinweizhao.auth.model.LoginBody;
import com.qinweizhao.auth.model.RegisterBody;
import com.qinweizhao.auth.service.SysLoginService;
import com.qinweizhao.auth.service.ValidateCodeService;
import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.common.core.utils.JwtUtils;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.common.security.auth.AuthUtil;
import com.qinweizhao.common.security.service.TokenService;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.component.core.response.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * token 控制
 *
 * @author qinweizhao
 */
@RestController
public class AuthController {

    @Resource
    private TokenService tokenService;

    @Resource
    private SysLoginService sysLoginService;

    @Resource
    private ValidateCodeService validateCodeService;


    @GetMapping("/captcha")
    public R<Object> code() {
        Map<String, Object> captcha = validateCodeService.createCaptcha();
        return R.success(captcha);
    }

    @PostMapping("/login")
    public R<Map<String, Object>> login(@RequestBody LoginBody form) {
        String sysType = form.getSysType();
        if (SysTypeEnum.ADMIN.value().equals(sysType)){
            // 校验验证码
            validateCodeService.checkCapcha(form.getCode(), form.getUuid());
        }
        // 用户登录
        LoginUser userInfo = sysLoginService.login(form.getUsername(), form.getPassword(), form.getSysType());
        // 获取登录token
        return R.success(tokenService.createToken(userInfo));
    }

    @DeleteMapping("/logout")
    public R<?> logout(HttpServletRequest request) {
        String token = SecurityUtils.getToken(request);
        if (StringUtils.isNotEmpty(token)) {
            String username = JwtUtils.getUserName(token);
            // 删除用户缓存记录
            AuthUtil.logoutByToken(token);
            // 记录用户退出日志
            sysLoginService.logout(username);
        }
        return R.success();
    }

    @PostMapping("refresh")
    public R<?> refresh(HttpServletRequest request) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if (StringUtils.isNotNull(loginUser)) {
            // 刷新令牌有效期
            tokenService.refreshToken(loginUser);
            return R.success();
        }
        return R.success();
    }

    @PostMapping("register")
    public R<?> register(@RequestBody RegisterBody registerBody) {
        // 用户注册
        sysLoginService.register(registerBody.getUsername(), registerBody.getPassword());
        return R.success();
    }
}
