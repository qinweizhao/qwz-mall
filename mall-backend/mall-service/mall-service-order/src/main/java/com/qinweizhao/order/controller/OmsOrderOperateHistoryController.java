package com.qinweizhao.order.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsOrderOperateHistory;
import com.qinweizhao.order.service.IOmsOrderOperateHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单操作历史记录Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/history")
public class OmsOrderOperateHistoryController {
    @Resource
    private IOmsOrderOperateHistoryService omsOrderOperateHistoryService;

    /**
     * 查询订单操作历史记录列表
     */
    @RequiresPermissions("order:history:list")
    @GetMapping("/list")
    public R<List<OmsOrderOperateHistory>> list(OmsOrderOperateHistory omsOrderOperateHistory) {
        List<OmsOrderOperateHistory> list = omsOrderOperateHistoryService.selectOmsOrderOperateHistoryList(omsOrderOperateHistory);
        return R.success(list);
    }

    /**
     * 导出订单操作历史记录列表
     */
    @RequiresPermissions("order:history:export")
    @Log(title = "订单操作历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsOrderOperateHistory omsOrderOperateHistory) {
        List<OmsOrderOperateHistory> list = omsOrderOperateHistoryService.selectOmsOrderOperateHistoryList(omsOrderOperateHistory);
        ExcelUtil<OmsOrderOperateHistory> util = new ExcelUtil<OmsOrderOperateHistory>(OmsOrderOperateHistory.class);
        util.exportExcel(response, list, "订单操作历史记录数据");
        return R.success();
    }

    /**
     * 获取订单操作历史记录详细信息
     */
    @RequiresPermissions("order:history:query")
    @GetMapping(value = "/{id}")
    public R<OmsOrderOperateHistory> getInfo(@PathVariable("id") Long id) {
        return R.success(omsOrderOperateHistoryService.selectOmsOrderOperateHistoryById(id));
    }

    /**
     * 新增订单操作历史记录
     */
    @RequiresPermissions("order:history:add")
    @Log(title = "订单操作历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsOrderOperateHistory omsOrderOperateHistory) {
        return R.success(omsOrderOperateHistoryService.insertOmsOrderOperateHistory(omsOrderOperateHistory));
    }

    /**
     * 修改订单操作历史记录
     */
    @RequiresPermissions("order:history:edit")
    @Log(title = "订单操作历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsOrderOperateHistory omsOrderOperateHistory) {
        return R.success(omsOrderOperateHistoryService.updateOmsOrderOperateHistory(omsOrderOperateHistory));
    }

    /**
     * 删除订单操作历史记录
     */
    @RequiresPermissions("order:history:remove")
    @Log(title = "订单操作历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(omsOrderOperateHistoryService.deleteOmsOrderOperateHistoryByIds(ids));
    }
}
