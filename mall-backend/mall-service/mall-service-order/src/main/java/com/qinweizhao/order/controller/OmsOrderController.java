package com.qinweizhao.order.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsOrder;
import com.qinweizhao.order.service.IOmsOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/order")
public class OmsOrderController {

    @Resource
    private IOmsOrderService omsOrderService;

    /**
     * 查询订单列表
     */
    @RequiresPermissions("order:order:list")
    @GetMapping("/list")
    public R<List<OmsOrder>> list(OmsOrder omsOrder) {
        List<OmsOrder> list = omsOrderService.selectOmsOrderList(omsOrder);
        return R.success(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("order:order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsOrder omsOrder) {
        List<OmsOrder> list = omsOrderService.selectOmsOrderList(omsOrder);
        ExcelUtil<OmsOrder> util = new ExcelUtil<>(OmsOrder.class);
        util.exportExcel(response, list, "订单数据");
        return R.success();
    }

//    /**
//     * 获取订单详细信息
//     */
//    @RequiresPermissions("order:order:query")
//    @GetMapping(value = "/{id}")
//    public R<OmsOrder> getInfo(@PathVariable("id") Long id) {
//        return R.success(omsOrderService.getById(id));
//    }

    /**
     * 新增订单
     */
    @RequiresPermissions("order:order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsOrder omsOrder) {
        return R.success(omsOrderService.save(omsOrder));
    }

    /**
     * 修改订单
     */
    @RequiresPermissions("order:order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsOrder omsOrder) {
        return R.success(omsOrderService.updateById(omsOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("order:order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(omsOrderService.removeByIds(ids));
    }
}
