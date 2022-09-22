package com.qinweizhao.user.service.impl;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.convert.MemberConvert;
import com.qinweizhao.user.mapper.UmsUserMapper;
import com.qinweizhao.user.model.dto.UserDTO;
import com.qinweizhao.user.model.entity.UmsUser;
import com.qinweizhao.user.model.param.MemberPageParam;
import com.qinweizhao.user.service.UmsUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 会员Service业务层处理
 *
 * @author qinweizhao
 * @since 2022-04-29
 */
@Service
public class UmsUserServiceImpl extends QwzServiceImpl<UmsUserMapper, UmsUser> implements UmsUserService {

    @Override
    public List<UmsUser> selectMemberList(UmsUser umsUser) {
        return this.baseMapper.selectMemberList(umsUser);
    }

    @Override
    public PageResult<UmsUser> page(MemberPageParam pageParam) {
        return this.baseMapper.selectPage(pageParam);
    }

    @Override
    public UserDTO getByUsername(String username) {
        UmsUser umsUser = this.baseMapper.selectOne(UmsUser::getUsername, username);
        return MemberConvert.INSTANCE.convert(umsUser);
    }
}
