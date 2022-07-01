package com.qinweizhao.order.service.impl;

import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.order.mapper.OmsOrderReturnApplyMapper;
import com.qinweizhao.order.model.entity.OmsOrderReturnApply;
import com.qinweizhao.order.service.IOmsOrderReturnApplyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单退货申请Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderReturnApplyServiceImpl extends QwzServiceImpl<OmsOrderReturnApplyMapper, OmsOrderReturnApply> implements IOmsOrderReturnApplyService {

    @Resource
    private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;

    /**
     * 查询订单退货申请列表
     *
     * @param omsOrderReturnApply 订单退货申请
     * @return 订单退货申请
     */
    @Override
    public List<OmsOrderReturnApply> selectOmsOrderReturnApplyList(OmsOrderReturnApply omsOrderReturnApply) {
        return omsOrderReturnApplyMapper.selectOmsOrderReturnApplyList(omsOrderReturnApply);
    }


}
