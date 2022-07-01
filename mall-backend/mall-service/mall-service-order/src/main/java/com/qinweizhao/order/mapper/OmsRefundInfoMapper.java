package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsRefundInfo;

import java.util.List;

/**
 * 退款信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
public interface OmsRefundInfoMapper extends QwzBaseMapper<OmsRefundInfo> {


    /**
     * 查询退款信息列表
     *
     * @param omsRefundInfo 退款信息
     * @return 退款信息集合
     */
    List<OmsRefundInfo> selectOmsRefundInfoList(OmsRefundInfo omsRefundInfo);


}
