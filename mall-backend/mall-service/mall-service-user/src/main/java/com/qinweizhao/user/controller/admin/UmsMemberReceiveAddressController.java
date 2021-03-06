package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsMemberReceiveAddress;
import com.qinweizhao.user.service.UmsMemberReceiveAddressService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员收货地址Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/address")
public class UmsMemberReceiveAddressController {

    @Resource
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
     * 查询会员收货地址列表
     */
    @RequiresPermissions("product:address:list")
    @GetMapping("/list")
    public R<List<UmsMemberReceiveAddress>> list(UmsMemberReceiveAddress umsMemberReceiveAddress) {
         
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
        return R.success(list);
    }

    /**
     * 导出会员收货地址列表
     */
    @RequiresPermissions("product:address:export")
    @Log(title = "会员收货地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, UmsMemberReceiveAddress umsMemberReceiveAddress) {
        List<UmsMemberReceiveAddress> list = umsMemberReceiveAddressService.selectUmsMemberReceiveAddressList(umsMemberReceiveAddress);
        ExcelUtil<UmsMemberReceiveAddress> util = new ExcelUtil<UmsMemberReceiveAddress>(UmsMemberReceiveAddress.class);
        util.exportExcel(response, list, "会员收货地址数据");
        return R.success();
    }

    /**
     * 获取会员收货地址详细信息
     */
    @RequiresPermissions("product:address:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberReceiveAddress> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberReceiveAddressService.getById(id));
    }

    /**
     * 新增会员收货地址
     */
    @RequiresPermissions("product:address:add")
    @Log(title = "会员收货地址", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return R.success(umsMemberReceiveAddressService.save(umsMemberReceiveAddress));
    }

    /**
     * 修改会员收货地址
     */
    @RequiresPermissions("product:address:edit")
    @Log(title = "会员收货地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress) {
        return R.success(umsMemberReceiveAddressService.updateById(umsMemberReceiveAddress));
    }

    /**
     * 删除会员收货地址
     */
    @RequiresPermissions("product:address:remove")
    @Log(title = "会员收货地址", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsMemberReceiveAddressService.removeBatchByIds(ids));
    }
}
