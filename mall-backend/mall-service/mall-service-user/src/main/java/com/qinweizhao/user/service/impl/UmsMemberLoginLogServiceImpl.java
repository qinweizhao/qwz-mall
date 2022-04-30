package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.entity.UmsMemberLoginLog;
import com.qinweizhao.user.mapper.UmsMemberLoginLogMapper;
import com.qinweizhao.user.service.UmsMemberLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员登录记录Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsMemberLoginLogServiceImpl extends QwzServiceImpl<UmsMemberLoginLogMapper, UmsMemberLoginLog> implements UmsMemberLoginLogService {
    @Resource
    private UmsMemberLoginLogMapper umsMemberLoginLogMapper;

    /**
     * 查询会员登录记录列表
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 会员登录记录
     */
    @Override
    public List<UmsMemberLoginLog> selectUmsMemberLoginLogList(UmsMemberLoginLog umsMemberLoginLog) {
        return umsMemberLoginLogMapper.selectUmsMemberLoginLogList(umsMemberLoginLog);
    }

}
