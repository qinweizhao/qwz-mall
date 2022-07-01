package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.service.IAmsHomeAdvertService;
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
 * 首页轮播广告Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/advert")
public class AmsHomeAdvertController {
    @Resource
    private IAmsHomeAdvertService amsHomeAdvertService;

    /**
     * 查询首页轮播广告列表
     */
    @RequiresPermissions("activity:advert:list")
    @GetMapping("/list")
    public R<List<AmsHomeAdvert>> list(AmsHomeAdvert amsHomeAdvert) {

        List<AmsHomeAdvert> list = amsHomeAdvertService.selectAmsHomeAdvertList(amsHomeAdvert);
        return R.success(list);
    }

    /**
     * 导出首页轮播广告列表
     */
    @RequiresPermissions("activity:advert:export")
    @Log(title = "首页轮播广告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsHomeAdvert amsHomeAdvert) {
        List<AmsHomeAdvert> list = amsHomeAdvertService.selectAmsHomeAdvertList(amsHomeAdvert);
        ExcelUtil<AmsHomeAdvert> util = new ExcelUtil<AmsHomeAdvert>(AmsHomeAdvert.class);
        util.exportExcel(response, list, "首页轮播广告数据");
        return R.success();
    }

    /**
     * 获取首页轮播广告详细信息
     */
    @RequiresPermissions("activity:advert:query")
    @GetMapping(value = "/{id}")
    public R<AmsHomeAdvert> getInfo(@PathVariable("id") Long id) {
        return R.success(amsHomeAdvertService.getById(id));
    }

    /**
     * 新增首页轮播广告
     */
    @RequiresPermissions("activity:advert:add")
    @Log(title = "首页轮播广告", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsHomeAdvert amsHomeAdvert) {
        return R.success(amsHomeAdvertService.save(amsHomeAdvert));
    }

    /**
     * 修改首页轮播广告
     */
    @RequiresPermissions("activity:advert:edit")
    @Log(title = "首页轮播广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsHomeAdvert amsHomeAdvert) {
        return R.success(amsHomeAdvertService.updateById(amsHomeAdvert));
    }

    /**
     * 删除首页轮播广告
     */
    @RequiresPermissions("activity:advert:remove")
    @Log(title = "首页轮播广告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsHomeAdvertService.removeById(id));
    }
}
