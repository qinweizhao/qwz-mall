package com.qinweizhao.order.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.order.model.entity.OmsOrderReturnApply;

import java.util.List;

/**
 * 订单退货申请Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderReturnApplyService extends QwzService<OmsOrderReturnApply> {


    /**
     * 查询订单退货申请列表
     *
     * @param omsOrderReturnApply 订单退货申请
     * @return 订单退货申请集合
     */
    List<OmsOrderReturnApply> selectOmsOrderReturnApplyList(OmsOrderReturnApply omsOrderReturnApply);


}
