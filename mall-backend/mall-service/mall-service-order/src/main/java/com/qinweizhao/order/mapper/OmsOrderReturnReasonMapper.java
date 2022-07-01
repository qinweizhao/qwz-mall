package com.qinweizhao.order.mapper;

import com.qinweizhao.order.model.entity.OmsOrderReturnReason;

import java.util.List;

/**
 * 退货原因Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderReturnReasonMapper {
    /**
     * 查询退货原因
     *
     * @param id 退货原因主键
     * @return 退货原因
     */
    OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id);

    /**
     * 查询退货原因列表
     *
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因集合
     */
    List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 新增退货原因
     *
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    int insertOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 修改退货原因
     *
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    int updateOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason);

    /**
     * 删除退货原因
     *
     * @param id 退货原因主键
     * @return 结果
     */
    int deleteOmsOrderReturnReasonById(Long id);

    /**
     * 批量删除退货原因
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteOmsOrderReturnReasonByIds(Long[] ids);
}
