package com.qinweizhao.common.core.exception.file;

import com.qinweizhao.common.core.enums.ErrorEnum;
import com.qinweizhao.common.core.exception.BizException;
import com.qinweizhao.component.core.response.ResultCode;
import com.qinweizhao.component.core.response.ResultCodeEnum;

/**
 * 文件名大小限制异常类
 *
 * @author ruoyi
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    // TODO
    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("upload.exceed.maxSize{}" + defaultMaxSize);
    }
}
