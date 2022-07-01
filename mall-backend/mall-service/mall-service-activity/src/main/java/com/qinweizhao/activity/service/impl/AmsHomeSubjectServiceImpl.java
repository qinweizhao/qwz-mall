package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsHomeSubjectMapper;
import com.qinweizhao.activity.model.entity.AmsHomeSubject;
import com.qinweizhao.activity.service.IAmsHomeSubjectService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsHomeSubjectServiceImpl extends QwzServiceImpl<AmsHomeSubjectMapper, AmsHomeSubject> implements IAmsHomeSubjectService {
    @Resource
    private AmsHomeSubjectMapper amsHomeSubjectMapper;

    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    @Override
    public List<AmsHomeSubject> selectAmsHomeSubjectList(AmsHomeSubject amsHomeSubject) {
        return amsHomeSubjectMapper.selectAmsHomeSubjectList(amsHomeSubject);
    }
}
