package com.qinweizhao.common.core.exception.file;

/**
 * 文件名称超长限制异常类
 *
 * @author ruoyi
 */
public class FileNameLengthLimitExceededException extends FileException {
    private static final long serialVersionUID = 1L;

    // TODO
    public FileNameLengthLimitExceededException(int defaultFileNameLength) {
        super(500, "upload.filename.exceed.length{}" + defaultFileNameLength);
    }
}
