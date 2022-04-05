package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.core.web.domain.AjaxResult;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.product.domain.PmsCategory;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品三级分类Controller
 *
 * @author qinweizhao
 * @date 2022-04-03
 */
@RestController
@RequestMapping("/category")
public class PmsCategoryController extends BaseController {
    @Autowired
    private IPmsCategoryService pmsCategoryService;

    /**
     * 查询商品三级分类列表
     */
    @RequiresPermissions("product:category:list")
    @GetMapping("/list")
    public AjaxResult list(PmsCategory pmsCategory) {
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryList(pmsCategory);
        return AjaxResult.success(list);
    }

    /**
     * 导出商品三级分类列表
     */
    @RequiresPermissions("product:category:export")
    @Log(title = "商品三级分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PmsCategory pmsCategory) {
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryList(pmsCategory);
        ExcelUtil<PmsCategory> util = new ExcelUtil<PmsCategory>(PmsCategory.class);
        util.exportExcel(response, list, "商品三级分类数据");
    }

    /**
     * 获取商品三级分类详细信息
     */
    @RequiresPermissions("product:category:query")
    @GetMapping(value = "/{catId}")
    public AjaxResult getInfo(@PathVariable("catId") Long catId) {
        return AjaxResult.success(pmsCategoryService.selectPmsCategoryByCatId(catId));
    }

    /**
     * 新增商品三级分类
     */
    @RequiresPermissions("product:category:add")
    @Log(title = "商品三级分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PmsCategory pmsCategory) {
        return toAjax(pmsCategoryService.insertPmsCategory(pmsCategory));
    }

    /**
     * 修改商品三级分类
     */
    @RequiresPermissions("product:category:edit")
    @Log(title = "商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PmsCategory pmsCategory) {
        return toAjax(pmsCategoryService.updatePmsCategory(pmsCategory));
    }

    /**
     * 删除商品三级分类
     */
    @RequiresPermissions("product:category:remove")
    @Log(title = "商品三级分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{catIds}")
    public AjaxResult remove(@PathVariable Long[] catIds) {
        return toAjax(pmsCategoryService.deletePmsCategoryByCatIds(catIds));
    }
}
