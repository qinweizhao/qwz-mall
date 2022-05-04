package com.qinweizhao.ware.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.ware.domain.WmsPurchaseDetail;
import com.qinweizhao.ware.service.IWmsPurchaseDetailService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 采购单详情Controller
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/detail")
public class WmsPurchaseDetailController extends BaseController {
    @Resource
    private IWmsPurchaseDetailService wmsPurchaseDetailService;

    /**
     * 查询采购单详情列表
     */
    @RequiresPermissions("product:detail:list")
    @GetMapping("/list")
    public R<List<WmsPurchaseDetail>> list(WmsPurchaseDetail wmsPurchaseDetail) {
        startPage();
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.selectWmsPurchaseDetailList(wmsPurchaseDetail);
        return R.success(list);
    }

    /**
     * 导出采购单详情列表
     */
    @RequiresPermissions("product:detail:export")
    @Log(title = "采购单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, WmsPurchaseDetail wmsPurchaseDetail) {
        List<WmsPurchaseDetail> list = wmsPurchaseDetailService.selectWmsPurchaseDetailList(wmsPurchaseDetail);
        ExcelUtil<WmsPurchaseDetail> util = new ExcelUtil<WmsPurchaseDetail>(WmsPurchaseDetail.class);
        util.exportExcel(response, list, "采购单详情数据");
        return R.success();
    }

    /**
     * 获取采购单详情详细信息
     */
    @RequiresPermissions("product:detail:query")
    @GetMapping(value = "/{id}")
    public R<WmsPurchaseDetail> getInfo(@PathVariable("id") Long id) {
        return R.success(wmsPurchaseDetailService.selectWmsPurchaseDetailById(id));
    }

    /**
     * 新增采购单详情
     */
    @RequiresPermissions("product:detail:add")
    @Log(title = "采购单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody WmsPurchaseDetail wmsPurchaseDetail) {
        return R.condition(wmsPurchaseDetailService.insertWmsPurchaseDetail(wmsPurchaseDetail));
    }

    /**
     * 修改采购单详情
     */
    @RequiresPermissions("product:detail:edit")
    @Log(title = "采购单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody WmsPurchaseDetail wmsPurchaseDetail) {
        return R.condition(wmsPurchaseDetailService.updateWmsPurchaseDetail(wmsPurchaseDetail));
    }

    /**
     * 删除采购单详情
     */
    @RequiresPermissions("product:detail:remove")
    @Log(title = "采购单详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(wmsPurchaseDetailService.deleteWmsPurchaseDetailByIds(ids));
    }
}
