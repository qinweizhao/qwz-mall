package com.qinweizhao.auth.model;

import lombok.Data;


/**
 * 用户登录对象
 *
 * @author qinweizhao
 */
@Data
public class LoginBody {
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * sysType 参考SysTypeEnum
     */
    protected String sysType;
}
