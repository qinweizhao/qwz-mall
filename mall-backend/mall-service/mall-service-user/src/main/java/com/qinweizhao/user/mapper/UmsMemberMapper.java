package com.qinweizhao.user.mapper;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;
import com.qinweizhao.user.model.entity.UmsMember;
import com.qinweizhao.user.model.param.MemberPageParam;

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


    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return PageResult
     */
    default PageResult<UmsMember> selectPage(MemberPageParam pageParam){
        return selectPage(pageParam, new QwzLambdaQueryWrapper<UmsMember>()
                .likeIfPresent(UmsMember::getNickname, pageParam.getNickname())
                .likeIfPresent(UmsMember::getUsername, pageParam.getUsername())
                .eqIfPresent(UmsMember::getStatus, pageParam.getStatus())
                .orderByDesc(UmsMember::getId));
    }
}
