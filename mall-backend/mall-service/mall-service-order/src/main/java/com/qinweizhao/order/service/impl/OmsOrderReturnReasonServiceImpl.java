package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsOrderReturnReasonMapper;
import com.qinweizhao.order.model.entity.OmsOrderReturnReason;
import com.qinweizhao.order.service.IOmsOrderReturnReasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 退货原因Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderReturnReasonServiceImpl extends QwzServiceImpl<OmsOrderReturnReasonMapper, OmsOrderReturnReason> implements IOmsOrderReturnReasonService {

    @Resource
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    /**
     * 查询退货原因列表
     *
     * @param omsOrderReturnReason 退货原因
     * @return 退货原因
     */
    @Override
    public List<OmsOrderReturnReason> selectOmsOrderReturnReasonList(OmsOrderReturnReason omsOrderReturnReason) {
        return omsOrderReturnReasonMapper.selectOmsOrderReturnReasonList(omsOrderReturnReason);
    }

}
