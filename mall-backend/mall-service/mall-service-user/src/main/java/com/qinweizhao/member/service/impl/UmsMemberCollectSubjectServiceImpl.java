package com.qinweizhao.product.service.impl;

import com.qinweizhao.product.domain.UmsMemberCollectSubject;
import com.qinweizhao.product.mapper.UmsMemberCollectSubjectMapper;
import com.qinweizhao.product.service.IUmsMemberCollectSubjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员收藏的专题活动Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@Service
public class UmsMemberCollectSubjectServiceImpl implements IUmsMemberCollectSubjectService {
    @Resource
    private UmsMemberCollectSubjectMapper umsMemberCollectSubjectMapper;

    /**
     * 查询会员收藏的专题活动
     *
     * @param id 会员收藏的专题活动主键
     * @return 会员收藏的专题活动
     */
    @Override
    public UmsMemberCollectSubject selectUmsMemberCollectSubjectById(Long id) {
        return umsMemberCollectSubjectMapper.selectUmsMemberCollectSubjectById(id);
    }

    /**
     * 查询会员收藏的专题活动列表
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 会员收藏的专题活动
     */
    @Override
    public List<UmsMemberCollectSubject> selectUmsMemberCollectSubjectList(UmsMemberCollectSubject umsMemberCollectSubject) {
        return umsMemberCollectSubjectMapper.selectUmsMemberCollectSubjectList(umsMemberCollectSubject);
    }

    /**
     * 新增会员收藏的专题活动
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    @Override
    public int insertUmsMemberCollectSubject(UmsMemberCollectSubject umsMemberCollectSubject) {
        return umsMemberCollectSubjectMapper.insertUmsMemberCollectSubject(umsMemberCollectSubject);
    }

    /**
     * 修改会员收藏的专题活动
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 结果
     */
    @Override
    public int updateUmsMemberCollectSubject(UmsMemberCollectSubject umsMemberCollectSubject) {
        return umsMemberCollectSubjectMapper.updateUmsMemberCollectSubject(umsMemberCollectSubject);
    }

    /**
     * 批量删除会员收藏的专题活动
     *
     * @param ids 需要删除的会员收藏的专题活动主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberCollectSubjectByIds(Long[] ids) {
        return umsMemberCollectSubjectMapper.deleteUmsMemberCollectSubjectByIds(ids);
    }

    /**
     * 删除会员收藏的专题活动信息
     *
     * @param id 会员收藏的专题活动主键
     * @return 结果
     */
    @Override
    public int deleteUmsMemberCollectSubjectById(Long id) {
        return umsMemberCollectSubjectMapper.deleteUmsMemberCollectSubjectById(id);
    }
}
