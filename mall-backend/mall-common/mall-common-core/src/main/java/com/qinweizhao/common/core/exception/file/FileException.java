package com.qinweizhao.common.core.exception.file;


import com.qinweizhao.component.exception.base.BaseException;

/**
 * 文件信息异常类
 *
 * @author qinweizhao
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(int code, String errMag) {
        super(code, errMag);
    }

}
