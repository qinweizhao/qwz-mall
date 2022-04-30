package com.qinweizhao.user.service.impl;


import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.entity.UmsMember;
import com.qinweizhao.user.mapper.UmsMemberMapper;
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
public class UmsMemberServiceImpl extends QwzServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Resource
    private UmsMemberMapper umsMemberMapper;

    /**
     * 查询会员列表
     *
     * @param umsMember 会员
     * @return 会员
     */
    @Override
    public List<UmsMember> selectMemberList(UmsMember umsMember) {
        return umsMemberMapper.selectMemberList(umsMember);
    }

}
