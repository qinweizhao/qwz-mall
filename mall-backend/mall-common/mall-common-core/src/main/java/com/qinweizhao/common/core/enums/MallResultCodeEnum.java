package com.qinweizhao.common.core.enums;

import com.qinweizhao.component.core.response.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 错误产生来源分为 A/B/C，
 * A 表示错误来源于用户，比如参数错误，用户安装版本过低，用户支付超时等问题；
 * B 表示错误来源于当前系统，往往是业务逻辑出错，或程序健壮性差等问题；
 * C 表示错误来源于第三方服务，比如 CDN 服务出错，消息投递超时等问题；
 * 四位数字编号从 0001 到 9999，大类之间的步长间距预留 100。
 *
 * @author qinweizhao
 * @since 2022/4/19
 */
@Getter
public enum MallResultCodeEnum implements ResultCode {

    /**
     * 数据库保存/更新异常
     */
    UPDATE_DATABASE_ERROR("90001", "Update Database {}Error"),
    FILE_SIZE_LIMIT("90001", "Update Database {}Error"),
    FILE_NAME_LENGTH_LIMIT("90001", "Update Database {}Error"),

    /**
     * 通用的逻辑校验异常
     */
    LOGIC_CHECK_ERROR("90004", "Logic Check Error"),

    /**
     * 恶意请求
     */
    MALICIOUS_REQUEST("90005", "Malicious Request"),

    /**
     * 文件上传异常
     */
    FILE_UPLOAD_ERROR("90006", "File Upload Error"),

    /**
     * 重复执行
     */
    REPEATED_EXECUTE("90007", "Repeated execute"),

    /**
     * 未知异常
     */
    UNKNOWN_ERROR("99999", "Unknown Error");


    private final String code;

    private final String message;

    MallResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
