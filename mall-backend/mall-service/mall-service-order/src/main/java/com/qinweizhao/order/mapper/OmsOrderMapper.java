package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Mapper
public interface OmsOrderMapper extends QwzMapper<OmsOrder> {

    /**
     * 查询订单列表
     *
     * @param omsOrder 订单
     * @return 订单集合
     */
    List<OmsOrder> selectOmsOrderList(OmsOrder omsOrder);

}
