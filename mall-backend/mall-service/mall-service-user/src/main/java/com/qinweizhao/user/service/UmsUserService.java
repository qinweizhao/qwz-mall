package com.qinweizhao.user.service;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.dto.UserDTO;
import com.qinweizhao.user.model.entity.UmsUser;
import com.qinweizhao.user.model.param.MemberPageParam;

import java.util.List;

/**
 * 会员Service接口
 *
 * @author qinweizhao
 * @date 2022-04-29
 */
public interface UmsUserService extends QwzService<UmsUser> {

    /**
     * 查询会员列表
     *
     * @param umsUser 会员
     * @return 会员集合
     */
    List<UmsUser> selectMemberList(UmsUser umsUser);

    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return List
     */
    PageResult<UmsUser> page(MemberPageParam pageParam);

    /**
     * 查询会员（登陆使用）
     * @param username username
     * @return MemberDTO
     */
    UserDTO getByUsername(String username);
}
