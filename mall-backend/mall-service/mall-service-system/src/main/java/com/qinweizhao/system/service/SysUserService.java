package com.qinweizhao.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qinweizhao.system.dto.UserAuthDTO;
import com.qinweizhao.system.pojo.dto.UserImportDTO;
import com.qinweizhao.system.pojo.entity.SysUser;
import com.qinweizhao.system.pojo.form.UserForm;
import com.qinweizhao.system.pojo.query.UserPageQuery;
import com.qinweizhao.system.pojo.vo.user.LoginUserVO;
import com.qinweizhao.system.pojo.vo.user.UserDetailVO;
import com.qinweizhao.system.pojo.vo.user.UserExportVO;
import com.qinweizhao.system.pojo.vo.user.UserVO;

import java.io.IOException;
import java.util.List;

/**
 * 用户业务接口
 *
 * @author haoxr
 * @date 2022/1/14
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 用户分页列表
     *
     * @return
     */
    IPage<UserVO> listUserPages(UserPageQuery queryParams);


    /**
     * 获取用户详情
     *
     * @param userId
     * @return
     */
    UserDetailVO getUserDetail(Long userId);


    /**
     * 新增用户
     *
     * @param userForm 用户表单对象
     * @return
     */
    boolean saveUser(UserForm userForm);

    /**
     * 修改用户
     *
     * @param userId   用户ID
     * @param userForm 用户表单对象
     * @return
     */
    boolean updateUser(Long userId, UserForm userForm);


    /**
     * 删除用户
     *
     * @param idsStr 用户ID，多个以英文逗号(,)分割
     * @return
     */
    boolean deleteUsers(String idsStr);


    /**
     * 修改用户密码
     *
     * @param userId   用户ID
     * @param password 用户密码
     * @return
     */
    boolean updateUserPassword(Long userId, String password);

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    UserAuthDTO getAuthInfoByUsername(String username);

    /**
     * 导入用户
     *
     * @param userImportDTO
     * @return
     */
    String importUsers(UserImportDTO userImportDTO) throws IOException;

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    List<UserExportVO> listExportUsers(UserPageQuery queryParams);


    /**
     * 获取登录用户信息
     *
     * @return
     */
    LoginUserVO getLoginUserInfo();
}
