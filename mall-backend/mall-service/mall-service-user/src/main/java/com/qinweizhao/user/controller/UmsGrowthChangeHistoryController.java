package com.qinweizhao.user.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsGrowthChangeHistory;
import com.qinweizhao.user.service.UmsGrowthChangeHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 成长值变化历史记录Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/growth-history")
public class UmsGrowthChangeHistoryController extends BaseController {

    @Resource
    private UmsGrowthChangeHistoryService umsGrowthChangeHistoryService;

    /**
     * 查询成长值变化历史记录列表
     */
    @RequiresPermissions("product:history:list")
    @GetMapping("/list")
    public R<List<UmsGrowthChangeHistory>> list(UmsGrowthChangeHistory umsGrowthChangeHistory) {
        startPage();
        List<UmsGrowthChangeHistory> list = umsGrowthChangeHistoryService.selectUmsGrowthChangeHistoryList(umsGrowthChangeHistory);
        return R.success(list);
    }

    /**
     * 获取成长值变化历史记录详细信息
     */
    @RequiresPermissions("product:history:query")
    @GetMapping(value = "/{id}")
    public R<UmsGrowthChangeHistory> getInfo(@PathVariable("id") Long id) {
        return R.success(umsGrowthChangeHistoryService.getById(id));
    }

    /**
     * 新增成长值变化历史记录
     */
    @RequiresPermissions("product:history:add")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return R.success(umsGrowthChangeHistoryService.save(umsGrowthChangeHistory));
    }

    /**
     * 修改成长值变化历史记录
     */
    @RequiresPermissions("product:history:edit")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsGrowthChangeHistory umsGrowthChangeHistory) {
        return R.success(umsGrowthChangeHistoryService.updateById(umsGrowthChangeHistory));
    }

    /**
     * 删除成长值变化历史记录
     */
    @RequiresPermissions("product:history:remove")
    @Log(title = "成长值变化历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsGrowthChangeHistoryService.removeBatchByIds(ids));
    }
}
