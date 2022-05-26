package com.qinweizhao.user.controller;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.convert.MemberConvert;
import com.qinweizhao.user.model.entity.UmsMember;
import com.qinweizhao.user.model.param.MemberPageParam;
import com.qinweizhao.user.model.vo.MemberVO;
import com.qinweizhao.user.service.UmsMemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/page")
    public R<PageResult<MemberVO>> page(MemberPageParam pageParam) {
        PageResult<UmsMember> pageResult = umsMemberService.page(pageParam);
        return R.success(MemberConvert.INSTANCE.convertToVO(pageResult));
    }


    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/list")
    public R<List<UmsMember>> page(UmsMember umsMember) {
        List<UmsMember> list = umsMemberService.selectMemberList(umsMember);
        return R.success(list);
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
    public R<?> save(@RequestBody UmsMember umsMember) {
        return R.success(umsMemberService.save(umsMember));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("product:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsMember umsMember) {
        return R.success(umsMemberService.save(umsMember));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("product:member:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsMemberService.removeByIds(ids));
    }
}
