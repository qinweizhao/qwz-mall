package com.qinweizhao.system.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.system.common.result.PageResult;
import com.qinweizhao.system.common.result.Result;
import com.qinweizhao.system.dto.UserAuthInfo;
import com.qinweizhao.system.pojo.dto.UserImportDTO;
import com.qinweizhao.system.pojo.entity.SysUser;
import com.qinweizhao.system.pojo.form.UserForm;
import com.qinweizhao.system.pojo.query.UserPageQuery;
import com.qinweizhao.system.pojo.vo.user.UserExportVO;
import com.qinweizhao.system.pojo.vo.user.UserLoginVO;
import com.qinweizhao.system.pojo.vo.user.UserVO;
import com.qinweizhao.system.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * 用户控制器
 *
 * @author haoxr
 * @date 2022/1/15
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class SysUserController {

    private final SysUserService userService;

    @ApiOperation(value = "用户分页列表")
    @GetMapping("/pages")
    public PageResult<UserVO> listUserPages(UserPageQuery queryParams) {
        IPage<UserVO> result = userService.listUserPages(queryParams);
        return PageResult.success(result);
    }

    @ApiOperation(value = "用户表单数据")
    @GetMapping("/{userId}/form")
    public Result<UserForm> getUserDetail(
            @ApiParam(value = "用户ID") @PathVariable Long userId
    ) {
        UserForm formData = userService.getUserFormData(userId);
        return Result.success(formData);
    }

    @ApiOperation(value = "新增用户")
    @PostMapping
    @PreAuthorize("@pms.hasPermission('sys:user:add')")
    public Result saveUser(
            @Validated @RequestBody UserForm userForm
    ) {
        boolean result = userService.saveUser(userForm);
        return Result.judge(result);
    }

    @ApiOperation(value = "修改用户")
    @PutMapping(value = "/{userId}")
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public Result updateUser(
            @ApiParam("用户ID") @PathVariable Long userId,
            @RequestBody @Validated UserForm userForm) {
        boolean result = userService.updateUser(userId, userForm);
        return Result.judge(result);
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/{ids}")
    @PreAuthorize("hasAuthority('sys:user:del')")
    public Result deleteUsers(
            @ApiParam("用户ID，多个以英文逗号(,)分割") @PathVariable String ids
    ) {
        boolean result = userService.deleteUsers(ids);
        return Result.judge(result);
    }

    @ApiOperation(value = "修改用户密码")
    @PatchMapping(value = "/{userId}/password")
    public Result updatePassword(
            @ApiParam("用户ID") @PathVariable Long userId,
            @RequestParam String password
    ) {
        boolean result = userService.updatePassword(userId, password);
        return Result.judge(result);
    }

    @ApiOperation(value = "修改用户状态")
    @PatchMapping(value = "/{userId}/status")
    public Result updatePassword(
            @ApiParam("用户ID") @PathVariable Long userId,
            @ApiParam("用户状态(1:启用;0:禁用)") @RequestParam Integer status
    ) {
        boolean result = userService.update(new LambdaUpdateWrapper<SysUser>()
                .eq(SysUser::getId, userId)
                .set(SysUser::getStatus, status)
        );
        return Result.judge(result);
    }

    @ApiOperation(value = "获取登录用户信息")
    @GetMapping("/me")
    public Result<UserLoginVO> getLoginUserInfo() {
        UserLoginVO userLoginVO = userService.getLoginUserInfo();
        return Result.success(userLoginVO);
    }

    @ApiOperation("用户导入模板下载")
    @GetMapping("/template")
    public void downloadTemplate(HttpServletResponse response) throws IOException {
        String fileName = "用户导入模板.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

        String fileClassPath = "excel-templates" + File.separator + fileName;
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileClassPath);

        ServletOutputStream outputStream = response.getOutputStream();
        ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(inputStream).build();

        excelWriter.finish();
    }

    @ApiOperation("导入用户")
    @PostMapping("/_import")
    public Result importUsers(UserImportDTO userImportDTO) throws IOException {
        String msg = userService.importUsers(userImportDTO);
        return Result.success(msg);
    }

    @ApiOperation("导出用户")
    @GetMapping("/_export")
    public void exportUsers(UserPageQuery queryParams, HttpServletResponse response) throws IOException {
        String fileName = "用户列表.xlsx";
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));

        List<UserExportVO> exportUserList = userService.listExportUsers(queryParams);
        EasyExcel.write(response.getOutputStream(), UserExportVO.class)
                .sheet("用户列表")
                .doWrite(exportUserList);
    }

    @ApiOperation(value = "根据用户名获取认证信息", hidden = true)
    @GetMapping("/{username}/authinfo")
    public Result<UserAuthInfo> getUserAuthInfo(
            @ApiParam("用户名") @PathVariable String username
    ) {
        UserAuthInfo user = userService.getUserAuthInfo(username);
        return Result.success(user);
    }
}
