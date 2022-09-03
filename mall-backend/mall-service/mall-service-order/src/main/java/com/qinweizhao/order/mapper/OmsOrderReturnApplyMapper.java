package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsOrderReturnApply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单退货申请Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Mapper

public interface OmsOrderReturnApplyMapper extends QwzMapper<OmsOrderReturnApply> {


    /**
     * 查询订单退货申请列表
     *
     * @param omsOrderReturnApply 订单退货申请
     * @return 订单退货申请集合
     */
    List<OmsOrderReturnApply> selectOmsOrderReturnApplyList(OmsOrderReturnApply omsOrderReturnApply);

}
