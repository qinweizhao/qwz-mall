package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.UmsMember;

import java.util.List;

/**
 * 会员Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsMemberService {
    /**
     * 查询会员
     *
     * @param id 会员主键
     * @return 会员
     */
    UmsMember selectUmsMemberById(Long id);

    /**
     * 查询会员列表
     *
     * @param umsMember 会员
     * @return 会员集合
     */
    List<UmsMember> selectUmsMemberList(UmsMember umsMember);

    /**
     * 新增会员
     *
     * @param umsMember 会员
     * @return 结果
     */
    int insertUmsMember(UmsMember umsMember);

    /**
     * 修改会员
     *
     * @param umsMember 会员
     * @return 结果
     */
    int updateUmsMember(UmsMember umsMember);

    /**
     * 批量删除会员
     *
     * @param ids 需要删除的会员主键集合
     * @return 结果
     */
    int deleteUmsMemberByIds(Long[] ids);

    /**
     * 删除会员信息
     *
     * @param id 会员主键
     * @return 结果
     */
    int deleteUmsMemberById(Long id);
}
