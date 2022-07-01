package com.qinweizhao.order.controller;


import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsPaymentInfo;
import com.qinweizhao.order.service.IOmsPaymentInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 支付信息Controller
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@RestController
@RequestMapping("/info")
public class OmsPaymentInfoController {
    @Resource
    private IOmsPaymentInfoService omsPaymentInfoService;

    /**
     * 查询支付信息列表
     */
    @RequiresPermissions("order:info:list")
    @GetMapping("/list")
    public R<List<OmsPaymentInfo>> list(OmsPaymentInfo omsPaymentInfo) {
        List<OmsPaymentInfo> list = omsPaymentInfoService.selectOmsPaymentInfoList(omsPaymentInfo);
        return R.success(list);
    }

    /**
     * 导出支付信息列表
     */
    @RequiresPermissions("order:info:export")
    @Log(title = "支付信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsPaymentInfo omsPaymentInfo) {
        List<OmsPaymentInfo> list = omsPaymentInfoService.selectOmsPaymentInfoList(omsPaymentInfo);
        ExcelUtil<OmsPaymentInfo> util = new ExcelUtil<>(OmsPaymentInfo.class);
        util.exportExcel(response, list, "支付信息数据");
        return R.success();
    }

    /**
     * 获取支付信息详细信息
     */
    @RequiresPermissions("order:info:query")
    @GetMapping(value = "/{id}")
    public R<OmsPaymentInfo> getInfo(@PathVariable("id") Long id) {
        return R.success(omsPaymentInfoService.getById(id));
    }

    /**
     * 新增支付信息
     */
    @RequiresPermissions("order:info:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsPaymentInfo omsPaymentInfo) {
        return R.success(omsPaymentInfoService.save(omsPaymentInfo));
    }

    /**
     * 修改支付信息
     */
    @RequiresPermissions("order:info:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsPaymentInfo omsPaymentInfo) {
        return R.success(omsPaymentInfoService.updateById(omsPaymentInfo));
    }

    /**
     * 删除支付信息
     */
    @RequiresPermissions("order:info:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(omsPaymentInfoService.removeById(id));
    }
}
