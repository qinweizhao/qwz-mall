package com.qinweizhao.ware.mapper;

import com.qinweizhao.ware.model.WmsWareOrderTaskDetail;

import java.util.List;

/**
 * 库存工作单详情Mapper接口
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
public interface WmsWareOrderTaskDetailMapper {
    /**
     * 查询库存工作单详情
     *
     * @param id 库存工作单详情主键
     * @return 库存工作单详情
     */
    public WmsWareOrderTaskDetail selectWmsWareOrderTaskDetailById(Long id);

    /**
     * 查询库存工作单详情列表
     *
     * @param wmsWareOrderTaskDetail 库存工作单详情
     * @return 库存工作单详情集合
     */
    public List<WmsWareOrderTaskDetail> selectWmsWareOrderTaskDetailList(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 新增库存工作单详情
     *
     * @param wmsWareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    public int insertWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 修改库存工作单详情
     *
     * @param wmsWareOrderTaskDetail 库存工作单详情
     * @return 结果
     */
    public int updateWmsWareOrderTaskDetail(WmsWareOrderTaskDetail wmsWareOrderTaskDetail);

    /**
     * 删除库存工作单详情
     *
     * @param id 库存工作单详情主键
     * @return 结果
     */
    public int deleteWmsWareOrderTaskDetailById(Long id);

    /**
     * 批量删除库存工作单详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteWmsWareOrderTaskDetailByIds(Long[] ids);
}
