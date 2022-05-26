package com.qinweizhao.user.model.param;

import com.qinweizhao.component.core.request.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author qinweizhao
 * @since 2022/5/26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MemberPageParam extends PageParam {


    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 用户来源
     */
    private Long sourceType;

    /**
     * 启用状态
     */
    private Long status;

}
