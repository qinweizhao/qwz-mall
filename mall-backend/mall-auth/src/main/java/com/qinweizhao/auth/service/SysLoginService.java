package com.qinweizhao.auth.service;

import com.qinweizhao.api.user.feign.MemberFeignClient;
import com.qinweizhao.auth.constant.SysTypeEnum;
import com.qinweizhao.common.core.constant.Constants;
import com.qinweizhao.common.core.constant.SecurityConstants;
import com.qinweizhao.common.core.constant.UserConstants;
import com.qinweizhao.common.core.enums.UserStatus;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.system.api.UserFeignClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 登录校验方法
 *
 * @author qinweizhao
 */
@Component
public class SysLoginService {

//    @Resource
//    private LogFeignClient logFeignClient;

    @Resource
    private UserFeignClient userFeignClient;

    @Resource
    private MemberFeignClient memberFeignClient;


    /**
     * 登录
     */
    public LoginUser login(String username, String password, String sysType) {
// todo
        this.preCheck(username, password);
        R<LoginUser> userResult;

        if (SysTypeEnum.APP.value().equals(sysType)) {
            // app 验证
            userResult = memberFeignClient.getMemberInfo(username, SecurityConstants.INNER);
        } else {
            // admin 验证
//            userResult = userFeignClient.getUserInfo(username, SecurityConstants.INNER);

        }


//
//        LoginUser userInfo = userResult.getData();

//
//        this.postCheck(username, password, sysType, userInfo);
//
//        recordLoginInfo(username, Constants.LOGIN_SUCCESS, "登录成功");
//
//        return userInfo;
        return null;
    }


    /**
     * 后置检查
     *
     * @param username  username
     * @param password  password
     * @param sysType   sysType
     * @param loginUser loginUser
     */
    private void postCheck(String username, String password, String sysType, LoginUser loginUser) {
        // 后台校验
        if (SysTypeEnum.ADMIN.value().equals(sysType)) {
            if (StringUtils.isNull(loginUser)) {
                recordLoginInfo(username, Constants.LOGIN_FAIL, "登录用户不存在");
                throw new ServiceException("登录用户：" + username + " 不存在");
            }
            if (UserStatus.DELETED.getCode().equals(loginUser.getDelFlag())) {
                recordLoginInfo(username, Constants.LOGIN_FAIL, "对不起，您的账号已被删除");
                throw new ServiceException("对不起，您的账号：" + username + " 已被删除");
            }
            if (UserStatus.DISABLE.getCode().equals(loginUser.getStatus())) {
                recordLoginInfo(username, Constants.LOGIN_FAIL, "用户已停用，请联系管理员");
                throw new ServiceException("对不起，您的账号：" + username + " 已停用");
            }
            if (!SecurityUtils.matchesPassword(password, loginUser.getPassword())) {
                recordLoginInfo(username, Constants.LOGIN_FAIL, "用户密码错误");
                throw new ServiceException("用户不存在/密码错误");
            }
        }

    }

    /**
     * 用户名或密码为空
     *
     * @param username username
     * @param password password
     */
    private void preCheck(String username, String password) {
        if (StringUtils.isAnyBlank(username, password)) {
            recordLoginInfo(username, Constants.LOGIN_FAIL, "用户/密码必须填写");
            throw new ServiceException("用户/密码必须填写");
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            recordLoginInfo(username, Constants.LOGIN_FAIL, "用户密码不在指定范围");
            throw new ServiceException("用户密码不在指定范围");
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            recordLoginInfo(username, Constants.LOGIN_FAIL, "用户名不在指定范围");
            throw new ServiceException("用户名不在指定范围");
        }
    }

    public void logout(String loginName) {
        recordLoginInfo(loginName, Constants.LOGOUT, "退出成功");
    }

    /**
     * 注册
     */
    public void register(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(username, password)) {
            throw new ServiceException("用户/密码必须填写");
        }
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            throw new ServiceException("账户长度必须在2到20个字符之间");
        }
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            throw new ServiceException("密码长度必须在5到20个字符之间");
        }
//  todo
//        // 注册用户信息
//        SysUserParam sysUser = new SysUserParam();
//        sysUser.setUserName(username);
//        sysUser.setNickName(username);
//        sysUser.setPassword(SecurityUtils.encryptPassword(password));
//        R<?> registerResult = userFeignClient.registerUserInfo(sysUser, SecurityConstants.INNER);

//        if (Constants.FAIL.equals(registerResult.getCode())) {
//            throw new ServiceException(registerResult.getMessage());
//        }
        recordLoginInfo(username, Constants.REGISTER, "注册成功");
    }

    /**
     * 记录登录信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息内容
     */
    public void recordLoginInfo(String username, String status, String message) {
//        SysLoginInfoParam loginInfo = new SysLoginInfoParam();
//        loginInfo.setUserName(username);
//        loginInfo.setIpaddr(IpUtils.getIpAddr(ServletUtils.getRequest()));
//        loginInfo.setMsg(message);
//        // 日志状态
//        if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER)) {
//            loginInfo.setStatus("0");
//        } else if (Constants.LOGIN_FAIL.equals(status)) {
//            loginInfo.setStatus("1");
//        }
//        logFeignClient.saveLoginInfo(loginInfo, SecurityConstants.INNER);
    }
}