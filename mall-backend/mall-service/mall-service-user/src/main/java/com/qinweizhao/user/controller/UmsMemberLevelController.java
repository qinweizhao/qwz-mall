package com.qinweizhao.user.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.user.entity.UmsMemberLevel;
import com.qinweizhao.user.service.UmsMemberLevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员等级Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/level")
public class UmsMemberLevelController extends BaseController {

    @Resource
    private UmsMemberLevelService umsMemberLevelService;

    /**
     * 查询会员等级列表
     */
    @RequiresPermissions("product:level:list")
    @GetMapping("/list")
    public R<PageResult<UmsMemberLevel>> list(UmsMemberLevel umsMemberLevel) {
        startPage();
        List<UmsMemberLevel> list = umsMemberLevelService.selectUmsMemberLevelList(umsMemberLevel);
        return getPageResult(list);
    }

    /**
     * 导出会员等级列表
     */
    @RequiresPermissions("product:level:export")
    @Log(title = "会员等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMemberLevel umsMemberLevel) {
        List<UmsMemberLevel> list = umsMemberLevelService.selectUmsMemberLevelList(umsMemberLevel);
        ExcelUtil<UmsMemberLevel> util = new ExcelUtil<UmsMemberLevel>(UmsMemberLevel.class);
        util.exportExcel(response, list, "会员等级数据");
        return R.success();
    }

    /**
     * 获取会员等级详细信息
     */
    @RequiresPermissions("product:level:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberLevel> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberLevelService.getById(id));
    }

    /**
     * 新增会员等级
     */
    @RequiresPermissions("product:level:add")
    @Log(title = "会员等级", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMemberLevel umsMemberLevel) {
        return R.condition(umsMemberLevelService.save(umsMemberLevel));
    }

    /**
     * 修改会员等级
     */
    @RequiresPermissions("product:level:edit")
    @Log(title = "会员等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMemberLevel umsMemberLevel) {
        return R.condition(umsMemberLevelService.updateById(umsMemberLevel));
    }

    /**
     * 删除会员等级
     */
    @RequiresPermissions("product:level:remove")
    @Log(title = "会员等级", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable List<Long> ids) {
        return R.condition(umsMemberLevelService.removeBatchByIds(ids));
    }
}
