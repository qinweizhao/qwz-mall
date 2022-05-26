package com.qinweizhao.user.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.user.model.entity.UmsMemberCollectSubject;

import java.util.List;

/**
 * 会员收藏的专题活动Service接口
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
public interface UmsMemberCollectSubjectService extends QwzService<UmsMemberCollectSubject> {


    /**
     * 查询会员收藏的专题活动列表
     *
     * @param umsMemberCollectSubject 会员收藏的专题活动
     * @return 会员收藏的专题活动集合
     */
    List<UmsMemberCollectSubject> selectUmsMemberCollectSubjectList(UmsMemberCollectSubject umsMemberCollectSubject);

}
