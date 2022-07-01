package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.core.utils.poi.ExcelUtil;
import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsMemberCollectSpu;
import com.qinweizhao.user.service.UmsMemberCollectSpuService;
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
@RequestMapping("/collect-spu")
public class UmsMemberCollectSpuController {

    @Resource
    private UmsMemberCollectSpuService umsMemberCollectSpuService;

    /**
     * 查询会员收藏的商品列表
     */
    @RequiresPermissions("product:spu:list")
    @GetMapping("/list")
    public R<List<UmsMemberCollectSpu>> list(UmsMemberCollectSpu umsMemberCollectSpu) {
         
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
        return R.success(list);
    }

    /**
     * 导出会员收藏的商品列表
     */
    @RequiresPermissions("product:spu:export")
    @Log(title = "会员收藏的商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public R<?> export(HttpServletResponse response, UmsMemberCollectSpu umsMemberCollectSpu) {
        List<UmsMemberCollectSpu> list = umsMemberCollectSpuService.selectUmsMemberCollectSpuList(umsMemberCollectSpu);
        ExcelUtil<UmsMemberCollectSpu> util = new ExcelUtil<>(UmsMemberCollectSpu.class);
        util.exportExcel(response, list, "会员收藏的商品数据");
        return R.success();
    }

    /**
     * 获取会员收藏的商品详细信息
     */
    @RequiresPermissions("product:spu:query")
    @GetMapping(value = "/{id}")
    public R<UmsMemberCollectSpu> getInfo(@PathVariable("id") Long id) {
        return R.success(umsMemberCollectSpuService.getById(id));
    }

    /**
     * 新增会员收藏的商品
     */
    @RequiresPermissions("product:spu:add")
    @Log(title = "会员收藏的商品", businessType = BusinessType.INSERT)
    @PostMapping
    public R<?> add(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu) {
        return R.success(umsMemberCollectSpuService.save(umsMemberCollectSpu));
    }

    /**
     * 修改会员收藏的商品
     */
    @RequiresPermissions("product:spu:edit")
    @Log(title = "会员收藏的商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<?> edit(@RequestBody UmsMemberCollectSpu umsMemberCollectSpu) {
        return R.success(umsMemberCollectSpuService.updateById(umsMemberCollectSpu));
    }

    /**
     * 删除会员收藏的商品
     */
    @RequiresPermissions("product:spu:remove")
    @Log(title = "会员收藏的商品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<?> remove(@PathVariable List<Long> ids) {
        return R.success(umsMemberCollectSpuService.removeBatchByIds(ids));
    }
}
