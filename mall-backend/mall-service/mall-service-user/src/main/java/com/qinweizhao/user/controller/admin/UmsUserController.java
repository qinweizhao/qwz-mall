package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.core.model.LoginUser;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.convert.MemberConvert;
import com.qinweizhao.user.model.dto.UserDTO;
import com.qinweizhao.user.model.entity.UmsUser;
import com.qinweizhao.user.model.param.MemberPageParam;
import com.qinweizhao.user.service.UmsUserService;
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
public class UmsUserController {

    @Resource
    private UmsUserService umsUserService;

    @GetMapping("/info/{username}")
    public R<LoginUser> info(@PathVariable("username") String username) {
        UserDTO userDTO = umsUserService.getByUsername(username);
        LoginUser loginUser = MemberConvert.INSTANCE.convert(userDTO);
        loginUser.setUserid(userDTO.getId());
        return R.success(loginUser);
    }

    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/page")
    public R<PageResult<UserDTO>> page(MemberPageParam pageParam) {
        PageResult<UmsUser> pageResult = umsUserService.page(pageParam);
//        return R.success(MemberConvert.INSTANCE.convertToVO(pageResult));
        return R.success();
    }


    /**
     * 查询会员列表
     */
    @RequiresPermissions("product:member:list")
    @GetMapping("/list")
    public R<List<UmsUser>> page(UmsUser umsUser) {
        List<UmsUser> list = umsUserService.selectMemberList(umsUser);
        return R.success(list);
    }

    /**
     * 获取会员详细信息
     */
    @RequiresPermissions("product:member:query")
    @GetMapping(value = "/{id}")
    public R<UmsUser> getInfo(@PathVariable("id") Long id) {
//        return R.success(umsUserService.getById(id));

        return R.success();
    }

    /**
     * 新增会员
     */
    @RequiresPermissions("product:member:add")
    @Log(title = "会员", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> save(@RequestBody UmsUser umsUser) {
        return R.success(umsUserService.save(umsUser));
    }

    /**
     * 修改会员
     */
    @RequiresPermissions("product:member:edit")
    @Log(title = "会员", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsUser umsUser) {
        return R.success(umsUserService.save(umsUser));
    }

    /**
     * 删除会员
     */
    @RequiresPermissions("product:member:remove")
    @Log(title = "会员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
//        return R.success(umsUserService.removeByIds(ids));
        return R.success();
    }
}
