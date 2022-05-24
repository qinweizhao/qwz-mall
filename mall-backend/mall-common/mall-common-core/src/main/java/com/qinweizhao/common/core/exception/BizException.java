package com.qinweizhao.common.core.exception;

import com.qinweizhao.common.core.enums.ErrorEnum;
import com.qinweizhao.component.core.exception.BaseException;
import com.qinweizhao.component.core.response.ResultCodeEnum;

/**
 * BizException 业务异常
 *
 * @author qinweizhao
 * @since 2022/4/12
 */
public class BizException extends BaseException {

    public BizException(String errMag) {
        super(new ErrorEnum(ResultCodeEnum.FAILED.getCode(), errMag));

    }


    public BizException(Throwable e, String errMag) {
        super(new ErrorEnum(ResultCodeEnum.FAILED.getCode(), errMag), e);
    }

}