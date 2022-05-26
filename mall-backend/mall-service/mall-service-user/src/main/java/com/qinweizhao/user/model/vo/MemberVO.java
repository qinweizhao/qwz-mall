package com.qinweizhao.user.model.vo;

import lombok.Data;

import java.util.Date;


/**
 * 会员对象 mms_member
 *
 * @author qinweizhao
 * @since 2022-04-29
 */
@Data
public class MemberVO {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 会员等级id
     */
    private Long levelId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String header;

    /**
     * 性别
     */
    private Long gender;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 职业
     */
    private String job;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 用户来源
     */
    private Long sourceType;

    /**
     * 积分
     */
    private Long integration;

    /**
     * 成长值
     */
    private Long growth;

    /**
     * 启用状态
     */
    private Long status;


}
