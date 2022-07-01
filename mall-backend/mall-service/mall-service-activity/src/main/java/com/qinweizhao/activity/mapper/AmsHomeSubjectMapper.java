package com.qinweizhao.activity.mapper;

import com.qinweizhao.activity.domain.AmsHomeSubject;

import java.util.List;

/**
 * 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface AmsHomeSubjectMapper {
    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param id 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     */
    AmsHomeSubject selectAmsHomeSubjectById(Long id);

    /**
     * 查询首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】列表
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】集合
     */
    List<AmsHomeSubject> selectAmsHomeSubjectList(AmsHomeSubject amsHomeSubject);

    /**
     * 新增首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 结果
     */
    int insertAmsHomeSubject(AmsHomeSubject amsHomeSubject);

    /**
     * 修改首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param amsHomeSubject 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     * @return 结果
     */
    int updateAmsHomeSubject(AmsHomeSubject amsHomeSubject);

    /**
     * 删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param id 首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】主键
     * @return 结果
     */
    int deleteAmsHomeSubjectById(Long id);

    /**
     * 批量删除首页专题【jd首页下面很多专题，每个专题链接新的页面，展示专题商品信息】
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAmsHomeSubjectByIds(Long[] ids);
}
