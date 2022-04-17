package com.qinweizhao.common.core.exception.user;


import com.qinweizhao.component.exception.base.BaseException;

/**
 * 用户信息异常类
 *
 * @author ruoyi
 */
public class UserException extends BaseException {
    private static final long serialVersionUID = 1L;

    // TODO
    public UserException(String errMsg) {
        super(500, errMsg);
    }
}
