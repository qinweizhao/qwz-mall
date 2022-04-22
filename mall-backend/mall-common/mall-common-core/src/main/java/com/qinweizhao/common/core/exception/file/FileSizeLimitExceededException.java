package com.qinweizhao.common.core.exception.file;

/**
 * 文件名大小限制异常类
 *
 * @author ruoyi
 */
public class FileSizeLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    // TODO
    public FileSizeLimitExceededException(long defaultMaxSize) {
        super("500", "upload.exceed.maxSize{}" + defaultMaxSize);
    }
}
