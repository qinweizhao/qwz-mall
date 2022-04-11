package com.qinweizhao.product.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

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
import com.qinweizhao.product.domain.PmsBrand;
import com.qinweizhao.product.service.IPmsBrandService;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.page.TableDataInfo;

/**
 * 品牌Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/brand")
public class PmsBrandController extends BaseController {
    @Resource
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
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsBrand pmsBrand) {
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        ExcelUtil<PmsBrand> util = new ExcelUtil<PmsBrand>(PmsBrand.class);
        util.exportExcel(response, list, "品牌数据");
        return R.success();
    }

    /**
     * 获取品牌详细信息
     */
    @RequiresPermissions("product:brand:query")
    @GetMapping(value = "/{brandId}")
    public R<PmsBrand> getInfo(@PathVariable("brandId") Long brandId) {
        return R.success(pmsBrandService.selectPmsBrandByBrandId(brandId));
    }

    /**
     * 新增品牌
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsBrand pmsBrand) {
        return R.condition(pmsBrandService.insertPmsBrand(pmsBrand));
    }

    /**
     * 修改品牌
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsBrand pmsBrand) {
        return R.condition(pmsBrandService.updatePmsBrand(pmsBrand));
    }

    /**
     * 删除品牌
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
    @DeleteMapping("/{brandIds}")
    public R<Void> remove(@PathVariable Long[] brandIds) {
        return R.condition(pmsBrandService.deletePmsBrandByBrandIds(brandIds));
    }
}
