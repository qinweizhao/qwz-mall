package com.qinweizhao.order.service;

import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.order.model.entity.OmsOrderSetting;

import java.util.List;

/**
 * 订单配置信息Service接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
public interface IOmsOrderSettingService extends QwzService<OmsOrderSetting> {


    /**
     * 查询订单配置信息列表
     *
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息集合
     */
    List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting);

}
