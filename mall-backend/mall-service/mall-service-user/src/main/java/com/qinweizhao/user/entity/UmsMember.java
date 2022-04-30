package com.qinweizhao.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.qinweizhao.common.core.annotation.Excel;
import com.qinweizhao.common.core.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 会员对象 ums_member
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public class UmsMember extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 会员等级id
     */
    @Excel(name = "会员等级id")
    private Long levelId;

    /**
     * 用户名
     */
    @Excel(name = "用户名")
    private String username;

    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;

    /**
     * 昵称
     */
    @Excel(name = "昵称")
    private String nickname;

    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String mobile;

    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;

    /**
     * 头像
     */
    @Excel(name = "头像")
    private String header;

    /**
     * 性别
     */
    @Excel(name = "性别")
    private Long gender;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birth;

    /**
     * 所在城市
     */
    @Excel(name = "所在城市")
    private String city;

    /**
     * 职业
     */
    @Excel(name = "职业")
    private String job;

    /**
     * 个性签名
     */
    @Excel(name = "个性签名")
    private String sign;

    /**
     * 用户来源
     */
    @Excel(name = "用户来源")
    private Long sourceType;

    /**
     * 积分
     */
    @Excel(name = "积分")
    private Long integration;

    /**
     * 成长值
     */
    @Excel(name = "成长值")
    private Long growth;

    /**
     * 启用状态
     */
    @Excel(name = "启用状态")
    private Long status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    public Long getLevelId() {
        return levelId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    public void setGender(Long gender) {
        this.gender = gender;
    }

    public Long getGender() {
        return gender;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getBirth() {
        return birth;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public void setSourceType(Long sourceType) {
        this.sourceType = sourceType;
    }

    public Long getSourceType() {
        return sourceType;
    }

    public void setIntegration(Long integration) {
        this.integration = integration;
    }

    public Long getIntegration() {
        return integration;
    }

    public void setGrowth(Long growth) {
        this.growth = growth;
    }

    public Long getGrowth() {
        return growth;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("levelId", getLevelId())
                .append("username", getUsername())
                .append("password", getPassword())
                .append("nickname", getNickname())
                .append("mobile", getMobile())
                .append("email", getEmail())
                .append("header", getHeader())
                .append("gender", getGender())
                .append("birth", getBirth())
                .append("city", getCity())
                .append("job", getJob())
                .append("sign", getSign())
                .append("sourceType", getSourceType())
                .append("integration", getIntegration())
                .append("growth", getGrowth())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }
}
