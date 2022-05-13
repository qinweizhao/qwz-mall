package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 商品三级分类 Controller
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
     * 分页
     */
    @RequiresPermissions("product:category:list")
    @GetMapping("/page")
    public R<PageResult<PmsCategory>> list(PmsCategory pmsCategory) {
        startPage();
        List<PmsCategory> list = pmsCategoryService.list(pmsCategory);
        return getPageResult(list);
    }


    /**
     * 树
     */
    @GetMapping("/tree")
    public R<List<Map<String, Object>>> tree(PmsCategory pmsCategory) {
        List<PmsCategory> list = pmsCategoryService.list(pmsCategory);
        return R.success(pmsCategoryService.buildCategoryTree(list));
    }


    /**
     * 详情
     */
    @RequiresPermissions("product:category:query")
    @GetMapping(value = "/{categoryId}")
    public R<PmsCategory> get(@PathVariable("categoryId") Long categoryId) {
        return R.success(pmsCategoryService.getById(categoryId));
    }


    /**
     * 新增
     */
    @RequiresPermissions("product:category:add")
    @Log(title = "商品三级分类", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsCategory pmsCategory) {
        return R.condition(pmsCategoryService.save(pmsCategory));
    }

    /**
     * 修改
     */
    @RequiresPermissions("product:category:edit")
    @Log(title = "商品三级分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsCategory pmsCategory) {
        return R.condition(pmsCategoryService.updateById(pmsCategory));
    }

    /**
     * 删除
     */
    @RequiresPermissions("product:category:remove")
    @Log(title = "商品三级分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{categoryIds}")
    public R<Void> remove(@PathVariable Long[] categoryIds) {
        return R.condition(pmsCategoryService.removeByIds(categoryIds));
    }
}
