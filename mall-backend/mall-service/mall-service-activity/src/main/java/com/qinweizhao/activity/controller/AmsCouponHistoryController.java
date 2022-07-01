package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.model.entity.AmsCouponHistory;
import com.qinweizhao.activity.service.IAmsCouponHistoryService;
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
 * 优惠券领取历史记录Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/history")
public class AmsCouponHistoryController {
    @Resource
    private IAmsCouponHistoryService amsCouponHistoryService;

    /**
     * 查询优惠券领取历史记录列表
     */
    @RequiresPermissions("activity:history:list")
    @GetMapping("/list")
    public R<List<AmsCouponHistory>> list(AmsCouponHistory amsCouponHistory) {

        List<AmsCouponHistory> list = amsCouponHistoryService.selectAmsCouponHistoryList(amsCouponHistory);
        return R.success(list);
    }

    /**
     * 导出优惠券领取历史记录列表
     */
    @RequiresPermissions("activity:history:export")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsCouponHistory amsCouponHistory) {
        List<AmsCouponHistory> list = amsCouponHistoryService.selectAmsCouponHistoryList(amsCouponHistory);
        ExcelUtil<AmsCouponHistory> util = new ExcelUtil<AmsCouponHistory>(AmsCouponHistory.class);
        util.exportExcel(response, list, "优惠券领取历史记录数据");
        return R.success();
    }

    /**
     * 获取优惠券领取历史记录详细信息
     */
    @RequiresPermissions("activity:history:query")
    @GetMapping(value = "/{id}")
    public R<AmsCouponHistory> getInfo(@PathVariable("id") Long id) {
        return R.success(amsCouponHistoryService.getById(id));
    }

    /**
     * 新增优惠券领取历史记录
     */
    @RequiresPermissions("activity:history:add")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsCouponHistory amsCouponHistory) {
        return R.success(amsCouponHistoryService.save(amsCouponHistory));
    }

    /**
     * 修改优惠券领取历史记录
     */
    @RequiresPermissions("activity:history:edit")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsCouponHistory amsCouponHistory) {
        return R.success(amsCouponHistoryService.updateById(amsCouponHistory));
    }

    /**
     * 删除优惠券领取历史记录
     */
    @RequiresPermissions("activity:history:remove")
    @Log(title = "优惠券领取历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsCouponHistoryService.removeById(id));
    }
}
