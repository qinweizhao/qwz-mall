package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsHomeSubject;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsHomeSubjectService extends QwzService<AmsHomeSubject> {

    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】集合
     */
    List<AmsHomeSubject> selectAmsHomeSubjectList(AmsHomeSubject amsHomeSubject);


}
