package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.model.entity.AmsHomeSubjectSpu;
import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;

import java.util.List;

/**
 * 专题商品Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsHomeSubjectSpuMapper extends QwzBaseMapper<AmsHomeSubjectSpu> {
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
     * 删除专题商品
     *
     * @param id 专题商品主键
     * @return 结果
     */
    int deleteAmsHomeSubjectSpuById(Long id);

    /**
     * 批量删除专题商品
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsHomeSubjectSpuByIds(Long[] ids);
}
