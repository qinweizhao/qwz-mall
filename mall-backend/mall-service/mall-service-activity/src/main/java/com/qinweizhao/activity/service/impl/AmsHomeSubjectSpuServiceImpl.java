package com.qinweizhao.activity.service.impl;

import com.qinweizhao.activity.mapper.AmsHomeSubjectSpuMapper;
import com.qinweizhao.activity.model.entity.AmsHomeSubjectSpu;
import com.qinweizhao.activity.service.IAmsHomeSubjectSpuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 专题商品Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class AmsHomeSubjectSpuServiceImpl implements IAmsHomeSubjectSpuService {
    @Resource
    private AmsHomeSubjectSpuMapper amsHomeSubjectSpuMapper;

    /**
     * 查询专题商品
     *
     * @param id 专题商品主键
     * @return 专题商品
     */
    @Override
    public AmsHomeSubjectSpu selectAmsHomeSubjectSpuById(Long id) {
        return amsHomeSubjectSpuMapper.selectAmsHomeSubjectSpuById(id);
    }

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

    /**
     * 新增专题商品
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 结果
     */
    @Override
    public int insertAmsHomeSubjectSpu(AmsHomeSubjectSpu amsHomeSubjectSpu) {
        amsHomeSubjectSpu.setCreateTime(LocalDateTime.now());
        return amsHomeSubjectSpuMapper.insertAmsHomeSubjectSpu(amsHomeSubjectSpu);
    }

    /**
     * 修改专题商品
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 结果
     */
    @Override
    public int updateAmsHomeSubjectSpu(AmsHomeSubjectSpu amsHomeSubjectSpu) {
        amsHomeSubjectSpu.setUpdateTime(LocalDateTime.now());
        return amsHomeSubjectSpuMapper.updateAmsHomeSubjectSpu(amsHomeSubjectSpu);
    }

    /**
     * 批量删除专题商品
     *
     * @param ids 需要删除的专题商品主键
     * @return 结果
     */
    @Override
    public int deleteAmsHomeSubjectSpuByIds(Long[] ids) {
        return amsHomeSubjectSpuMapper.deleteAmsHomeSubjectSpuByIds(ids);
    }

    /**
     * 删除专题商品信息
     *
     * @param id 专题商品主键
     * @return 结果
     */
    @Override
    public int deleteAmsHomeSubjectSpuById(Long id) {
        return amsHomeSubjectSpuMapper.deleteAmsHomeSubjectSpuById(id);
    }
}
