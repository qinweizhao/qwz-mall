package com.qinweizhao.ware.service;

import com.qinweizhao.ware.model.WmsWareOrderTask;

import java.util.List;

/**
 * 库存工作单Service接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface IWmsWareOrderTaskService {
    /**
     * 查询库存工作单
     *
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    WmsWareOrderTask selectWmsWareOrderTaskById(Long id);

    /**
     * 查询库存工作单列表
     *
     * @param wmsWareOrderTask 库存工作单
     * @return 库存工作单集合
     */
    List<WmsWareOrderTask> selectWmsWareOrderTaskList(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 新增库存工作单
     *
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    int insertWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 修改库存工作单
     *
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    int updateWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask);

    /**
     * 批量删除库存工作单
     *
     * @param ids 需要删除的库存工作单主键集合
     * @return 结果
     */
    int deleteWmsWareOrderTaskByIds(Long[] ids);

    /**
     * 删除库存工作单信息
     *
     * @param id 库存工作单主键
     * @return 结果
     */
    int deleteWmsWareOrderTaskById(Long id);
}
