package com.qinweizhao.user.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.user.entity.Member;
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
public class UmsMemberController {

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
    public R<List<Member>> list(Member member) {
        List<Member> list = umsMemberService.selectMemberList(member);
        return R.success(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("product:member:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, Member member) {
        List<Member> list = umsMemberService.selectMemberList(member);
        ExcelUtil<Member> util = new ExcelUtil<Member>(Member.class);
        util.exportExcel(response, list, "会员数据");
        return R.success();
    }

    /**
     * 获取会员详细信息
     */
    @RequiresPermissions("product:member:query")
    @GetMapping(value = "/{id}")
    public R<Member> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberService.getById(id));
    }

    /**
     * 新增会员
     */
    @RequiresPermissions("product:member:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody Member member) {
        return R.condition(umsMemberService.save(member));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("product:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody Member member) {
        return R.condition(umsMemberService.save(member));
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
