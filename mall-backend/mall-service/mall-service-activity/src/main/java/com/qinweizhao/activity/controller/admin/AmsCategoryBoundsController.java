package com.qinweizhao.activity.controller.admin;

import com.qinweizhao.activity.model.entity.AmsCategoryBounds;
import com.qinweizhao.activity.service.IAmsCategoryBoundsService;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品分类积分设置Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/category/bounds")
public class AmsCategoryBoundsController {

    @Resource
    private IAmsCategoryBoundsService amsCategoryBoundsService;

    /**
     * 查询商品分类积分设置列表
     */
    @RequiresPermissions("activity:bounds:list")
    @GetMapping("/list")
    public R<List<AmsCategoryBounds>> list(AmsCategoryBounds amsCategoryBounds) {
        List<AmsCategoryBounds> list = amsCategoryBoundsService.selectAmsCategoryBoundsList(amsCategoryBounds);
        return R.success(list);
    }

    /**
     * 导出商品分类积分设置列表
     */
    @RequiresPermissions("activity:bounds:export")
    @Log(title = "商品分类积分设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsCategoryBounds amsCategoryBounds) {
        List<AmsCategoryBounds> list = amsCategoryBoundsService.selectAmsCategoryBoundsList(amsCategoryBounds);
        ExcelUtil<AmsCategoryBounds> util = new ExcelUtil<>(AmsCategoryBounds.class);
        util.exportExcel(response, list, "商品分类积分设置数据");
        return R.success();
    }

    /**
     * 获取商品分类积分设置详细信息
     */
    @RequiresPermissions("activity:bounds:query")
    @GetMapping(value = "/{id}")
    public R<AmsCategoryBounds> getInfo(@PathVariable("id") Long id) {
        return R.success(amsCategoryBoundsService.getById(id));
    }

    /**
     * 新增商品分类积分设置
     */
    @RequiresPermissions("activity:bounds:add")
    @Log(title = "商品分类积分设置", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsCategoryBounds amsCategoryBounds) {
        return R.success(amsCategoryBoundsService.save(amsCategoryBounds));
    }

    /**
     * 修改商品分类积分设置
     */
    @RequiresPermissions("activity:bounds:edit")
    @Log(title = "商品分类积分设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsCategoryBounds amsCategoryBounds) {
        return R.success(amsCategoryBoundsService.updateById(amsCategoryBounds));
    }

    /**
     * 删除商品分类积分设置
     */
    @RequiresPermissions("activity:bounds:remove")
    @Log(title = "商品分类积分设置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsCategoryBoundsService.removeById(id));
    }
}
