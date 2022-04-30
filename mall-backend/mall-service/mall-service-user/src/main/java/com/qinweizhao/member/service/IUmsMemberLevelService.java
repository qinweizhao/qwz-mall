package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.UmsMemberLevel;

import java.util.List;

/**
 * 会员等级Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsMemberLevelService {
    /**
     * 查询会员等级
     *
     * @param id 会员等级主键
     * @return 会员等级
     */
    UmsMemberLevel selectUmsMemberLevelById(Long id);

    /**
     * 查询会员等级列表
     *
     * @param umsMemberLevel 会员等级
     * @return 会员等级集合
     */
    List<UmsMemberLevel> selectUmsMemberLevelList(UmsMemberLevel umsMemberLevel);

    /**
     * 新增会员等级
     *
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    int insertUmsMemberLevel(UmsMemberLevel umsMemberLevel);

    /**
     * 修改会员等级
     *
     * @param umsMemberLevel 会员等级
     * @return 结果
     */
    int updateUmsMemberLevel(UmsMemberLevel umsMemberLevel);

    /**
     * 批量删除会员等级
     *
     * @param ids 需要删除的会员等级主键集合
     * @return 结果
     */
    int deleteUmsMemberLevelByIds(Long[] ids);

    /**
     * 删除会员等级信息
     *
     * @param id 会员等级主键
     * @return 结果
     */
    int deleteUmsMemberLevelById(Long id);
}
