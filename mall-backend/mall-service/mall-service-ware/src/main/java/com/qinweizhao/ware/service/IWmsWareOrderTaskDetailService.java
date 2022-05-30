package com.qinweizhao.ware.service;

import com.qinweizhao.ware.model.entity.WmsWareOrderTaskDetail;

import java.util.List;

/**
 * 库存工作单详情Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsWareOrderTaskDetailService {
    /**
     * 查询库存工作单详情
     *
     * @param id 库存工作单详情主键
     * @return 库存工作单详情
     */
    WmsWareOrderTaskDetail selectWmsWareOrderTaskDetailById(Long id);

    /**
     * 查询库存工作单详情列表
     *
     * @param wmsWareOrderTaskDetail 库存工作单详情
     * @return 库存工作单详情集合
     */
    List<WmsWareOrderTaskDetail> selectWmsWareOrderTaskDetailList(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 新增库存工作单详情
     *
     * @param wmsWareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    int insertWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 修改库存工作单详情
     *
     * @param wmsWareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    int updateWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 批量删除库存工作单详情
     *
     * @param ids 需要删除的库存工作单详情主键集合
     * @return 结果
     */
    int deleteWmsWareOrderTaskDetailByIds(Long[] ids);

    /**
     * 删除库存工作单详情信息
     *
     * @param id 库存工作单详情主键
     * @return 结果
     */
    int deleteWmsWareOrderTaskDetailById(Long id);
}
