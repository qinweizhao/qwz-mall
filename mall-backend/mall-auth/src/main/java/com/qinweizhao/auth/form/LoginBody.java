package com.qinweizhao.auth.form;

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
     * sysType 参考SysTypeEnum
     */
    protected Integer sysType;
}
