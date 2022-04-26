package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsCategoryBrand;
import com.qinweizhao.product.service.IPmsBrandService;
import com.qinweizhao.product.service.IPmsCategoryBrandService;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 分类&品牌关联Controller
 *
 * @author qinweizhao
 * @date 2022-04-24
 */
@RestController
@RequestMapping("/brand/category")
public class PmsCategoryBrandController extends BaseController {

    @Resource
    private IPmsCategoryBrandService pmsCategoryBrandService;

    @Resource
    private IPmsCategoryService pmsCategoryService;

    @Resource
    private IPmsBrandService pmsBrandService;

    /**
     * 查询分类&品牌关联列表
     */
    @RequiresPermissions("product:brand:list")
    @GetMapping("/list")
    public R<List<PmsCategoryBrand>> list(PmsCategoryBrand pmsCategoryBrand) {
        startPage();
        List<PmsCategoryBrand> list = pmsCategoryBrandService.selectPmsCategoryBrandList(pmsCategoryBrand);
        return R.success(list);
    }

    /**
     * 获取品牌详细信息
     */
    @RequiresPermissions("product:brand:relation")
    @GetMapping(value = "/{brandId}")
    public R<List<PmsCategoryBrand>> get(@PathVariable("brandId") Long brandId) {
        return R.success(pmsCategoryBrandService.selectPmsCategoryBrandByBrandId(brandId));
    }

    /**
     * 导出分类&品牌关联列表
     */
    @RequiresPermissions("product:brand:export")
    @Log(title = "分类&品牌关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsCategoryBrand pmsCategoryBrand) {
        List<PmsCategoryBrand> list = pmsCategoryBrandService.selectPmsCategoryBrandList(pmsCategoryBrand);
        ExcelUtil<PmsCategoryBrand> util = new ExcelUtil<PmsCategoryBrand>(PmsCategoryBrand.class);
        util.exportExcel(response, list, "分类&品牌关联数据");
        return R.success();
    }

    /**
     * 新增分类&品牌关联
     */
    @RequiresPermissions("product:brand:add")
    @Log(title = "分类&品牌关联", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsCategoryBrand pmsCategoryBrand) {
        pmsCategoryBrand.setCategoryName(pmsCategoryService.selectPmsCategoryByCategoryId(pmsCategoryBrand.getCategoryId()).getName());
        pmsCategoryBrand.setBrandName(pmsBrandService.selectPmsBrandByBrandId(pmsCategoryBrand.getBrandId()).getName());
        return R.condition(pmsCategoryBrandService.insertPmsCategoryBrand(pmsCategoryBrand));
    }

    /**
     * 修改分类&品牌关联
     */
    @RequiresPermissions("product:brand:edit")
    @Log(title = "分类&品牌关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsCategoryBrand pmsCategoryBrand) {
        return R.condition(pmsCategoryBrandService.updatePmsCategoryBrand(pmsCategoryBrand));
    }

    /**
     * 删除分类&品牌关联
     */
    @RequiresPermissions("product:brand:remove")
    @Log(title = "分类&品牌关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<Void> remove(@PathVariable Long[] id) {
        return R.condition(pmsCategoryBrandService.deletePmsCategoryBrandByIds(id));
    }


}
