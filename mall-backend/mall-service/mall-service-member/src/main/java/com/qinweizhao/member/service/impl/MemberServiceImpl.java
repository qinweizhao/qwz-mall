package com.qinweizhao.member.service.impl;


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
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberMapper memberMapper;

    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    @Override
    public Member selectMemberById(Long id) {
        return memberMapper.selectMemberById(id);
    }

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

    /**
     * 新增会员
     *
     * @param member 会员
     * @return 结果
     */
    @Override
    public int insertMember(Member member) {
        return memberMapper.insertMember(member);
    }

    /**
     * 修改会员
     *
     * @param member 会员
     * @return 结果
     */
    @Override
    public int updateMember(Member member) {
        return memberMapper.updateMember(member);
    }

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的会员主键
     * @return 结果
     */
    @Override
    public int deleteMemberByIds(Long[] ids) {
        return memberMapper.deleteMemberByIds(ids);
    }

    /**
     * 删除会员信息
     *
     * @param id 会员主键
     * @return 结果
     */
    @Override
    public int deleteMemberById(Long id) {
        return memberMapper.deleteMemberById(id);
    }
}
