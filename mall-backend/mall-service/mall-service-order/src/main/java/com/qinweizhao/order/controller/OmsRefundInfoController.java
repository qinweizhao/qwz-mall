package com.qinweizhao.order.controller;


import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsRefundInfo;
import com.qinweizhao.order.service.IOmsRefundInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 退款信息Controller
 *
 * @author qinweizhao
 * @date 2022-07-02
 */
@RestController
@RequestMapping("/info")
public class OmsRefundInfoController {
    @Resource
    private IOmsRefundInfoService omsRefundInfoService;

    /**
     * 查询退款信息列表
     */
    @RequiresPermissions("order:info:list")
    @GetMapping("/list")
    public R<List<OmsRefundInfo>> list(OmsRefundInfo omsRefundInfo) {
        List<OmsRefundInfo> list = omsRefundInfoService.selectOmsRefundInfoList(omsRefundInfo);
        return R.success(list);
    }

    /**
     * 导出退款信息列表
     */
    @RequiresPermissions("order:info:export")
    @Log(title = "退款信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsRefundInfo omsRefundInfo) {
        List<OmsRefundInfo> list = omsRefundInfoService.selectOmsRefundInfoList(omsRefundInfo);
        ExcelUtil<OmsRefundInfo> util = new ExcelUtil<>(OmsRefundInfo.class);
        util.exportExcel(response, list, "退款信息数据");
        return R.success();
    }

    /**
     * 获取退款信息详细信息
     */
    @RequiresPermissions("order:info:query")
    @GetMapping(value = "/{id}")
    public R<OmsRefundInfo> getInfo(@PathVariable("id") Long id) {
        return R.success(omsRefundInfoService.getById(id));
    }

    /**
     * 新增退款信息
     */
    @RequiresPermissions("order:info:add")
    @Log(title = "退款信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsRefundInfo omsRefundInfo) {
        return R.success(omsRefundInfoService.save(omsRefundInfo));
    }

    /**
     * 修改退款信息
     */
    @RequiresPermissions("order:info:edit")
    @Log(title = "退款信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsRefundInfo omsRefundInfo) {
        return R.success(omsRefundInfoService.updateById(omsRefundInfo));
    }

    /**
     * 删除退款信息
     */
    @RequiresPermissions("order:info:remove")
    @Log(title = "退款信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(omsRefundInfoService.removeById(id));
    }
}
