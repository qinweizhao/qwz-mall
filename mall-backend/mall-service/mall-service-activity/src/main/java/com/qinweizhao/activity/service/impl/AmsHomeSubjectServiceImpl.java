package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.domain.AmsHomeSubject;
import com.qinweizhao.activity.mapper.AmsHomeSubjectMapper;
import com.qinweizhao.activity.service.IAmsHomeSubjectService;
import com.qinweizhao.common.core.utils.DateUtils;
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
public class AmsHomeSubjectServiceImpl implements IAmsHomeSubjectService {
    @Resource
    private AmsHomeSubjectMapper amsHomeSubjectMapper;

    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param id 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    @Override
    public AmsHomeSubject selectAmsHomeSubjectById(Long id) {
        return amsHomeSubjectMapper.selectAmsHomeSubjectById(id);
    }

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

    /**
     * 新增首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 结果
     */
    @Override
    public int insertAmsHomeSubject(AmsHomeSubject amsHomeSubject) {
        amsHomeSubject.setCreateTime(DateUtils.getNowDate());
        return amsHomeSubjectMapper.insertAmsHomeSubject(amsHomeSubject);
    }

    /**
     * 修改首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 结果
     */
    @Override
    public int updateAmsHomeSubject(AmsHomeSubject amsHomeSubject) {
        amsHomeSubject.setUpdateTime(DateUtils.getNowDate());
        return amsHomeSubjectMapper.updateAmsHomeSubject(amsHomeSubject);
    }

    /**
     * 批量删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param ids 需要删除的首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 结果
     */
    @Override
    public int deleteAmsHomeSubjectByIds(Long[] ids) {
        return amsHomeSubjectMapper.deleteAmsHomeSubjectByIds(ids);
    }

    /**
     * 删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】信息
     *
     * @param id 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 结果
     */
    @Override
    public int deleteAmsHomeSubjectById(Long id) {
        return amsHomeSubjectMapper.deleteAmsHomeSubjectById(id);
    }
}
