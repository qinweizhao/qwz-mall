package com.qinweizhao.system.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qinweizhao.system.dto.OAuth2ClientDTO;
import com.qinweizhao.system.pojo.entity.SysOauthClient;
import com.qinweizhao.system.pojo.query.ClientPageQuery;
import com.qinweizhao.system.pojo.vo.client.ClientPageVO;
import com.qinweizhao.system.service.SysOauthClientService;
import com.qinweizhao.system.pojo.result.PageResult;
import com.qinweizhao.system.pojo.result.Result;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Api(tags = "客户端接口")
@RestController
@RequestMapping("/api/v1/oauth-clients")
@RequiredArgsConstructor
public class SysOauthClientController {

    private final SysOauthClientService clientService;

    @ApiOperation(value = "客户端分页列表")
    @GetMapping
    public PageResult<ClientPageVO> listClientPages(ClientPageQuery queryParams) {
        IPage<ClientPageVO> result = clientService.listClientPages(queryParams);
        return PageResult.success(result);
    }

    @ApiOperation(value = "客户端详情")
    @GetMapping("/{clientId}")
    public Result detail(
            @ApiParam("客户端ID") @PathVariable String clientId) {
        SysOauthClient client = clientService.getById(clientId);
        return Result.success(client);
    }

    @ApiOperation(value = "新增客户端")
    @PostMapping
    public Result add(@RequestBody SysOauthClient client) {
        boolean status = clientService.save(client);
        return Result.judge(status);
    }

    @ApiOperation(value = "修改客户端")
    @PutMapping(value = "/{clientId}")
    public Result update(
            @ApiParam("客户端ID") @PathVariable String clientId,
            @RequestBody SysOauthClient client) {
        boolean status = clientService.updateById(client);
        return Result.judge(status);
    }

    @ApiOperation(value = "删除客户端")
    @DeleteMapping("/{ids}")
    public Result delete(
            @ApiParam("客户端ID，多个以英文逗号(,)分割") @PathVariable("ids") String ids
    ) {
        boolean status = clientService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.judge(status);
    }

    @ApiOperation(value = "获取 OAuth2 客户端认证信息", notes = "Feign 调用", hidden = true)
    @GetMapping("/getOAuth2ClientById")
    public Result<OAuth2ClientDTO> getOAuth2ClientById(

            @ApiParam("客户端ID") @RequestParam String clientId) {
        SysOauthClient client = clientService.getById(clientId);
        Assert.isTrue(client != null, "OAuth2 客户端不存在");
        OAuth2ClientDTO oAuth2ClientDTO = new OAuth2ClientDTO();
        BeanUtil.copyProperties(client, oAuth2ClientDTO);
        return Result.success(oAuth2ClientDTO);
    }
}
