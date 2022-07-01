package com.qinweizhao.order.service.impl;


import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsRefundInfoMapper;
import com.qinweizhao.order.model.entity.OmsRefundInfo;
import com.qinweizhao.order.service.IOmsRefundInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 退款信息Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@Service
public class OmsRefundInfoServiceImpl extends QwzServiceImpl<OmsRefundInfoMapper, OmsRefundInfo> implements IOmsRefundInfoService {

    @Resource
    private OmsRefundInfoMapper omsRefundInfoMapper;

    /**
     * 查询退款信息列表
     *
     * @param omsRefundInfo 退款信息
     * @return 退款信息
     */
    @Override
    public List<OmsRefundInfo> selectOmsRefundInfoList(OmsRefundInfo omsRefundInfo) {
        return omsRefundInfoMapper.selectOmsRefundInfoList(omsRefundInfo);
    }

}
