package com.qinweizhao.ware.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.ware.model.entity.WmsWareOrderTask;
import com.qinweizhao.ware.mapper.WmsWareOrderTaskMapper;
import com.qinweizhao.ware.service.IWmsWareOrderTaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 库存工作单Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@Service
public class WmsWareOrderTaskServiceImpl implements IWmsWareOrderTaskService {
    @Resource
    private WmsWareOrderTaskMapper wmsWareOrderTaskMapper;

    /**
     * 查询库存工作单
     *
     * @param id 库存工作单主键
     * @return 库存工作单
     */
    @Override
    public WmsWareOrderTask selectWmsWareOrderTaskById(Long id) {
        return wmsWareOrderTaskMapper.selectWmsWareOrderTaskById(id);
    }

    /**
     * 查询库存工作单列表
     *
     * @param wmsWareOrderTask 库存工作单
     * @return 库存工作单
     */
    @Override
    public List<WmsWareOrderTask> selectWmsWareOrderTaskList(WmsWareOrderTask wmsWareOrderTask) {
        return wmsWareOrderTaskMapper.selectWmsWareOrderTaskList(wmsWareOrderTask);
    }

    /**
     * 新增库存工作单
     *
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    @Override
    public int insertWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask) {
        wmsWareOrderTask.setCreateTime(DateUtils.getNowDate());
        return wmsWareOrderTaskMapper.insertWmsWareOrderTask(wmsWareOrderTask);
    }

    /**
     * 修改库存工作单
     *
     * @param wmsWareOrderTask 库存工作单
     * @return 结果
     */
    @Override
    public int updateWmsWareOrderTask(WmsWareOrderTask wmsWareOrderTask) {
        wmsWareOrderTask.setUpdateTime(DateUtils.getNowDate());
        return wmsWareOrderTaskMapper.updateWmsWareOrderTask(wmsWareOrderTask);
    }

    /**
     * 批量删除库存工作单
     *
     * @param ids 需要删除的库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareOrderTaskByIds(Long[] ids) {
        return wmsWareOrderTaskMapper.deleteWmsWareOrderTaskByIds(ids);
    }

    /**
     * 删除库存工作单信息
     *
     * @param id 库存工作单主键
     * @return 结果
     */
    @Override
    public int deleteWmsWareOrderTaskById(Long id) {
        return wmsWareOrderTaskMapper.deleteWmsWareOrderTaskById(id);
    }
}
