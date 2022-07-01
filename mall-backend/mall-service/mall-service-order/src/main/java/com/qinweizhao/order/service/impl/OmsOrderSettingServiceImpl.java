package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsOrderSettingMapper;
import com.qinweizhao.order.model.entity.OmsOrderSetting;
import com.qinweizhao.order.service.IOmsOrderSettingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单配置信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderSettingServiceImpl extends QwzServiceImpl<OmsOrderSettingMapper, OmsOrderSetting> implements IOmsOrderSettingService {
    @Resource
    private OmsOrderSettingMapper omsOrderSettingMapper;


    /**
     * 查询订单配置信息列表
     *
     * @param omsOrderSetting 订单配置信息
     * @return 订单配置信息
     */
    @Override
    public List<OmsOrderSetting> selectOmsOrderSettingList(OmsOrderSetting omsOrderSetting) {
        return omsOrderSettingMapper.selectOmsOrderSettingList(omsOrderSetting);
    }


}
