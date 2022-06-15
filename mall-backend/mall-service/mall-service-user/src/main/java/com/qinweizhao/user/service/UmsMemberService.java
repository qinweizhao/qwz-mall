package com.qinweizhao.user.service;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.dto.MemberDTO;
import com.qinweizhao.user.model.entity.UmsMember;
import com.qinweizhao.user.model.param.MemberPageParam;

import java.util.List;

/**
 * 会员Service接口
 *
 * @author qinweizhao
 * @date 2022-04-29
 */
public interface UmsMemberService extends QwzService<UmsMember> {

    /**
     * 查询会员列表
     *
     * @param umsMember 会员
     * @return 会员集合
     */
    List<UmsMember> selectMemberList(UmsMember umsMember);

    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return List
     */
    PageResult<UmsMember> page(MemberPageParam pageParam);

    /**
     * 查询会员（登陆使用）
     * @param username username
     * @return MemberDTO
     */
    MemberDTO getByUsername(String username);
}
