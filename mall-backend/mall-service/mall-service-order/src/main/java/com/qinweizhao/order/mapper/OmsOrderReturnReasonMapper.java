package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsOrderReturnReason;

import java.util.List;

/**
 * 退货原因Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderReturnReasonMapper extends QwzBaseMapper<OmsOrderReturnReason> {


    /**
     * 查询退货原因列表
     *
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因集合
     */
    List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason);

}
