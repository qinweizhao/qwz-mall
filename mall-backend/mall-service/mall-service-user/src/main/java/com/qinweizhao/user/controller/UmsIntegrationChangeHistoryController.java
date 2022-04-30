package com.qinweizhao.user.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.user.entity.UmsIntegrationChangeHistory;
import com.qinweizhao.user.service.IUmsIntegrationChangeHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 积分变化历史记录Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/history")
public class UmsIntegrationChangeHistoryController extends BaseController {
    @Resource
    private IUmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
     * 查询积分变化历史记录列表
     */
    @RequiresPermissions("product:history:list")
    @GetMapping("/list")
    public R<List<UmsIntegrationChangeHistory>> list(UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        startPage();
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        return R.success(list);
    }

    /**
     * 导出积分变化历史记录列表
     */
    @RequiresPermissions("product:history:export")
    @Log(title = "积分变化历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        ExcelUtil<UmsIntegrationChangeHistory> util = new ExcelUtil<UmsIntegrationChangeHistory>(UmsIntegrationChangeHistory.class);
        util.exportExcel(response, list, "积分变化历史记录数据");
        return R.success();
    }

    /**
     * 获取积分变化历史记录详细信息
     */
    @RequiresPermissions("product:history:query")
    @GetMapping(value = "/{id}")
    public R<UmsIntegrationChangeHistory> getInfo(@PathVariable("id") Long id) {
        return R.success(umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryById(id));
    }

    /**
     * 新增积分变化历史记录
     */
    @RequiresPermissions("product:history:add")
    @Log(title = "积分变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return R.condition(umsIntegrationChangeHistoryService.insertUmsIntegrationChangeHistory(umsIntegrationChangeHistory));
    }

    /**
     * 修改积分变化历史记录
     */
    @RequiresPermissions("product:history:edit")
    @Log(title = "积分变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return R.condition(umsIntegrationChangeHistoryService.updateUmsIntegrationChangeHistory(umsIntegrationChangeHistory));
    }

    /**
     * 删除积分变化历史记录
     */
    @RequiresPermissions("product:history:remove")
    @Log(title = "积分变化历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(umsIntegrationChangeHistoryService.deleteUmsIntegrationChangeHistoryByIds(ids));
    }
}
