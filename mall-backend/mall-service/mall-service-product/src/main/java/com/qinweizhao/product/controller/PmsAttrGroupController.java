package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.entity.PmsAttrGroup;
import com.qinweizhao.product.service.IPmsAttrGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 属性分组Controller
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@RestController
@RequestMapping("/attr-group")
public class PmsAttrGroupController extends BaseController {
    @Resource
    private IPmsAttrGroupService pmsAttrGroupService;

    /**
     * 查询属性分组列表
     */
    @RequiresPermissions("product:group:list")
    @GetMapping("/list")
    public R<List<PmsAttrGroup>> list(PmsAttrGroup pmsAttrGroup) {
        startPage();
        List<PmsAttrGroup> list = pmsAttrGroupService.selectPmsAttrGroupList(pmsAttrGroup);
        return R.success(list);
    }

    /**
     * 导出属性分组列表
     */
    @RequiresPermissions("product:group:export")
    @Log(title = "属性分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, PmsAttrGroup pmsAttrGroup) {
        List<PmsAttrGroup> list = pmsAttrGroupService.selectPmsAttrGroupList(pmsAttrGroup);
        ExcelUtil<PmsAttrGroup> util = new ExcelUtil<PmsAttrGroup>(PmsAttrGroup.class);
        util.exportExcel(response, list, "属性分组数据");
        return R.success();
    }

    /**
     * 获取属性分组详细信息
     */
    @RequiresPermissions("product:group:query")
    @GetMapping(value = "/{attrGroupId}")
    public R<PmsAttrGroup> getInfo(@PathVariable("attrGroupId") Long attrGroupId) {
        return R.success(pmsAttrGroupService.selectPmsAttrGroupByAttrGroupId(attrGroupId));
    }

    /**
     * 新增属性分组
     */
    @RequiresPermissions("product:group:add")
    @Log(title = "属性分组", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return R.condition(pmsAttrGroupService.insertPmsAttrGroup(pmsAttrGroup));
    }

    /**
     * 修改属性分组
     */
    @RequiresPermissions("product:group:edit")
    @Log(title = "属性分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody PmsAttrGroup pmsAttrGroup) {
        return R.condition(pmsAttrGroupService.updatePmsAttrGroup(pmsAttrGroup));
    }

    /**
     * 删除属性分组
     */
    @RequiresPermissions("product:group:remove")
    @Log(title = "属性分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrGroupIds}")
    public R<Void> remove(@PathVariable Long[] attrGroupIds) {
        return R.condition(pmsAttrGroupService.deletePmsAttrGroupByAttrGroupIds(attrGroupIds));
    }
}
