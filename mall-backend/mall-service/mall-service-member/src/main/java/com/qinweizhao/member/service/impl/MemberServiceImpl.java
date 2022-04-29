package com.qinweizhao.member.service.impl;


import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.member.entity.Member;
import com.qinweizhao.member.mapper.MemberMapper;
import com.qinweizhao.member.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员Service业务层处理
 *
 * @author qinweizhao
 * @since 2022-04-29
 */
@Service
public class MemberServiceImpl extends QwzServiceImpl<MemberMapper, Member> implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    /**
     * 查询会员列表
     *
     * @param member 会员
     * @return 会员
     */
    @Override
    public List<Member> selectMemberList(Member member) {
        return memberMapper.selectMemberList(member);
    }

}
