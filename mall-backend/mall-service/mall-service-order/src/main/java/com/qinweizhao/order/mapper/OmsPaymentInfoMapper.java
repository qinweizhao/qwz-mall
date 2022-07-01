package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsPaymentInfo;

import java.util.List;

/**
 * 支付信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
public interface OmsPaymentInfoMapper extends QwzBaseMapper<OmsPaymentInfo> {

    /**
     * 查询支付信息列表
     *
     * @param omsPaymentInfo 支付信息
     * @return 支付信息集合
     */
    List<OmsPaymentInfo> selectOmsPaymentInfoList(OmsPaymentInfo omsPaymentInfo);

}
