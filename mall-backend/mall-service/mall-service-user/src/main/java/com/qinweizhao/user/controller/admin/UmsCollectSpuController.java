package com.qinweizhao.user.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.user.model.entity.UmsCollectSpu;
import com.qinweizhao.user.service.UmsCollectSpuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员收藏的商品Controller
 *
 * @author qinweizhao
 * @date 2022-04-30
 */
@RestController
@RequestMapping("/collect-spu")
public class UmsCollectSpuController {

    @Resource
    private UmsCollectSpuService umsCollectSpuService;

    /**
     * 查询会员收藏的商品列表
     */
    @RequiresPermissions("product:spu:list")
    @GetMapping("/list")
    public R<List<UmsCollectSpu>> list(UmsCollectSpu umsCollectSpu) {
        List<UmsCollectSpu> list = umsCollectSpuService.selectUmsMemberCollectSpuList(umsCollectSpu);
        return R.success(list);
    }

    /**
     * 获取会员收藏的商品详细信息
     */
    @RequiresPermissions("product:spu:query")
    @GetMapping(value = "/{id}")
    public R<UmsCollectSpu> getInfo(@PathVariable("id") Long id) {
//        return R.success(umsCollectSpuService.getById(id));

        return R.success();
    }

    /**
     * 新增会员收藏的商品
     */
    @RequiresPermissions("product:spu:add")
    @Log(title = "会员收藏的商品", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Boolean> add(@RequestBody UmsCollectSpu umsCollectSpu) {
        return R.success(umsCollectSpuService.save(umsCollectSpu));
    }

    /**
     * 修改会员收藏的商品
     */
    @RequiresPermissions("product:spu:edit")
    @Log(title = "会员收藏的商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Boolean> edit(@RequestBody UmsCollectSpu umsCollectSpu) {
        return R.success(umsCollectSpuService.updateById(umsCollectSpu));
    }

    /**
     * 删除会员收藏的商品
     */
    @RequiresPermissions("product:spu:remove")
    @Log(title = "会员收藏的商品", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Boolean> remove(@PathVariable List<Long> ids) {
        return R.success(umsCollectSpuService.removeBatchByIds(ids));
    }
}
