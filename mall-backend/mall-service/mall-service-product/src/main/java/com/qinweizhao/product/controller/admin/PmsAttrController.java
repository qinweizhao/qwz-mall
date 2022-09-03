package com.qinweizhao.product.controller.admin;

import com.qinweizhao.common.security.annotation.RequiresPermissions;
import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.component.log.annotation.Log;
import com.qinweizhao.component.log.enums.BusinessType;
import com.qinweizhao.product.convert.AttrConvert;
import com.qinweizhao.product.model.dto.AttrDTO;
import com.qinweizhao.product.model.dto.TestDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.param.AttrParam;
import com.qinweizhao.product.service.PmsAttrService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品属性Controller
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
@RestController
@AllArgsConstructor
@RequestMapping("/admin/attr")
public class PmsAttrController {

    private final PmsAttrService pmsAttrService;

    /**
     * 查询商品属性列表
     */
    @RequiresPermissions("product:attr:page")
    @GetMapping("/page")
    public R<PageResult<AttrDTO>> page(AttrParam param) {
        PageResult<AttrDTO> result = pmsAttrService.page(param);
        return R.success(result);
    }

    /**
     * 获取商品属性详细信息
     */
    @RequiresPermissions("product:attr:query")
    @GetMapping(value = "/{attrId}")
    public R<AttrDTO> get(@PathVariable("attrId") Long attrId) {
        AttrDTO pmsAttr = pmsAttrService.getById(attrId);
        return R.success(pmsAttr);
    }

    /**
     * 新增商品属性
     */
    @RequiresPermissions("product:attr:add")
    @Log(title = "商品属性", businessType = BusinessType.INSERT)
    @PostMapping
    public R<Boolean> add(@RequestBody AttrParam param) {
        PmsAttr pmsAttr = AttrConvert.INSTANCE.convert(param);
        return R.success(pmsAttrService.save(pmsAttr));
    }

    /**
     * 修改商品属性
     */
    @RequiresPermissions("product:attr:edit")
    @Log(title = "商品属性", businessType = BusinessType.UPDATE)
    @PutMapping
    public R<Boolean> edit(@RequestBody AttrParam param) {
        PmsAttr pmsAttr = AttrConvert.INSTANCE.convert(param);
        return R.success(pmsAttrService.updateById(pmsAttr));
    }

    /**
     * 删除商品属性
     */
    @RequiresPermissions("product:attr:remove")
    @Log(title = "商品属性", businessType = BusinessType.DELETE)
    @DeleteMapping("/{attrIds}")
    public R<Boolean> remove(@PathVariable List<Long> attrIds) {
        return R.success(pmsAttrService.removeByIds(attrIds));
    }


    /**
     * 查询商品属性列表
     */
    @GetMapping("/test")
    public TestDTO test() {
        TestDTO attrDTO = new TestDTO();
        attrDTO.setId(123L);
        attrDTO.setName("asd");
        attrDTO.setType(1);
        attrDTO.setSearchType(1);
        attrDTO.setSort(1);
        attrDTO.setStatus(121L);
        System.out.println("远程数据为：" + attrDTO);
        return attrDTO;
    }

}
