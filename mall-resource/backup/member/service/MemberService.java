package com.qinweizhao.user.service;


import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.entity.Member;

import java.util.List;

/**
 * 会员Service接口
 *
 * @author qinweizhao
 * @date 2022-04-29
 */
public interface MemberService extends QwzService<Member> {

    /**
     * 查询会员列表
     *
     * @param member 会员
     * @return 会员集合
     */
    List<Member> selectMemberList(Member member);

}
