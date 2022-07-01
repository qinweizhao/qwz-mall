package com.qinweizhao.activity.service;

import com.qinweizhao.activity.model.entity.AmsHomeSubjectSpu;
import com.qinweizhao.component.mybatis.service.QwzService;

import java.util.List;

/**
 * 专题商品Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsHomeSubjectSpuService extends QwzService<AmsHomeSubjectSpu> {

    /**
     * 查询专题商品列表
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 专题商品集合
     */
    List<AmsHomeSubjectSpu> selectAmsHomeSubjectSpuList(AmsHomeSubjectSpu amsHomeSubjectSpu);


}
