package com.qinweizhao.sale.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.sale.model.entity.SmsHomeAdvert;
import com.qinweizhao.sale.model.param.HomeAdvertPageParam;
import com.qinweizhao.sale.service.SmsHomeAdvertService;
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

    private final SmsHomeAdvertService smsHomeAdvertService;

    /**
     * 查询首页轮播广告分页
     */
    @RequiresPermissions("sale:advert:page")
    @GetMapping("/page")
    public R<PageResult<SmsHomeAdvert>> page(HomeAdvertPageParam pageParam) {
        PageResult<SmsHomeAdvert> page = smsHomeAdvertService.page(pageParam);
        return R.success(page);
    }

    /**
     * 获取首页轮播广告详细信息
     */
    @RequiresPermissions("sale:advert:query")
    @GetMapping(value = "/{id}")
    public R<SmsHomeAdvert> getInfo(@PathVariable("id") Long id) {
        // todo
        return R.success();
    }

    /**
     * 新增首页轮播广告
     */
    @RequiresPermissions("sale:advert:add")
    @Log(title = "首页轮播广告", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody SmsHomeAdvert smsHomeAdvert) {
        return R.success(smsHomeAdvertService.save(smsHomeAdvert));
    }

    /**
     * 修改首页轮播广告
     */
    @RequiresPermissions("sale:advert:edit")
    @Log(title = "首页轮播广告", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody SmsHomeAdvert smsHomeAdvert) {
        return R.success(smsHomeAdvertService.updateById(smsHomeAdvert));
    }

    /**
     * 删除首页轮播广告
     */
    @RequiresPermissions("sale:advert:remove")
    @Log(title = "首页轮播广告", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(smsHomeAdvertService.removeById(id));
    }
}
