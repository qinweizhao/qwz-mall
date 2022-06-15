package com.qinweizhao.user.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.user.entity.Member;
import com.qinweizhao.user.service.MemberService;
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
@RequestMapping("/user")
public class MemberController {

    @Resource
    private MemberService memberService;

    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/list")
    public R<List<Member>> list() {
        List<Member> list = memberService.list();
        return R.success(list);
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/list")
    public R<List<Member>> list(Member member) {
        List<Member> list = memberService.selectMemberList(member);
        return R.success(list);
    }

    /**
     * 导出会员列表
     */
    @RequiresPermissions("product:member:export")
    @Log(title = "会员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, Member member) {
        List<Member> list = memberService.selectMemberList(member);
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
        return R.success(memberService.getById(id));
    }

    /**
     * 新增会员
     */
    @RequiresPermissions("product:member:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody Member member) {
        return R.success(memberService.save(member));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("product:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody Member member) {
        return R.success(memberService.save(member));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("product:member:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(memberService.removeByIds(ids));
    }
}
