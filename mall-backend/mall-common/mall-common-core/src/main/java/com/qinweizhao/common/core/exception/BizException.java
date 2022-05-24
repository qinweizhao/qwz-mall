package com.qinweizhao.common.core.exception;

import com.qinweizhao.component.core.exception.BaseException;
import com.qinweizhao.component.core.response.SystemResultCodeEnum;

/**
 * BizException 业务异常
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public class BizException extends BaseException {

    public BizException(String errMsg) {
        super(SystemResultCodeEnum.SERVER_ERROR.getCode(), errMsg);
    }

    public BizException(String errMsg, Throwable e) {
        super(SystemResultCodeEnum.SERVER_ERROR.getCode(), errMsg, e);
    }

}