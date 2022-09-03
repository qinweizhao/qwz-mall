package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsOrderReturnReason;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 退货原因Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Mapper

public interface OmsOrderReturnReasonMapper extends QwzMapper<OmsOrderReturnReason> {


    /**
     * 查询退货原因列表
     *
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因集合
     */
    List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason);

}
