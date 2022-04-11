package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.log.annotation.Log;
import com.qinweizhao.common.log.enums.BusinessType;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.PmsCategory;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品三级分类Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/category")
public class PmsCategoryController extends BaseController {
    @Resource
    private IPmsCategoryService pmsCategoryService;

    /**
     * 查询商品三级分类列表
     */
    @RequiresPermissions("product:category:list")
    @GetMapping("/list")
    public R<List<PmsCategory>> list(PmsCategory pmsCategory) {
        startPage();
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryList(pmsCategory);
        return R.success(list);
    }

    /**
     * 导出商品三级分类列表
     */
    @RequiresPermissions("product:category:export")
    @Log(title = "商品三级分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsCategory pmsCategory) {
        List<PmsCategory> list = pmsCategoryService.selectPmsCategoryList(pmsCategory);
        ExcelUtil<PmsCategory> util = new ExcelUtil<PmsCategory>(PmsCategory.class);
        util.exportExcel(response, list, "商品三级分类数据");
        return R.success();
    }

    /**
     * 获取商品三级分类详细信息
     */
    @RequiresPermissions("product:category:query")
    @GetMapping(value = "/{categoryId}")
    public R<PmsCategory> getInfo(@PathVariable("categoryId") Long categoryId) {
        return R.success(pmsCategoryService.selectPmsCategoryByCategoryId(categoryId));
    }

    /**
     * 新增商品三级分类
     */
    @RequiresPermissions("product:category:add")
    @Log(title = "商品三级分类", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsCategory pmsCategory) {
        return R.condition(pmsCategoryService.insertPmsCategory(pmsCategory));
    }

    /**
     * 修改商品三级分类
     */
    @RequiresPermissions("product:category:edit")
    @Log(title = "商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsCategory pmsCategory) {
        return R.condition(pmsCategoryService.updatePmsCategory(pmsCategory));
    }

    /**
     * 删除商品三级分类
     */
    @RequiresPermissions("product:category:remove")
    @Log(title = "商品三级分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{categoryIds}")
    public R<Void> remove(@PathVariable Long[] categoryIds) {
        return R.condition(pmsCategoryService.deletePmsCategoryByCategoryIds(categoryIds));
    }
}
