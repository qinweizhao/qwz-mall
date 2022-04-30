package com.qinweizhao.product.controller;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.core.web.controller.BaseController;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.domain.UmsMemberCollectSpu;
import com.qinweizhao.product.service.IUmsMemberCollectSpuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 会员收藏的商品Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/spu")
public class UmsMemberCollectSpuController extends BaseController {
    @Resource
    private IUmsMemberCollectSpuService umsMemberCollectSpuService;

    /**
     * 查询会员收藏的商品列表
     */
    @RequiresPermissions("product:spu:list")
    @GetMapping("/list")
    public R<List<UmsMemberCollectSpu>> list(UmsMemberCollectSpu umsMemberCollectSpu) {
        startPage();
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
        return R.success(list);
    }

    /**
     * 导出会员收藏的商品列表
     */
    @RequiresPermissions("product:spu:export")
    @Log(title = "会员收藏的商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<Void> export(HttpServletResponse response, UmsMemberCollectSpu umsMemberCollectSpu) {
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
        ExcelUtil<UmsMemberCollectSpu> util = new ExcelUtil<UmsMemberCollectSpu>(UmsMemberCollectSpu.class);
        util.exportExcel(response, list, "会员收藏的商品数据");
        return R.success();
    }

    /**
     * 获取会员收藏的商品详细信息
     */
    @RequiresPermissions("product:spu:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberCollectSpu> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberCollectSpuService.selectUmsMemberCollectSpuById(id));
    }

    /**
     * 新增会员收藏的商品
     */
    @RequiresPermissions("product:spu:add")
    @Log(title = "会员收藏的商品", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Void> add(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu) {
        return R.condition(umsMemberCollectSpuService.insertUmsMemberCollectSpu(umsMemberCollectSpu));
    }

    /**
     * 修改会员收藏的商品
     */
    @RequiresPermissions("product:spu:edit")
    @Log(title = "会员收藏的商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Void> edit(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu) {
        return R.condition(umsMemberCollectSpuService.updateUmsMemberCollectSpu(umsMemberCollectSpu));
    }

    /**
     * 删除会员收藏的商品
     */
    @RequiresPermissions("product:spu:remove")
    @Log(title = "会员收藏的商品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@PathVariable Long[] ids) {
        return R.condition(umsMemberCollectSpuService.deleteUmsMemberCollectSpuByIds(ids));
    }
}
