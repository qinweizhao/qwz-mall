package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsAddress;
import com.qinweizhao.user.service.UmsAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员收货地址Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/address")
public class UmsAddressController {

    @Resource
    private UmsAddressService umsAddressService;

    /**
     * 查询会员收货地址列表
     */
    @RequiresPermissions("product:address:list")
    @GetMapping("/list")
    public R<List<UmsAddress>> list(UmsAddress umsAddress) {
         
        List<UmsAddress> list = umsAddressService.selectUmsMemberReceiveAddressList(umsAddress);
        return R.success(list);
    }

    /**
     * 获取会员收货地址详细信息
     */
    @RequiresPermissions("product:address:query")
    @GetMapping(value = "/{id}")
    public R<UmsAddress> getInfo(@PathVariable("id") Long id) {
//        umsAddressService.getById(id)
        return R.success();
    }

    /**
     * 新增会员收货地址
     */
    @RequiresPermissions("product:address:add")
    @Log(title = "会员收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsAddress umsAddress) {
        return R.success(umsAddressService.save(umsAddress));
    }

    /**
     * 修改会员收货地址
     */
    @RequiresPermissions("product:address:edit")
    @Log(title = "会员收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsAddress umsAddress) {
        return R.success(umsAddressService.updateById(umsAddress));
    }

    /**
     * 删除会员收货地址
     */
    @RequiresPermissions("product:address:remove")
    @Log(title = "会员收货地址", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsAddressService.removeBatchByIds(ids));
    }
}
