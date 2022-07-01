package com.qinweizhao.order.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsOrderReturnApply;
import com.qinweizhao.order.service.IOmsOrderReturnApplyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单退货申请Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/apply")
public class OmsOrderReturnApplyController {
    @Resource
    private IOmsOrderReturnApplyService omsOrderReturnApplyService;

    /**
     * 查询订单退货申请列表
     */
    @RequiresPermissions("order:apply:list")
    @GetMapping("/list")
    public R<List<OmsOrderReturnApply>> list(OmsOrderReturnApply omsOrderReturnApply) {
          
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.selectOmsOrderReturnApplyList(omsOrderReturnApply);
        return R.success(list);
    }

    /**
     * 导出订单退货申请列表
     */
    @RequiresPermissions("order:apply:export")
    @Log(title = "订单退货申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsOrderReturnApply omsOrderReturnApply) {
        List<OmsOrderReturnApply> list = omsOrderReturnApplyService.selectOmsOrderReturnApplyList(omsOrderReturnApply);
        ExcelUtil<OmsOrderReturnApply> util = new ExcelUtil<OmsOrderReturnApply>(OmsOrderReturnApply.class);
        util.exportExcel(response, list, "订单退货申请数据");
        return R.success();
    }

    /**
     * 获取订单退货申请详细信息
     */
    @RequiresPermissions("order:apply:query")
    @GetMapping(value = "/{id}")
    public R<OmsOrderReturnApply> getInfo(@PathVariable("id") Long id) {
        return R.success(omsOrderReturnApplyService.selectOmsOrderReturnApplyById(id));
    }

    /**
     * 新增订单退货申请
     */
    @RequiresPermissions("order:apply:add")
    @Log(title = "订单退货申请", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsOrderReturnApply omsOrderReturnApply) {
        return R.success(omsOrderReturnApplyService.insertOmsOrderReturnApply(omsOrderReturnApply));
    }

    /**
     * 修改订单退货申请
     */
    @RequiresPermissions("order:apply:edit")
    @Log(title = "订单退货申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsOrderReturnApply omsOrderReturnApply) {
        return R.success(omsOrderReturnApplyService.updateOmsOrderReturnApply(omsOrderReturnApply));
    }

    /**
     * 删除订单退货申请
     */
    @RequiresPermissions("order:apply:remove")
    @Log(title = "订单退货申请", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(omsOrderReturnApplyService.deleteOmsOrderReturnApplyByIds(ids));
    }
}
