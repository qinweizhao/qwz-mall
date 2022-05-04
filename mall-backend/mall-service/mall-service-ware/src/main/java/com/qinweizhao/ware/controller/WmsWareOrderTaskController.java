package com.qinweizhao.ware.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.ware.domain.WmsWareOrderTask;
import com.qinweizhao.ware.service.IWmsWareOrderTaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 库存工作单Controller
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/task")
public class WmsWareOrderTaskController extends BaseController {
    @Resource
    private IWmsWareOrderTaskService wmsWareOrderTaskService;

    /**
     * 查询库存工作单列表
     */
    @RequiresPermissions("product:task:list")
    @GetMapping("/list")
    public R<List<WmsWareOrderTask>> list(WmsWareOrderTask wmsWareOrderTask) {
        startPage();
        List<WmsWareOrderTask> list = wmsWareOrderTaskService.selectWmsWareOrderTaskList(wmsWareOrderTask);
        return R.success(list);
    }

    /**
     * 导出库存工作单列表
     */
    @RequiresPermissions("product:task:export")
    @Log(title = "库存工作单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, WmsWareOrderTask wmsWareOrderTask) {
        List<WmsWareOrderTask> list = wmsWareOrderTaskService.selectWmsWareOrderTaskList(wmsWareOrderTask);
        ExcelUtil<WmsWareOrderTask> util = new ExcelUtil<WmsWareOrderTask>(WmsWareOrderTask.class);
        util.exportExcel(response, list, "库存工作单数据");
        return R.success();
    }

    /**
     * 获取库存工作单详细信息
     */
    @RequiresPermissions("product:task:query")
    @GetMapping(value = "/{id}")
    public R<WmsWareOrderTask> getInfo(@PathVariable("id") Long id) {
        return R.success(wmsWareOrderTaskService.selectWmsWareOrderTaskById(id));
    }

    /**
     * 新增库存工作单
     */
    @RequiresPermissions("product:task:add")
    @Log(title = "库存工作单", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody WmsWareOrderTask wmsWareOrderTask) {
        return R.condition(wmsWareOrderTaskService.insertWmsWareOrderTask(wmsWareOrderTask));
    }

    /**
     * 修改库存工作单
     */
    @RequiresPermissions("product:task:edit")
    @Log(title = "库存工作单", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody WmsWareOrderTask wmsWareOrderTask) {
        return R.condition(wmsWareOrderTaskService.updateWmsWareOrderTask(wmsWareOrderTask));
    }

    /**
     * 删除库存工作单
     */
    @RequiresPermissions("product:task:remove")
    @Log(title = "库存工作单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(wmsWareOrderTaskService.deleteWmsWareOrderTaskByIds(ids));
    }
}
