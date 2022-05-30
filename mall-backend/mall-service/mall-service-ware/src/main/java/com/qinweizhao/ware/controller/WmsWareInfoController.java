package com.qinweizhao.ware.controller;

import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.ware.model.WmsWareInfo;
import com.qinweizhao.ware.service.IWmsWareInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 仓库信息Controller
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/info")
public class WmsWareInfoController extends BaseController {


    @Resource
    private IWmsWareInfoService wmsWareInfoService;

    /**
     * 查询仓库信息列表
     */
    @RequiresPermissions("product:info:list")
    @GetMapping("/page")
    public R<PageResult<WmsWareInfo>> list(WmsWareInfo wmsWareInfo) {
        startPage();
        List<WmsWareInfo> list = wmsWareInfoService.selectWmsWareInfoList(wmsWareInfo);
        return getPageResult(list);
    }

    /**
     * 获取仓库信息详细信息
     */
    @RequiresPermissions("product:info:query")
    @GetMapping(value = "/{id}")
    public R<WmsWareInfo> getInfo(@PathVariable("id") Long id) {
        return R.success(wmsWareInfoService.getById(id));
    }

    /**
     * 新增仓库信息
     */
    @RequiresPermissions("product:info:add")
    @Log(title = "仓库信息", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody WmsWareInfo wmsWareInfo) {
        return R.success(wmsWareInfoService.save(wmsWareInfo));
    }

    /**
     * 修改仓库信息
     */
    @RequiresPermissions("product:info:edit")
    @Log(title = "仓库信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody WmsWareInfo wmsWareInfo) {
        return R.success(wmsWareInfoService.updateById(wmsWareInfo));
    }

    /**
     * 删除仓库信息
     */
    @RequiresPermissions("product:info:remove")
    @Log(title = "仓库信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(wmsWareInfoService.removeBatchByIds(ids));
    }
}
