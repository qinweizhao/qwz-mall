package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.model.entity.AmsSpuBounds;
import com.qinweizhao.activity.service.IAmsSpuBoundsService;
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
 * 商品spu积分设置Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/bounds")
public class AmsSpuBoundsController {
    @Resource
    private IAmsSpuBoundsService amsSpuBoundsService;

    /**
     * 查询商品spu积分设置列表
     */
    @RequiresPermissions("activity:bounds:list")
    @GetMapping("/list")
    public R<List<AmsSpuBounds>> list(AmsSpuBounds amsSpuBounds) {

        List<AmsSpuBounds> list = amsSpuBoundsService.selectAmsSpuBoundsList(amsSpuBounds);
        return R.success(list);
    }

    /**
     * 导出商品spu积分设置列表
     */
    @RequiresPermissions("activity:bounds:export")
    @Log(title = "商品spu积分设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSpuBounds amsSpuBounds) {
        List<AmsSpuBounds> list = amsSpuBoundsService.selectAmsSpuBoundsList(amsSpuBounds);
        ExcelUtil<AmsSpuBounds> util = new ExcelUtil<AmsSpuBounds>(AmsSpuBounds.class);
        util.exportExcel(response, list, "商品spu积分设置数据");
        return R.success();
    }

    /**
     * 获取商品spu积分设置详细信息
     */
    @RequiresPermissions("activity:bounds:query")
    @GetMapping(value = "/{id}")
    public R<AmsSpuBounds> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSpuBoundsService.getById(id));
    }

    /**
     * 新增商品spu积分设置
     */
    @RequiresPermissions("activity:bounds:add")
    @Log(title = "商品spu积分设置", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSpuBounds amsSpuBounds) {
        return R.success(amsSpuBoundsService.save(amsSpuBounds));
    }

    /**
     * 修改商品spu积分设置
     */
    @RequiresPermissions("activity:bounds:edit")
    @Log(title = "商品spu积分设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSpuBounds amsSpuBounds) {
        return R.success(amsSpuBoundsService.updateById(amsSpuBounds));
    }

    /**
     * 删除商品spu积分设置
     */
    @RequiresPermissions("activity:bounds:remove")
    @Log(title = "商品spu积分设置", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsSpuBoundsService.removeById(id));
    }
}
