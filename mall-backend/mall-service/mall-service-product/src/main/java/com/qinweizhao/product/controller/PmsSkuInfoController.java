package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSkuInfo;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * sku信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/sku/info")
public class PmsSkuInfoController extends BaseController {
    @Autowired
    private IPmsSkuInfoService pmsSkuInfoService;

    /**
     * 查询sku信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSkuInfo pmsSkuInfo) {
        startPage();
        List<PmsSkuInfo> list = pmsSkuInfoService.selectPmsSkuInfoList(pmsSkuInfo);
        return getDataTable(list);
    }

    /**
     * 导出sku信息列表
     */
    @RequiresPermissions("product:info:export")
    @Log(title = "sku信息" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSkuInfo pmsSkuInfo) {
        List<PmsSkuInfo> list = pmsSkuInfoService.selectPmsSkuInfoList(pmsSkuInfo);
        ExcelUtil<PmsSkuInfo> util = new ExcelUtil<PmsSkuInfo>(PmsSkuInfo.class);
        util.exportExcel(response, list, "sku信息数据");
    }

    /**
     * 获取sku信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{skuId}")
    public AjaxResult getInfo(@PathVariable("skuId") Long skuId) {
        return AjaxResult.success(pmsSkuInfoService.selectPmsSkuInfoBySkuId(skuId));
    }

    /**
     * 新增sku信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "sku信息" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return toAjax(pmsSkuInfoService.insertPmsSkuInfo(pmsSkuInfo));
    }

    /**
     * 修改sku信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "sku信息" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return toAjax(pmsSkuInfoService.updatePmsSkuInfo(pmsSkuInfo));
    }

    /**
     * 删除sku信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "sku信息" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{skuIds}")
    public AjaxResult remove(@PathVariable Long[] skuIds) {
        return toAjax(pmsSkuInfoService.deletePmsSkuInfoBySkuIds(skuIds));
    }
}
