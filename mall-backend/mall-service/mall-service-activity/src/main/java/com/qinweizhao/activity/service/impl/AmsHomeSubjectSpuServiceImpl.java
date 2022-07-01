package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsHomeSubjectSpuMapper;
import com.qinweizhao.activity.model.entity.AmsHomeSubjectSpu;
import com.qinweizhao.activity.service.IAmsHomeSubjectSpuService;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 专题商品Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsHomeSubjectSpuServiceImpl extends QwzServiceImpl<AmsHomeSubjectSpuMapper, AmsHomeSubjectSpu> implements IAmsHomeSubjectSpuService {
    @Resource
    private AmsHomeSubjectSpuMapper amsHomeSubjectSpuMapper;


    /**
     * 查询专题商品列表
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 专题商品
     */
    @Override
    public List<AmsHomeSubjectSpu> selectAmsHomeSubjectSpuList(AmsHomeSubjectSpu amsHomeSubjectSpu) {
        return amsHomeSubjectSpuMapper.selectAmsHomeSubjectSpuList(amsHomeSubjectSpu);
    }

}
