package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.UmsMemberLoginLog;
import com.qinweizhao.product.service.IUmsMemberLoginLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员登录记录Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/log")
public class UmsMemberLoginLogController extends BaseController {
    @Resource
    private IUmsMemberLoginLogService umsMemberLoginLogService;

    /**
     * 查询会员登录记录列表
     */
    @RequiresPermissions("product:log:list")
    @GetMapping("/list")
    public R<List<UmsMemberLoginLog>> list(UmsMemberLoginLog umsMemberLoginLog) {
        startPage();
        List<UmsMemberLoginLog> list = umsMemberLoginLogService.selectUmsMemberLoginLogList(umsMemberLoginLog);
        return R.success(list);
    }

    /**
     * 导出会员登录记录列表
     */
    @RequiresPermissions("product:log:export")
    @Log(title = "会员登录记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMemberLoginLog umsMemberLoginLog) {
        List<UmsMemberLoginLog> list = umsMemberLoginLogService.selectUmsMemberLoginLogList(umsMemberLoginLog);
        ExcelUtil<UmsMemberLoginLog> util = new ExcelUtil<UmsMemberLoginLog>(UmsMemberLoginLog.class);
        util.exportExcel(response, list, "会员登录记录数据");
        return R.success();
    }

    /**
     * 获取会员登录记录详细信息
     */
    @RequiresPermissions("product:log:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberLoginLog> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberLoginLogService.selectUmsMemberLoginLogById(id));
    }

    /**
     * 新增会员登录记录
     */
    @RequiresPermissions("product:log:add")
    @Log(title = "会员登录记录", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMemberLoginLog umsMemberLoginLog) {
        return R.condition(umsMemberLoginLogService.insertUmsMemberLoginLog(umsMemberLoginLog));
    }

    /**
     * 修改会员登录记录
     */
    @RequiresPermissions("product:log:edit")
    @Log(title = "会员登录记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMemberLoginLog umsMemberLoginLog) {
        return R.condition(umsMemberLoginLogService.updateUmsMemberLoginLog(umsMemberLoginLog));
    }

    /**
     * 删除会员登录记录
     */
    @RequiresPermissions("product:log:remove")
    @Log(title = "会员登录记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(umsMemberLoginLogService.deleteUmsMemberLoginLogByIds(ids));
    }
}
