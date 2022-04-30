package com.qinweizhao.product.service;

import com.qinweizhao.product.domain.UmsMemberCollectSubject;

import java.util.List;

/**
 * 会员收藏的专题活动Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface IUmsMemberCollectSubjectService {
    /**
     * 查询会员收藏的专题活动
     *
     * @param id 会员收藏的专题活动主键
     * @return 会员收藏的专题活动
     */
    UmsMemberCollectSubject selectUmsMemberCollectSubjectById(Long id);

    /**
     * 查询会员收藏的专题活动列表
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 会员收藏的专题活动集合
     */
    List<UmsMemberCollectSubject> selectUmsMemberCollectSubjectList(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 新增会员收藏的专题活动
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    int insertUmsMemberCollectSubject(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 修改会员收藏的专题活动
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    int updateUmsMemberCollectSubject(UmsMemberCollectSubject umsMemberCollectSubject);

    /**
     * 批量删除会员收藏的专题活动
     *
     * @param ids 需要删除的会员收藏的专题活动主键集合
     * @return 结果
     */
    int deleteUmsMemberCollectSubjectByIds(Long[] ids);

    /**
     * 删除会员收藏的专题活动信息
     *
     * @param id 会员收藏的专题活动主键
     * @return 结果
     */
    int deleteUmsMemberCollectSubjectById(Long id);
}
