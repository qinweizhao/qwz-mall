package com.qinweizhao.ware.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.ware.model.entity.WmsPurchase;
import com.qinweizhao.ware.service.IWmsPurchaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 采购单Controller
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/purchase")
public class WmsPurchaseController  {

    @Resource
    private IWmsPurchaseService wmsPurchaseService;

    /**
     * 查询采购单列表
     */
    @RequiresPermissions("product:purchase:list")
    @GetMapping("/list")
    public R<List<WmsPurchase>> list(WmsPurchase wmsPurchase) {
        
        List<WmsPurchase> list = wmsPurchaseService.selectWmsPurchaseList(wmsPurchase);
        return R.success(list);
    }

    /**
     * 导出采购单列表
     */
    @RequiresPermissions("product:purchase:export")
    @Log(title = "采购单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, WmsPurchase wmsPurchase) {
        List<WmsPurchase> list = wmsPurchaseService.selectWmsPurchaseList(wmsPurchase);
        ExcelUtil<WmsPurchase> util = new ExcelUtil<WmsPurchase>(WmsPurchase.class);
        util.exportExcel(response, list, "采购单数据");
        return R.success();
    }

    /**
     * 获取采购单详细信息
     */
    @RequiresPermissions("product:purchase:query")
    @GetMapping(value = "/{id}")
    public R<WmsPurchase> getInfo(@PathVariable("id") Long id) {
        return R.success(wmsPurchaseService.selectWmsPurchaseById(id));
    }

    /**
     * 新增采购单
     */
    @RequiresPermissions("product:purchase:add")
    @Log(title = "采购单", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody WmsPurchase wmsPurchase) {
        return R.success(wmsPurchaseService.insertWmsPurchase(wmsPurchase));
    }

    /**
     * 修改采购单
     */
    @RequiresPermissions("product:purchase:edit")
    @Log(title = "采购单", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody WmsPurchase wmsPurchase) {
        return R.success(wmsPurchaseService.updateWmsPurchase(wmsPurchase));
    }

    /**
     * 删除采购单
     */
    @RequiresPermissions("product:purchase:remove")
    @Log(title = "采购单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(wmsPurchaseService.deleteWmsPurchaseByIds(ids));
    }
}
