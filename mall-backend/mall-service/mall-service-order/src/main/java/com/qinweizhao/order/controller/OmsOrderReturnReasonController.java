package com.qinweizhao.order.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsOrderReturnReason;
import com.qinweizhao.order.service.IOmsOrderReturnReasonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 退货原因Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/reason")
public class OmsOrderReturnReasonController {
    @Resource
    private IOmsOrderReturnReasonService omsOrderReturnReasonService;

    /**
     * 查询退货原因列表
     */
    @RequiresPermissions("order:reason:list")
    @GetMapping("/list")
    public R<List<OmsOrderReturnReason>> list(OmsOrderReturnReason omsOrderReturnReason) {

        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.selectOmsOrderReturnReasonList(omsOrderReturnReason);
        return R.success(list);
    }

    /**
     * 导出退货原因列表
     */
    @RequiresPermissions("order:reason:export")
    @Log(title = "退货原因", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsOrderReturnReason omsOrderReturnReason) {
        List<OmsOrderReturnReason> list = omsOrderReturnReasonService.selectOmsOrderReturnReasonList(omsOrderReturnReason);
        ExcelUtil<OmsOrderReturnReason> util = new ExcelUtil<>(OmsOrderReturnReason.class);
        util.exportExcel(response, list, "退货原因数据");
        return R.success();
    }

    /**
     * 获取退货原因详细信息
     */
    @RequiresPermissions("order:reason:query")
    @GetMapping(value = "/{id}")
    public R<OmsOrderReturnReason> getInfo(@PathVariable("id") Long id) {
        return R.success(omsOrderReturnReasonService.getById(id));
    }

    /**
     * 新增退货原因
     */
    @RequiresPermissions("order:reason:add")
    @Log(title = "退货原因", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsOrderReturnReason omsOrderReturnReason) {
        return R.success(omsOrderReturnReasonService.save(omsOrderReturnReason));
    }

    /**
     * 修改退货原因
     */
    @RequiresPermissions("order:reason:edit")
    @Log(title = "退货原因", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsOrderReturnReason omsOrderReturnReason) {
        return R.success(omsOrderReturnReasonService.updateById(omsOrderReturnReason));
    }

    /**
     * 删除退货原因
     */
    @RequiresPermissions("order:reason:remove")
    @Log(title = "退货原因", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(omsOrderReturnReasonService.removeById(id));
    }
}
