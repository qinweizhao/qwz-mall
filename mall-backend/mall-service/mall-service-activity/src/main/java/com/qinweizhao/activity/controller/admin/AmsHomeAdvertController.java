package com.qinweizhao.activity.controller.admin;

import com.qinweizhao.activity.model.entity.AmsHomeAdvert;
import com.qinweizhao.activity.model.param.HomeAdvertPageParam;
import com.qinweizhao.activity.service.IAmsHomeAdvertService;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 首页轮播广告Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@AllArgsConstructor
@RequestMapping("/home/advert")
public class AmsHomeAdvertController {

    private final IAmsHomeAdvertService amsHomeAdvertService;

    /**
     * 查询首页轮播广告分页
     */
    @RequiresPermissions("activity:advert:page")
    @GetMapping("/page")
    public R<PageResult<AmsHomeAdvert>> page(HomeAdvertPageParam pageParam) {
        PageResult<AmsHomeAdvert> page = amsHomeAdvertService.page(pageParam);
        return R.success(page);
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
