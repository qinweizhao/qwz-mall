package com.qinweizhao.user.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.user.model.entity.UmsMemberLoginLog;

import java.util.List;

/**
 * 会员登录记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberLoginLogMapper extends QwzBaseMapper<UmsMemberLoginLog> {


    /**
     * 查询会员登录记录列表
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 会员登录记录集合
     */
    List<UmsMemberLoginLog> selectUmsMemberLoginLogList(UmsMemberLoginLog umsMemberLoginLog);


}
