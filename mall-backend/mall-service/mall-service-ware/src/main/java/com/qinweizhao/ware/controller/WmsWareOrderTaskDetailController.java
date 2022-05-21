package com.qinweizhao.ware.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.ware.model.WmsWareOrderTaskDetail;
import com.qinweizhao.ware.service.IWmsWareOrderTaskDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 库存工作单详情Controller
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/order/task/detail")
public class WmsWareOrderTaskDetailController extends BaseController {
    @Resource
    private IWmsWareOrderTaskDetailService wmsWareOrderTaskDetailService;

    /**
     * 查询库存工作单详情列表
     */
    @RequiresPermissions("product:detail:list")
    @GetMapping("/list")
    public R<List<WmsWareOrderTaskDetail>> list(WmsWareOrderTaskDetail wmsWareOrderTaskDetail) {
        startPage();
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
        return R.success(list);
    }

    /**
     * 导出库存工作单详情列表
     */
    @RequiresPermissions("product:detail:export")
    @Log(title = "库存工作单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, WmsWareOrderTaskDetail wmsWareOrderTaskDetail) {
        List<WmsWareOrderTaskDetail> list = wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailList(wmsWareOrderTaskDetail);
        ExcelUtil<WmsWareOrderTaskDetail> util = new ExcelUtil<WmsWareOrderTaskDetail>(WmsWareOrderTaskDetail.class);
        util.exportExcel(response, list, "库存工作单详情数据");
        return R.success();
    }

    /**
     * 获取库存工作单详情详细信息
     */
    @RequiresPermissions("product:detail:query")
    @GetMapping(value = "/{id}")
    public R<WmsWareOrderTaskDetail> getInfo(@PathVariable("id") Long id) {
        return R.success(wmsWareOrderTaskDetailService.selectWmsWareOrderTaskDetailById(id));
    }

    /**
     * 新增库存工作单详情
     */
    @RequiresPermissions("product:detail:add")
    @Log(title = "库存工作单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail) {
        return R.condition(wmsWareOrderTaskDetailService.insertWmsWareOrderTaskDetail(wmsWareOrderTaskDetail));
    }

    /**
     * 修改库存工作单详情
     */
    @RequiresPermissions("product:detail:edit")
    @Log(title = "库存工作单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody WmsWareOrderTaskDetail wmsWareOrderTaskDetail) {
        return R.condition(wmsWareOrderTaskDetailService.updateWmsWareOrderTaskDetail(wmsWareOrderTaskDetail));
    }

    /**
     * 删除库存工作单详情
     */
    @RequiresPermissions("product:detail:remove")
    @Log(title = "库存工作单详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(wmsWareOrderTaskDetailService.deleteWmsWareOrderTaskDetailByIds(ids));
    }
}
