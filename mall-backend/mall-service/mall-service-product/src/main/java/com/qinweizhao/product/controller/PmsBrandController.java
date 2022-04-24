package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsBrand;
import com.qinweizhao.product.service.IPmsBrandService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public R<PageResult<PmsBrand>> list(PmsBrand pmsBrand) {
        startPage();
        List<PmsBrand> list = pmsBrandService.selectPmsBrandList(pmsBrand);
        return getPageResult(list);
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
