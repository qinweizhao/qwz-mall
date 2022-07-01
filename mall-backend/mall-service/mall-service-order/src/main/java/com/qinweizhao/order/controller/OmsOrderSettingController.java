package com.qinweizhao.order.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsOrderSetting;
import com.qinweizhao.order.service.IOmsOrderSettingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单配置信息Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/setting")
public class OmsOrderSettingController extends BaseController {
    @Resource
    private IOmsOrderSettingService omsOrderSettingService;

    /**
     * 查询订单配置信息列表
     */
    @RequiresPermissions("order:setting:list")
    @GetMapping("/list")
    public R<List<OmsOrderSetting>> list(OmsOrderSetting omsOrderSetting) {
        startPage();
        List<OmsOrderSetting> list = omsOrderSettingService.selectOmsOrderSettingList(omsOrderSetting);
        return R.success(list);
    }

    /**
     * 导出订单配置信息列表
     */
    @RequiresPermissions("order:setting:export")
    @Log(title = "订单配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsOrderSetting omsOrderSetting) {
        List<OmsOrderSetting> list = omsOrderSettingService.selectOmsOrderSettingList(omsOrderSetting);
        ExcelUtil<OmsOrderSetting> util = new ExcelUtil<OmsOrderSetting>(OmsOrderSetting.class);
        util.exportExcel(response, list, "订单配置信息数据");
        return R.success();
    }

    /**
     * 获取订单配置信息详细信息
     */
    @RequiresPermissions("order:setting:query")
    @GetMapping(value = "/{id}")
    public R<OmsOrderSetting> getInfo(@PathVariable("id") Long id) {
        return R.success(omsOrderSettingService.selectOmsOrderSettingById(id));
    }

    /**
     * 新增订单配置信息
     */
    @RequiresPermissions("order:setting:add")
    @Log(title = "订单配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsOrderSetting omsOrderSetting) {
        return R.success(omsOrderSettingService.insertOmsOrderSetting(omsOrderSetting));
    }

    /**
     * 修改订单配置信息
     */
    @RequiresPermissions("order:setting:edit")
    @Log(title = "订单配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsOrderSetting omsOrderSetting) {
        return R.success(omsOrderSettingService.updateOmsOrderSetting(omsOrderSetting));
    }

    /**
     * 删除订单配置信息
     */
    @RequiresPermissions("order:setting:remove")
    @Log(title = "订单配置信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(omsOrderSettingService.deleteOmsOrderSettingByIds(ids));
    }
}
