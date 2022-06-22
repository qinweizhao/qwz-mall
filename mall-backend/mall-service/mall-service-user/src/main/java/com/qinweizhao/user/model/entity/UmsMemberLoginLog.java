package com.qinweizhao.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.component.core.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会员登录记录对象 ums_member_login_log
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("ums_member_login_log")
public class UmsMemberLoginLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * member_id
     */
    @Excel(name = "member_id")
    private Long memberId;

    /**
     * ip
     */
    @Excel(name = "ip")
    private String ip;

    /**
     * city
     */
    @Excel(name = "city")
    private String city;

    /**
     * 登录类型[1-web，2-app]
     */
    @Excel(name = "登录类型[1-web，2-app]")
    private Integer loginType;

}
