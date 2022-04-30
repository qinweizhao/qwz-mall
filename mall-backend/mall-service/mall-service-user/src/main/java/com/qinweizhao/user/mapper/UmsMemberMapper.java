package com.qinweizhao.user.mapper;


import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.user.entity.UmsMember;

import java.util.List;

/**
 * 会员Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-29
 */
public interface UmsMemberMapper extends QwzBaseMapper<UmsMember> {


    /**
     * 查询会员列表
     *
     * @param umsMember 会员
     * @return 会员集合
     */
    List<UmsMember> selectMemberList(UmsMember umsMember);


}
