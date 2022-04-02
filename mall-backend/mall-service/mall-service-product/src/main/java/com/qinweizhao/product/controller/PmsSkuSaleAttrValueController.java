package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsSkuSaleAttrValue;
import com.qinweizhao.product.service.IPmsSkuSaleAttrValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * sku销售属性&值Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/value")
public class PmsSkuSaleAttrValueController extends BaseController {
    @Autowired
    private IPmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    /**
     * 查询sku销售属性&值列表
     */
    @RequiresPermissions("product:value:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
        startPage();
        List<PmsSkuSaleAttrValue> list = pmsSkuSaleAttrValueService.selectPmsSkuSaleAttrValueList(pmsSkuSaleAttrValue);
        return getDataTable(list);
    }

    /**
     * 导出sku销售属性&值列表
     */
    @RequiresPermissions("product:value:export")
    @Log(title = "sku销售属性&值" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
        List<PmsSkuSaleAttrValue> list = pmsSkuSaleAttrValueService.selectPmsSkuSaleAttrValueList(pmsSkuSaleAttrValue);
        ExcelUtil<PmsSkuSaleAttrValue> util = new ExcelUtil<PmsSkuSaleAttrValue>(PmsSkuSaleAttrValue.class);
        util.exportExcel(response, list, "sku销售属性&值数据");
    }

    /**
     * 获取sku销售属性&值详细信息
     */
    @RequiresPermissions("product:value:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(pmsSkuSaleAttrValueService.selectPmsSkuSaleAttrValueById(id));
    }

    /**
     * 新增sku销售属性&值
     */
    @RequiresPermissions("product:value:add")
    @Log(title = "sku销售属性&值" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
        return toAjax(pmsSkuSaleAttrValueService.insertPmsSkuSaleAttrValue(pmsSkuSaleAttrValue));
    }

    /**
     * 修改sku销售属性&值
     */
    @RequiresPermissions("product:value:edit")
    @Log(title = "sku销售属性&值" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
        return toAjax(pmsSkuSaleAttrValueService.updatePmsSkuSaleAttrValue(pmsSkuSaleAttrValue));
    }

    /**
     * 删除sku销售属性&值
     */
    @RequiresPermissions("product:value:remove")
    @Log(title = "sku销售属性&值" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(pmsSkuSaleAttrValueService.deletePmsSkuSaleAttrValueByIds(ids));
    }
}
