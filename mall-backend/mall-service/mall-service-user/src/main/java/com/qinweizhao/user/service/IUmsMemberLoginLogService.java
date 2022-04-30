package com.qinweizhao.user.service;

import com.qinweizhao.user.entity.UmsMemberLoginLog;

import java.util.List;

/**
 * 会员登录记录Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsMemberLoginLogService {
    /**
     * 查询会员登录记录
     *
     * @param id 会员登录记录主键
     * @return 会员登录记录
     */
    UmsMemberLoginLog selectUmsMemberLoginLogById(Long id);

    /**
     * 查询会员登录记录列表
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 会员登录记录集合
     */
    List<UmsMemberLoginLog> selectUmsMemberLoginLogList(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 新增会员登录记录
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    int insertUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 修改会员登录记录
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    int updateUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 批量删除会员登录记录
     *
     * @param ids 需要删除的会员登录记录主键集合
     * @return 结果
     */
    int deleteUmsMemberLoginLogByIds(Long[] ids);

    /**
     * 删除会员登录记录信息
     *
     * @param id 会员登录记录主键
     * @return 结果
     */
    int deleteUmsMemberLoginLogById(Long id);
}
