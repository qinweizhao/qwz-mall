package com.qinweizhao.product.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.qinweizhao.modle.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSkuInfo;
import com.qinweizhao.product.service.IPmsSkuInfoService;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.page.TableDataInfo;

/**
 * sku信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/info")
public class PmsSkuInfoController extends BaseController {
    @Autowired
    private IPmsSkuInfoService pmsSkuInfoService;

    /**
     * 查询sku信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/list")
    public R<List<PmsSkuInfo>> list(PmsSkuInfo pmsSkuInfo) {
        startPage();
        List<PmsSkuInfo> list = pmsSkuInfoService.selectPmsSkuInfoList(pmsSkuInfo);
        return R.success(list);
    }

    /**
     * 导出sku信息列表
     */
    @RequiresPermissions("product:info:export")
    @Log(title = "sku信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsSkuInfo pmsSkuInfo) {
        List<PmsSkuInfo> list = pmsSkuInfoService.selectPmsSkuInfoList(pmsSkuInfo);
        ExcelUtil<PmsSkuInfo> util = new ExcelUtil<PmsSkuInfo>(PmsSkuInfo.class);
        util.exportExcel(response, list, "sku信息数据");
        return R.success();
    }

    /**
     * 获取sku信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{skuId}")
    public R<PmsSkuInfo> getInfo(@PathVariable("skuId") Long skuId) {
        return R.success(pmsSkuInfoService.selectPmsSkuInfoBySkuId(skuId));
    }

    /**
     * 新增sku信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "sku信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return R.condition(pmsSkuInfoService.insertPmsSkuInfo(pmsSkuInfo));
    }

    /**
     * 修改sku信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "sku信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsSkuInfo pmsSkuInfo) {
        return R.condition(pmsSkuInfoService.updatePmsSkuInfo(pmsSkuInfo));
    }

    /**
     * 删除sku信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "sku信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{skuIds}")
    public R<Void> remove(@PathVariable Long[] skuIds) {
        return R.condition(pmsSkuInfoService.deletePmsSkuInfoBySkuIds(skuIds));
    }
}
