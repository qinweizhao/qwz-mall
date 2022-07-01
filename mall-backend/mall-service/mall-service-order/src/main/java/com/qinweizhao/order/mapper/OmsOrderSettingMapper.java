package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzBaseMapper;
import com.qinweizhao.order.model.entity.OmsOrderSetting;

import java.util.List;

/**
 * 订单配置信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface OmsOrderSettingMapper extends QwzBaseMapper<OmsOrderSetting> {


    /**
     * 查询订单配置信息列表
     *
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息集合
     */
    List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting);


}
