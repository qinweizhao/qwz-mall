package com.qinweizhao.common.core.enums;

import com.qinweizhao.component.modle.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

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
@AllArgsConstructor
public enum ErrorEnum implements ResultCode {

    /**
     * 一级宏观错误码
     * 用户
     */
    USER_ERROR("A0001", "用户端错误"),

    USER_UPLOAD_FILE_EXCEPTION("A0700", "用户上传文件异常"),


    /**
     * 一级宏观错误码
     * 当前系统
     */
    SYSTEM_RUN_ERROR("B0001", "系统执行出错"),


    /**
     * 中间件服务出错
     */
    REMOTE_SERVER_ERROR("C0001", "调用第三方服务出错");

    private final String code;

    private final String message;

}
