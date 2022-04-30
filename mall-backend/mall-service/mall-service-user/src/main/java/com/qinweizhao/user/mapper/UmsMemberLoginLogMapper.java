package com.qinweizhao.user.mapper;

import com.qinweizhao.user.entity.UmsMemberLoginLog;

import java.util.List;

/**
 * 会员登录记录Mapper接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberLoginLogMapper {
    /**
     * 查询会员登录记录
     *
     * @param id 会员登录记录主键
     * @return 会员登录记录
     */
    public UmsMemberLoginLog selectUmsMemberLoginLogById(Long id);

    /**
     * 查询会员登录记录列表
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 会员登录记录集合
     */
    public List<UmsMemberLoginLog> selectUmsMemberLoginLogList(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 新增会员登录记录
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    public int insertUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 修改会员登录记录
     *
     * @param umsMemberLoginLog 会员登录记录
     * @return 结果
     */
    public int updateUmsMemberLoginLog(UmsMemberLoginLog umsMemberLoginLog);

    /**
     * 删除会员登录记录
     *
     * @param id 会员登录记录主键
     * @return 结果
     */
    public int deleteUmsMemberLoginLogById(Long id);

    /**
     * 批量删除会员登录记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUmsMemberLoginLogByIds(Long[] ids);
}
