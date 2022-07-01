package com.qinweizhao.order.service.impl;

import com.qinweizhao.order.mapper.OmsOrderReturnReasonMapper;
import com.qinweizhao.order.model.entity.OmsOrderReturnReason;
import com.qinweizhao.order.service.IOmsOrderReturnReasonService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 退货原因Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@Service
public class OmsOrderReturnReasonServiceImpl implements IOmsOrderReturnReasonService {
    @Resource
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    /**
     * 查询退货原因
     *
     * @param id 退货原因主键
     * @return 退货原因
     */
    @Override
    public OmsOrderReturnReason selectOmsOrderReturnReasonById(Long id) {
        return omsOrderReturnReasonMapper.selectOmsOrderReturnReasonById(id);
    }

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

    /**
     * 新增退货原因
     *
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    @Override
    public int insertOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason) {
        return omsOrderReturnReasonMapper.insertOmsOrderReturnReason(omsOrderReturnReason);
    }

    /**
     * 修改退货原因
     *
     * @param omsOrderReturnReason 退货原因
     * @return 结果
     */
    @Override
    public int updateOmsOrderReturnReason(OmsOrderReturnReason omsOrderReturnReason) {
        omsOrderReturnReason.setUpdateTime(LocalDateTime.now());
        return omsOrderReturnReasonMapper.updateOmsOrderReturnReason(omsOrderReturnReason);
    }

    /**
     * 批量删除退货原因
     *
     * @param ids 需要删除的退货原因主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderReturnReasonByIds(Long[] ids) {
        return omsOrderReturnReasonMapper.deleteOmsOrderReturnReasonByIds(ids);
    }

    /**
     * 删除退货原因信息
     *
     * @param id 退货原因主键
     * @return 结果
     */
    @Override
    public int deleteOmsOrderReturnReasonById(Long id) {
        return omsOrderReturnReasonMapper.deleteOmsOrderReturnReasonById(id);
    }
}
