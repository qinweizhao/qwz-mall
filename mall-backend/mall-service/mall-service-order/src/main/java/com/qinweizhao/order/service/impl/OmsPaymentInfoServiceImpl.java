package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsPaymentInfoMapper;
import com.qinweizhao.order.model.entity.OmsPaymentInfo;
import com.qinweizhao.order.service.IOmsPaymentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 支付信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@Service
public class OmsPaymentInfoServiceImpl extends QwzServiceImpl<OmsPaymentInfoMapper, OmsPaymentInfo> implements IOmsPaymentInfoService {

    @Resource
    private OmsPaymentInfoMapper omsPaymentInfoMapper;


    /**
     * 查询支付信息列表
     *
     * @param omsPaymentInfo 支付信息
     * @return 支付信息
     */
    @Override
    public List<OmsPaymentInfo> selectOmsPaymentInfoList(OmsPaymentInfo omsPaymentInfo) {
        return omsPaymentInfoMapper.selectOmsPaymentInfoList(omsPaymentInfo);
    }
}
