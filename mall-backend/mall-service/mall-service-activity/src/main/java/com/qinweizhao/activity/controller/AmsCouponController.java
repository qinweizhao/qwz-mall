package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.domain.AmsCoupon;
import com.qinweizhao.activity.service.IAmsCouponService;
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
 * 优惠券信息Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/coupon")
public class AmsCouponController {
    @Resource
    private IAmsCouponService amsCouponService;

    /**
     * 查询优惠券信息列表
     */
    @RequiresPermissions("activity:coupon:list")
    @GetMapping("/list")
    public R<List<AmsCoupon>> list(AmsCoupon amsCoupon) {

        List<AmsCoupon> list = amsCouponService.selectAmsCouponList(amsCoupon);
        return R.success(list);
    }

    /**
     * 导出优惠券信息列表
     */
    @RequiresPermissions("activity:coupon:export")
    @Log(title = "优惠券信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsCoupon amsCoupon) {
        List<AmsCoupon> list = amsCouponService.selectAmsCouponList(amsCoupon);
        ExcelUtil<AmsCoupon> util = new ExcelUtil<AmsCoupon>(AmsCoupon.class);
        util.exportExcel(response, list, "优惠券信息数据");
        return R.success();
    }

    /**
     * 获取优惠券信息详细信息
     */
    @RequiresPermissions("activity:coupon:query")
    @GetMapping(value = "/{id}")
    public R<AmsCoupon> getInfo(@PathVariable("id") Long id) {
        return R.success(amsCouponService.selectAmsCouponById(id));
    }

    /**
     * 新增优惠券信息
     */
    @RequiresPermissions("activity:coupon:add")
    @Log(title = "优惠券信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsCoupon amsCoupon) {
        return R.success(amsCouponService.insertAmsCoupon(amsCoupon));
    }

    /**
     * 修改优惠券信息
     */
    @RequiresPermissions("activity:coupon:edit")
    @Log(title = "优惠券信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsCoupon amsCoupon) {
        return R.success(amsCouponService.updateAmsCoupon(amsCoupon));
    }

    /**
     * 删除优惠券信息
     */
    @RequiresPermissions("activity:coupon:remove")
    @Log(title = "优惠券信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsCouponService.deleteAmsCouponByIds(ids));
    }
}
