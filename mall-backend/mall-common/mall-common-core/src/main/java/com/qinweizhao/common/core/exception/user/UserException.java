package com.qinweizhao.common.core.exception.user;


import com.qinweizhao.common.core.exception.BizException;

/**
 * 用户信息异常类
 *
 * @author ruoyi
 */
public class UserException extends BizException {
    private static final long serialVersionUID = 1L;

    public UserException(String errMsg) {
        super(errMsg);
    }
}
