package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.web.page.TableDataInfo;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsBrand;
import com.qinweizhao.product.service.IPmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 品牌Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController extends BaseController {
    @Autowired
    private IPmsBrandService pmsBrandService;

    /**
     * 查询品牌列表
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/list")
    public TableDataInfo list(PmsBrand pmsBrand) {
        startPage();
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @RequiresPermissions("product:brand:export")
    @Log(title = "品牌" , businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsBrand pmsBrand) {
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        ExcelUtil<PmsBrand> util = new ExcelUtil<PmsBrand>(PmsBrand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId) {
        return AjaxResult.success(pmsBrandService.selectPmsBrandByBrandId(brandId));
    }

    /**
     * 新增品牌
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "品牌" , businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsBrand pmsBrand) {
        return toAjax(pmsBrandService.insertPmsBrand(pmsBrand));
    }

    /**
     * 修改品牌
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌" , businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsBrand pmsBrand) {
        return toAjax(pmsBrandService.updatePmsBrand(pmsBrand));
    }

    /**
     * 删除品牌
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌" , businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds) {
        return toAjax(pmsBrandService.deletePmsBrandByBrandIds(brandIds));
    }
}
