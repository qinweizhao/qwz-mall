package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.UmsMemberStatisticsInfo;
import com.qinweizhao.product.service.IUmsMemberStatisticsInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员统计信息Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/info")
public class UmsMemberStatisticsInfoController extends BaseController {
    @Resource
    private IUmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

    /**
     * 查询会员统计信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/list")
    public R<List<UmsMemberStatisticsInfo>> list(UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        startPage();
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
        return R.success(list);
    }

    /**
     * 导出会员统计信息列表
     */
    @RequiresPermissions("product:info:export")
    @Log(title = "会员统计信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        List<UmsMemberStatisticsInfo> list = umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoList(umsMemberStatisticsInfo);
        ExcelUtil<UmsMemberStatisticsInfo> util = new ExcelUtil<UmsMemberStatisticsInfo>(UmsMemberStatisticsInfo.class);
        util.exportExcel(response, list, "会员统计信息数据");
        return R.success();
    }

    /**
     * 获取会员统计信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberStatisticsInfo> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberStatisticsInfoService.selectUmsMemberStatisticsInfoById(id));
    }

    /**
     * 新增会员统计信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "会员统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return R.condition(umsMemberStatisticsInfoService.insertUmsMemberStatisticsInfo(umsMemberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "会员统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return R.condition(umsMemberStatisticsInfoService.updateUmsMemberStatisticsInfo(umsMemberStatisticsInfo));
    }

    /**
     * 删除会员统计信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "会员统计信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(umsMemberStatisticsInfoService.deleteUmsMemberStatisticsInfoByIds(ids));
    }
}
