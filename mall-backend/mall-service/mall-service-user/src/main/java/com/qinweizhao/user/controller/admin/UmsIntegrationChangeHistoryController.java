package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsIntegrationChangeHistory;
import com.qinweizhao.user.service.UmsIntegrationChangeHistoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 积分变化历史记录Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/integration-history")
public class UmsIntegrationChangeHistoryController {

    @Resource
    private UmsIntegrationChangeHistoryService umsIntegrationChangeHistoryService;

    /**
     * 查询积分变化历史记录列表
     */
    @RequiresPermissions("product:history:list")
    @GetMapping("/list")
    public R<List<UmsIntegrationChangeHistory>> list(UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
         
        List<UmsIntegrationChangeHistory> list = umsIntegrationChangeHistoryService.selectUmsIntegrationChangeHistoryList(umsIntegrationChangeHistory);
        return R.success(list);
    }

    /**
     * 获取积分变化历史记录详细信息
     */
    @RequiresPermissions("product:history:query")
    @GetMapping(value = "/{id}")
    public R<UmsIntegrationChangeHistory> getInfo(@PathVariable("id") Long id) {
        return R.success(umsIntegrationChangeHistoryService.getById(id));
    }

    /**
     * 新增积分变化历史记录
     */
    @RequiresPermissions("product:history:add")
    @Log(title = "积分变化历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Boolean> add(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return R.success(umsIntegrationChangeHistoryService.save(umsIntegrationChangeHistory));
    }

    /**
     * 修改积分变化历史记录
     */
    @RequiresPermissions("product:history:edit")
    @Log(title = "积分变化历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Boolean> edit(@RequestBody UmsIntegrationChangeHistory umsIntegrationChangeHistory) {
        return R.success(umsIntegrationChangeHistoryService.updateById(umsIntegrationChangeHistory));
    }

    /**
     * 删除积分变化历史记录
     */
    @RequiresPermissions("product:history:remove")
    @Log(title = "积分变化历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Boolean> remove(@PathVariable List<Long> ids) {
        return R.success(umsIntegrationChangeHistoryService.removeBatchByIds(ids));
    }
}
