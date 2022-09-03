package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsRefundInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 退款信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@Mapper

public interface OmsRefundInfoMapper extends QwzMapper<OmsRefundInfo> {


    /**
     * 查询退款信息列表
     *
     * @param omsRefundInfo 退款信息
     * @return 退款信息集合
     */
    List<OmsRefundInfo> selectOmsRefundInfoList(OmsRefundInfo omsRefundInfo);


}
