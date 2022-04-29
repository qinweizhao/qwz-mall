package com.qinweizhao.member.service;


import com.qinweizhao.member.entity.Member;

import java.util.List;

/**
 * 会员Service接口
 *
 * @author qinweizhao
 * @date 2022-04-29
 */
public interface MemberService {
    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    Member selectMemberById(Long id);

    /**
     * 查询会员列表
     *
     * @param Member 会员
     * @return 会员集合
     */
    List<Member> selectMemberList(Member Member);

    /**
     * 新增会员
     *
     * @param Member 会员
     * @return 结果
     */
    int insertMember(Member Member);

    /**
     * 修改会员
     *
     * @param Member 会员
     * @return 结果
     */
    int updateMember(Member Member);

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的会员主键集合
     * @return 结果
     */
    int deleteMemberByIds(Long[] ids);

    /**
     * 删除会员信息
     *
     * @param id 会员主键
     * @return 结果
     */
    int deleteMemberById(Long id);
}
