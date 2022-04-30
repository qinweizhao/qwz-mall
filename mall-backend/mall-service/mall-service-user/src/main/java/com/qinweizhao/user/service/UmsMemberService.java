package com.qinweizhao.user.service;


import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.entity.UmsMember;

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

}
