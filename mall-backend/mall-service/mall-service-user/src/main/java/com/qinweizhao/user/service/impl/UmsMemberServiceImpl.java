package com.qinweizhao.user.service.impl;


import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.entity.Member;
import com.qinweizhao.user.mapper.MemberMapper;
import com.qinweizhao.user.service.UmsMemberService;
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
public class UmsMemberServiceImpl extends QwzServiceImpl<MemberMapper, Member> implements UmsMemberService {

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
