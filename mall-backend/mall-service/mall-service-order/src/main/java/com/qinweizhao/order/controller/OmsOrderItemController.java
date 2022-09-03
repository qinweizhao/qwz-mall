package com.qinweizhao.order.controller;


import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.order.model.entity.OmsOrderItem;
import com.qinweizhao.order.service.IOmsOrderItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 订单项信息Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/item")
public class OmsOrderItemController {

    @Resource
    private IOmsOrderItemService omsOrderItemService;

    /**
     * 查询订单项信息列表
     */
    @RequiresPermissions("order:item:list")
    @GetMapping("/list")
    public R<List<OmsOrderItem>> list(OmsOrderItem omsOrderItem) {
        List<OmsOrderItem> list = omsOrderItemService.selectOmsOrderItemList(omsOrderItem);
        return R.success(list);
    }

    /**
     * 导出订单项信息列表
     */
    @RequiresPermissions("order:item:export")
    @Log(title = "订单项信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, OmsOrderItem omsOrderItem) {
        List<OmsOrderItem> list = omsOrderItemService.selectOmsOrderItemList(omsOrderItem);
        ExcelUtil<OmsOrderItem> util = new ExcelUtil<>(OmsOrderItem.class);
        util.exportExcel(response, list, "订单项信息数据");
        return R.success();
    }

//    /**
//     * 获取订单项信息详细信息
//     */
//    @RequiresPermissions("order:item:query")
//    @GetMapping(value = "/{id}")
//    public R<OmsOrderItem> getInfo(@PathVariable("id") Long id) {
//        return R.success(omsOrderItemService.getById(id));
//    }

    /**
     * 新增订单项信息
     */
    @RequiresPermissions("order:item:add")
    @Log(title = "订单项信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody OmsOrderItem omsOrderItem) {
        return R.success(omsOrderItemService.save(omsOrderItem));
    }

    /**
     * 修改订单项信息
     */
    @RequiresPermissions("order:item:edit")
    @Log(title = "订单项信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody OmsOrderItem omsOrderItem) {
        return R.success(omsOrderItemService.updateById(omsOrderItem));
    }

    /**
     * 删除订单项信息
     */
    @RequiresPermissions("order:item:remove")
    @Log(title = "订单项信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(omsOrderItemService.removeById(id));
    }
}
