package com.qinweizhao.order.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.order.model.entity.OmsOrderReturnReason;

import java.util.List;

/**
 * 退货原因Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderReturnReasonService extends QwzService<OmsOrderReturnReason> {

    /**
     * 查询退货原因列表
     *
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因集合
     */
    List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason);

}
