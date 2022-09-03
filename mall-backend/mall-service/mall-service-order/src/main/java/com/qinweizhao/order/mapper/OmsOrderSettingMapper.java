package com.qinweizhao.order.mapper;

import com.qinweizhao.component.mybatis.mapper.QwzMapper;
import com.qinweizhao.order.model.entity.OmsOrderSetting;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 订单配置信息Mapper接口
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Mapper

public interface OmsOrderSettingMapper extends QwzMapper<OmsOrderSetting> {


    /**
     * 查询订单配置信息列表
     *
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息集合
     */
    List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting);


}
