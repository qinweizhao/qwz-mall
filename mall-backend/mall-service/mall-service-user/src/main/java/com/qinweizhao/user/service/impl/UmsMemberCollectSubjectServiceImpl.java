package com.qinweizhao.user.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.user.model.entity.UmsMemberCollectSubject;
import com.qinweizhao.user.mapper.UmsMemberCollectSubjectMapper;
import com.qinweizhao.user.service.UmsMemberCollectSubjectService;
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
public class UmsMemberCollectSubjectServiceImpl extends QwzServiceImpl<UmsMemberCollectSubjectMapper, UmsMemberCollectSubject> implements UmsMemberCollectSubjectService {
    @Resource
    private UmsMemberCollectSubjectMapper umsMemberCollectSubjectMapper;


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


}
