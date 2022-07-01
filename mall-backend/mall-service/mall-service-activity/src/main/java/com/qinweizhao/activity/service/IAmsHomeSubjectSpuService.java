package com.qinweizhao.activity.service;

import com.qinweizhao.activity.domain.AmsHomeSubjectSpu;

import java.util.List;

/**
 * 专题商品Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IAmsHomeSubjectSpuService {
    /**
     * 查询专题商品
     *
     * @param id 专题商品主键
     * @return 专题商品
     */
    AmsHomeSubjectSpu selectAmsHomeSubjectSpuById(Long id);

    /**
     * 查询专题商品列表
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 专题商品集合
     */
    List<AmsHomeSubjectSpu> selectAmsHomeSubjectSpuList(AmsHomeSubjectSpu amsHomeSubjectSpu);

    /**
     * 新增专题商品
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 结果
     */
    int insertAmsHomeSubjectSpu(AmsHomeSubjectSpu amsHomeSubjectSpu);

    /**
     * 修改专题商品
     *
     * @param amsHomeSubjectSpu 专题商品
     * @return 结果
     */
    int updateAmsHomeSubjectSpu(AmsHomeSubjectSpu amsHomeSubjectSpu);

    /**
     * 批量删除专题商品
     *
     * @param ids 需要删除的专题商品主键集合
     * @return 结果
     */
    int deleteAmsHomeSubjectSpuByIds(Long[] ids);

    /**
     * 删除专题商品信息
     *
     * @param id 专题商品主键
     * @return 结果
     */
    int deleteAmsHomeSubjectSpuById(Long id);
}
