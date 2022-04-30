package com.qinweizhao.user.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.user.entity.UmsMember;
import com.qinweizhao.user.service.UmsMemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * 会员Controller
 *
 * @author qinweizhao
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/member")
public class UmsMemberController extends BaseController {

    @Resource
    private UmsMemberService umsMemberService;

//    /**
//     * 查询会员列表
//     */
//    @RequiresPermissions("product:member:list")
//    @GetMapping("/list")
//    public R<List<Member>> list() {
//        List<Member> list = umsMemberService.list();
//        return R.success(list);
//    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/list")
    public R<PageResult<UmsMember>> list(UmsMember umsMember) {
        startPage();
        List<UmsMember> list = umsMemberService.selectMemberList(umsMember);
        return getPageResult(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("product:member:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMember umsMember) {
        List<UmsMember> list = umsMemberService.selectMemberList(umsMember);
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
        return R.success(umsMemberService.getById(id));
    }

    /**
     * 新增会员
     */
    @RequiresPermissions("product:member:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMember umsMember) {
        return R.condition(umsMemberService.save(umsMember));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("product:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMember umsMember) {
        return R.condition(umsMemberService.save(umsMember));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("product:member:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable List<Long> ids) {
        return R.condition(umsMemberService.removeByIds(ids));
    }
}
