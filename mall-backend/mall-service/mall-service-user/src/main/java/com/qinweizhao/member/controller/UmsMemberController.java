package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.UmsMember;
import com.qinweizhao.product.service.IUmsMemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/member")
public class UmsMemberController extends BaseController {
    @Resource
    private IUmsMemberService umsMemberService;

    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/list")
    public R<List<UmsMember>> list(UmsMember umsMember) {
        startPage();
        List<UmsMember> list = umsMemberService.selectUmsMemberList(umsMember);
        return R.success(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("product:member:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMember umsMember) {
        List<UmsMember> list = umsMemberService.selectUmsMemberList(umsMember);
        ExcelUtil<UmsMember> util = new ExcelUtil<UmsMember>(UmsMember.class);
        util.exportExcel(response, list, "会员数据");
        return R.success();
    }

    /**
     * 获取会员详细信息
     */
    @RequiresPermissions("product:member:query")
    @GetMapping(value = "/{id}")
    public R<UmsMember> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberService.selectUmsMemberById(id));
    }

    /**
     * 新增会员
     */
    @RequiresPermissions("product:member:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMember umsMember) {
        return R.condition(umsMemberService.insertUmsMember(umsMember));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("product:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMember umsMember) {
        return R.condition(umsMemberService.updateUmsMember(umsMember));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("product:member:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(umsMemberService.deleteUmsMemberByIds(ids));
    }
}
