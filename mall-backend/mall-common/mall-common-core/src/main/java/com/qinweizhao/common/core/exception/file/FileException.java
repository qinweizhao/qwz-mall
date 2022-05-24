package com.qinweizhao.common.core.exception.file;


import com.qinweizhao.common.core.enums.ErrorEnum;
import com.qinweizhao.common.core.exception.BizException;
import com.qinweizhao.component.core.exception.BaseException;
import com.qinweizhao.component.core.response.ResultCodeEnum;

/**
 * 文件信息异常类
 *
 * @author qinweizhao
 */
public class FileException extends BizException {
    private static final long serialVersionUID = 1L;

    public FileException(String errMag) {
        super(errMag);
    }

}
