package com.mall4j.cloud.product.controller.admin;

import cn.hutool.core.collection.CollUtil;
import com.mall4j.cloud.api.product.vo.AttrVO;
import com.mall4j.cloud.common.constant.Constant;
import com.mall4j.cloud.common.database.dto.PageDTO;
import com.mall4j.cloud.common.database.vo.PageVO;
import com.mall4j.cloud.common.exception.Mall4cloudException;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.common.security.AuthUserContext;
import com.mall4j.cloud.product.constant.AttrType;
import com.mall4j.cloud.product.constant.SearchType;
import com.mall4j.cloud.product.dto.AttrDTO;
import com.mall4j.cloud.product.model.Attr;
import com.mall4j.cloud.product.model.AttrValue;
import com.mall4j.cloud.product.service.AttrService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 属性信息
 *
 * @author FrozenWatermelon
 * @date 2020-10-28 15:27:23
 */
@RestController("platformAttrController")
@RequestMapping("/admin/attr")
@Api(tags = "admin-属性信息")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
	private MapperFacade mapperFacade;

	@GetMapping("/page")
	@ApiOperation(value = "获取属性信息列表", notes = "分页获取属性信息列表")
	public ServerResponseEntity<PageVO<AttrVO>> page(@Valid PageDTO pageDTO, AttrDTO attrDTO) {
		PageVO<AttrVO> attrPage = attrService.page(pageDTO, attrDTO);
		return ServerResponseEntity.success(attrPage);
	}

	@GetMapping
    @ApiOperation(value = "获取属性信息", notes = "根据attrId获取属性信息")
    public ServerResponseEntity<AttrVO> getByAttrId(@RequestParam Long attrId) {
        return ServerResponseEntity.success(attrService.getByAttrId(attrId));
    }

    @PostMapping
    @ApiOperation(value = "保存属性信息", notes = "保存属性信息")
    public ServerResponseEntity<Void> save(@Valid @RequestBody AttrDTO attrDTO) {
        if (Objects.equals(Constant.PLATFORM_SHOP_ID, AuthUserContext.get().getTenantId()) && Objects.isNull(attrDTO.getAttrType())) {
            throw new Mall4cloudException("属性类型不能为空");
        }
	    checkAttrInfo(attrDTO);
        Attr attr = mapperFacade.map(attrDTO, Attr.class);
        attr.setAttrValues(mapperFacade.mapAsList(attrDTO.getAttrValues(), AttrValue.class));
        attrService.save(attr, attrDTO.getCategoryIds());
        removeCacheAttrUnionCategory(attrDTO.getCategoryIds());
        return ServerResponseEntity.success();
    }

    @PutMapping
    @ApiOperation(value = "更新属性信息", notes = "更新属性信息")
    public ServerResponseEntity<Void> update(@Valid @RequestBody AttrDTO attrDTO) {
        checkAttrInfo(attrDTO);
        Attr attr = mapperFacade.map(attrDTO, Attr.class);
        if (CollUtil.isNotEmpty(attrDTO.getAttrValues())) {
            attr.setAttrValues(mapperFacade.mapAsList(attrDTO.getAttrValues(), AttrValue.class));
        }
        List<Long> categoryIds = null;
        if (Objects.equals(AttrType.BASIC.value(), attr.getAttrType())) {
            categoryIds = attrService.getAttrOfCategoryIdByAttrId(attrDTO.getAttrId());
            categoryIds.addAll(attrDTO.getCategoryIds());
        }
        attrService.update(attr, attrDTO.getCategoryIds());
        removeCacheAttrUnionCategory(categoryIds);
        return ServerResponseEntity.success();
    }

    @DeleteMapping
    @ApiOperation(value = "删除属性信息", notes = "根据属性信息id删除属性信息")
    public ServerResponseEntity<Void> delete(@RequestParam Long attrId) {
        List<Long> categoryIds = attrService.getAttrOfCategoryIdByAttrId(attrId);
        attrService.deleteById(attrId);
        if (CollUtil.isNotEmpty(categoryIds)) {
            removeCacheAttrUnionCategory(categoryIds);
        }
        return ServerResponseEntity.success();
    }

    @GetMapping("/get_attrs_by_category_id")
    @ApiOperation(value = "根据分类及属性类别获取属性列表", notes = "根据分类及属性类别获取属性列表")
    @ApiImplicitParam(name = "categoryId", value = "分类id", required = true)
    public ServerResponseEntity<List<AttrVO>> getAttrsByCategoryId(@RequestParam(value = "categoryId") Long categoryId) {
        return ServerResponseEntity.success(attrService.getAttrsByCategoryIdAndAttrType(categoryId));
    }

    @GetMapping("/get_shop_attrs")
    @ApiOperation(value = "获取店铺中的销售属性", notes = "获取店铺中的销售属性")
    public ServerResponseEntity<List<AttrVO>> getShopAttrs () {
        return ServerResponseEntity.success(attrService.getShopAttrs(AuthUserContext.get().getTenantId()));
    }

    /**
     * 校验属性数据
     * @param attrDTO
     */
    private void checkAttrInfo(AttrDTO attrDTO) {
        if (!Objects.equals(Constant.PLATFORM_SHOP_ID, AuthUserContext.get().getTenantId())) {
            attrDTO.setAttrType(AttrType.SALES.value());
        }
        if (Objects.equals(AttrType.SALES.value(), attrDTO.getAttrType())) {
            attrDTO.setSearchType(SearchType.NOT_SEARCH.value());
            return;
        }
        if (CollUtil.isEmpty(attrDTO.getCategoryIds())) {
            throw new Mall4cloudException("关联分类不能为空");
        }
        if (Objects.isNull(attrDTO.getSearchType())) {
            throw new Mall4cloudException("搜索属性不能为空");
        }
    }

    /**
     *  删除属性关联的分类缓存
     */
    private void removeCacheAttrUnionCategory(List<Long> categoryIds) {
        // 清除分类缓存
        if (!Objects.equals(Constant.PLATFORM_SHOP_ID, AuthUserContext.get().getTenantId()) || CollUtil.isEmpty(categoryIds)) {
            return;
        }
        attrService.removeAttrByCategoryId(categoryIds);
    }

}
