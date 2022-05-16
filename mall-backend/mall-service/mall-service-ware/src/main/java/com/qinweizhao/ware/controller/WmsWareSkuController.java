package com.qinweizhao.ware.controller;

import com.qinweizhao.api.ware.dto.SkuHasStockDTO;
import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.InnerAuth;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.ware.domain.WmsWareSku;
import com.qinweizhao.ware.service.IWmsWareSkuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 商品库存Controller
 *
 * @author qinweizhao
 * @date 2022-05-04
 */
@RestController
@RequestMapping("/ware-sku")
public class WmsWareSkuController extends BaseController {


    @Resource
    private IWmsWareSkuService wmsWareSkuService;

    /**
     * 查询商品库存列表
     */
    @RequiresPermissions("product:sku:list")
    @GetMapping("/page")
    public R<PageResult<WmsWareSku>> list(WmsWareSku wmsWareSku) {
        startPage();
        List<WmsWareSku> list = wmsWareSkuService.selectWmsWareSkuList(wmsWareSku);
        return getPageResult(list);
    }

    /**
     * 查询商品库存列表
     */
//    @RequiresPermissions("product:sku:list")
    @InnerAuth
    @PostMapping("/stock")
    public R<List<SkuHasStockDTO>> stock(@RequestBody List<Long> skuIds) {
        List<SkuHasStockDTO> maps = wmsWareSkuService.listHasStockBySkuIds(skuIds);
        return R.success(maps);
    }

    /**
     * 导出商品库存列表
     */
    @RequiresPermissions("product:sku:export")
    @Log(title = "商品库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, WmsWareSku wmsWareSku) {
        List<WmsWareSku> list = wmsWareSkuService.selectWmsWareSkuList(wmsWareSku);
        ExcelUtil<WmsWareSku> util = new ExcelUtil<WmsWareSku>(WmsWareSku.class);
        util.exportExcel(response, list, "商品库存数据");
        return R.success();
    }

    /**
     * 获取商品库存详细信息
     */
    @RequiresPermissions("product:sku:query")
    @GetMapping(value = "/{id}")
    public R<WmsWareSku> getInfo(@PathVariable("id") Long id) {
        return R.success(wmsWareSkuService.selectWmsWareSkuById(id));
    }

    /**
     * 新增商品库存
     */
    @RequiresPermissions("product:sku:add")
    @Log(title = "商品库存", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody WmsWareSku wmsWareSku) {
        return R.condition(wmsWareSkuService.insertWmsWareSku(wmsWareSku));
    }

    /**
     * 修改商品库存
     */
    @RequiresPermissions("product:sku:edit")
    @Log(title = "商品库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody WmsWareSku wmsWareSku) {
        return R.condition(wmsWareSkuService.updateWmsWareSku(wmsWareSku));
    }

    /**
     * 删除商品库存
     */
    @RequiresPermissions("product:sku:remove")
    @Log(title = "商品库存", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(wmsWareSkuService.deleteWmsWareSkuByIds(ids));
    }
}
