package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.domain.AmsMemberPrice;
import com.qinweizhao.activity.service.IAmsMemberPriceService;
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
 * 商品会员价格Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/price")
public class AmsMemberPriceController {
    @Resource
    private IAmsMemberPriceService amsMemberPriceService;

    /**
     * 查询商品会员价格列表
     */
    @RequiresPermissions("activity:price:list")
    @GetMapping("/list")
    public R<List<AmsMemberPrice>> list(AmsMemberPrice amsMemberPrice) {

        List<AmsMemberPrice> list = amsMemberPriceService.selectAmsMemberPriceList(amsMemberPrice);
        return R.success(list);
    }

    /**
     * 导出商品会员价格列表
     */
    @RequiresPermissions("activity:price:export")
    @Log(title = "商品会员价格", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsMemberPrice amsMemberPrice) {
        List<AmsMemberPrice> list = amsMemberPriceService.selectAmsMemberPriceList(amsMemberPrice);
        ExcelUtil<AmsMemberPrice> util = new ExcelUtil<AmsMemberPrice>(AmsMemberPrice.class);
        util.exportExcel(response, list, "商品会员价格数据");
        return R.success();
    }

    /**
     * 获取商品会员价格详细信息
     */
    @RequiresPermissions("activity:price:query")
    @GetMapping(value = "/{id}")
    public R<AmsMemberPrice> getInfo(@PathVariable("id") Long id) {
        return R.success(amsMemberPriceService.selectAmsMemberPriceById(id));
    }

    /**
     * 新增商品会员价格
     */
    @RequiresPermissions("activity:price:add")
    @Log(title = "商品会员价格", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsMemberPrice amsMemberPrice) {
        return R.success(amsMemberPriceService.insertAmsMemberPrice(amsMemberPrice));
    }

    /**
     * 修改商品会员价格
     */
    @RequiresPermissions("activity:price:edit")
    @Log(title = "商品会员价格", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsMemberPrice amsMemberPrice) {
        return R.success(amsMemberPriceService.updateAmsMemberPrice(amsMemberPrice));
    }

    /**
     * 删除商品会员价格
     */
    @RequiresPermissions("activity:price:remove")
    @Log(title = "商品会员价格", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable Long[] ids) {
        return R.success(amsMemberPriceService.deleteAmsMemberPriceByIds(ids));
    }
}
