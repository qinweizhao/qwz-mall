package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsPaymentInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 支付信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@Mapper

public interface OmsPaymentInfoMapper extends QwzMapper<OmsPaymentInfo> {

    /**
     * 查询支付信息列表
     *
     * @param omsPaymentInfo 支付信息
     * @return 支付信息集合
     */
    List<OmsPaymentInfo> selectOmsPaymentInfoList(OmsPaymentInfo omsPaymentInfo);

}
