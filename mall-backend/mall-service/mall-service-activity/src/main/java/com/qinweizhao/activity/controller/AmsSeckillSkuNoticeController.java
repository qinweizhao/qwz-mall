package com.qinweizhao.activity.controller;

import com.qinweizhao.activity.model.entity.AmsSeckillSkuNotice;
import com.qinweizhao.activity.service.IAmsSeckillSkuNoticeService;
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
 * 秒杀商品通知订阅Controller
 *
 * @author qinweizhao
 * @date 2022-07-01
 */
@RestController
@RequestMapping("/notice")
public class AmsSeckillSkuNoticeController {
    @Resource
    private IAmsSeckillSkuNoticeService amsSeckillSkuNoticeService;

    /**
     * 查询秒杀商品通知订阅列表
     */
    @RequiresPermissions("activity:notice:list")
    @GetMapping("/list")
    public R<List<AmsSeckillSkuNotice>> list(AmsSeckillSkuNotice amsSeckillSkuNotice) {

        List<AmsSeckillSkuNotice> list = amsSeckillSkuNoticeService.selectAmsSeckillSkuNoticeList(amsSeckillSkuNotice);
        return R.success(list);
    }

    /**
     * 导出秒杀商品通知订阅列表
     */
    @RequiresPermissions("activity:notice:export")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, AmsSeckillSkuNotice amsSeckillSkuNotice) {
        List<AmsSeckillSkuNotice> list = amsSeckillSkuNoticeService.selectAmsSeckillSkuNoticeList(amsSeckillSkuNotice);
        ExcelUtil<AmsSeckillSkuNotice> util = new ExcelUtil<AmsSeckillSkuNotice>(AmsSeckillSkuNotice.class);
        util.exportExcel(response, list, "秒杀商品通知订阅数据");
        return R.success();
    }

    /**
     * 获取秒杀商品通知订阅详细信息
     */
    @RequiresPermissions("activity:notice:query")
    @GetMapping(value = "/{id}")
    public R<AmsSeckillSkuNotice> getInfo(@PathVariable("id") Long id) {
        return R.success(amsSeckillSkuNoticeService.getById(id));
    }

    /**
     * 新增秒杀商品通知订阅
     */
    @RequiresPermissions("activity:notice:add")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody AmsSeckillSkuNotice amsSeckillSkuNotice) {
        return R.success(amsSeckillSkuNoticeService.save(amsSeckillSkuNotice));
    }

    /**
     * 修改秒杀商品通知订阅
     */
    @RequiresPermissions("activity:notice:edit")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody AmsSeckillSkuNotice amsSeckillSkuNotice) {
        return R.success(amsSeckillSkuNoticeService.updateById(amsSeckillSkuNotice));
    }

    /**
     * 删除秒杀商品通知订阅
     */
    @RequiresPermissions("activity:notice:remove")
    @Log(title = "秒杀商品通知订阅", businessType = BusinessType.DELETE)
    @DeleteMapping("/{id}")
    public R<?> remove(@PathVariable Long id) {
        return R.success(amsSeckillSkuNoticeService.removeById(id));
    }
}
