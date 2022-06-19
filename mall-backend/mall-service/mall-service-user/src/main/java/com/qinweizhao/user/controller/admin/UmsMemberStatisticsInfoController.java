package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.user.model.entity.UmsMemberStatisticsInfo;
import com.qinweizhao.user.service.UmsMemberStatisticsInfoService;
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
    private UmsMemberStatisticsInfoService umsMemberStatisticsInfoService;

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
    public R<?> export(HttpServletResponse response, UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
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
        return R.success(umsMemberStatisticsInfoService.getById(id));
    }

    /**
     * 新增会员统计信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "会员统计信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return R.success(umsMemberStatisticsInfoService.save(umsMemberStatisticsInfo));
    }

    /**
     * 修改会员统计信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "会员统计信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsMemberStatisticsInfo umsMemberStatisticsInfo) {
        return R.success(umsMemberStatisticsInfoService.updateById(umsMemberStatisticsInfo));
    }

    /**
     * 删除会员统计信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "会员统计信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsMemberStatisticsInfoService.removeBatchByIds(ids));
    }
}
