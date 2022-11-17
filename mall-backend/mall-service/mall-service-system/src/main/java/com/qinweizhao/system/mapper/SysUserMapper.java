package com.qinweizhao.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qinweizhao.system.dto.UserAuthDTO;
import com.qinweizhao.system.pojo.DataPermission;
import com.qinweizhao.system.pojo.entity.SysUser;
import com.qinweizhao.system.pojo.po.UserDetailPO;
import com.qinweizhao.system.pojo.po.UserPO;
import com.qinweizhao.system.pojo.query.UserPageQuery;
import com.qinweizhao.system.pojo.vo.user.UserExportVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户持久层
 *
 * @author haoxr
 * @date 2022/1/14
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 获取用户分页列表
     *
     * @param page
     * @param queryParams 查询参数
     * @return
     */
    @DataPermission(deptAlias = "d")
    Page<UserPO> listUserPages(Page<UserPO> page, UserPageQuery queryParams);

    /**
     * 获取用户表单详情
     *
     * @param userId 用户ID
     * @return
     */
    UserDetailPO getUserDetail(Long userId);

    /**
     * 根据用户名获取认证信息
     *
     * @param username
     * @return
     */
    UserAuthDTO getAuthInfoByUsername(String username);

    /**
     * 获取导出用户列表
     *
     * @param queryParams
     * @return
     */
    @DataPermission(deptAlias = "d")
    List<UserExportVO> listExportUsers(UserPageQuery queryParams);
}
