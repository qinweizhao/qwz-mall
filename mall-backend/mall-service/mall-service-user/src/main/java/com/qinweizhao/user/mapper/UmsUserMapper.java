package com.qinweizhao.user.mapper;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.component.mybatis.query.QwzLambdaQueryWrapper;
import com.qinweizhao.user.model.entity.UmsUser;
import com.qinweizhao.user.model.param.MemberPageParam;

import java.util.List;

/**
 * 会员Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-29
 */
public interface UmsUserMapper extends QwzMapper<UmsUser> {


    /**
     * 查询会员列表
     *
     * @param umsUser 会员
     * @return 会员集合
     */
    List<UmsUser> selectMemberList(UmsUser umsUser);


    /**
     * 查询分页信息
     * @param pageParam pageParam
     * @return PageResult
     */
    default PageResult<UmsUser> selectPage(MemberPageParam pageParam){
        return selectPage(pageParam, new QwzLambdaQueryWrapper<UmsUser>()
                .likeIfPresent(UmsUser::getNickname, pageParam.getNickname())
                .likeIfPresent(UmsUser::getUsername, pageParam.getUsername())
                .eqIfPresent(UmsUser::getStatus, pageParam.getStatus())
                .orderByDesc(UmsUser::getId));
    }
}
