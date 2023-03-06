package com.mall4j.cloud.multishop.controller.admin;

import com.mall4j.cloud.api.product.feign.SpuFeignClient;
import com.mall4j.cloud.api.product.vo.SpuVO;
import com.mall4j.cloud.common.constant.StatusEnum;
import com.mall4j.cloud.common.database.dto.PageDTO;
import com.mall4j.cloud.common.database.vo.PageVO;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.common.security.AuthUserContext;
import com.mall4j.cloud.multishop.dto.IndexImgDTO;
import com.mall4j.cloud.multishop.model.IndexImg;
import com.mall4j.cloud.multishop.service.IndexImgService;
import com.mall4j.cloud.multishop.vo.IndexImgVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * 轮播图
 *
 * @author YXF
 * @date 2020-11-24 16:38:32
 */
@RestController("adminIndexImgController")
@RequestMapping("/admin/index_img")
@Api(tags = "admin-轮播图")
public class IndexImgController {

    @Autowired
    private IndexImgService indexImgService;
    @Autowired
    private MapperFacade mapperFacade;
    @Autowired
    private SpuFeignClient spuFeignClient;

	@GetMapping("/page")
	@ApiOperation(value = "获取轮播图列表", notes = "分页获取轮播图列表")
	public ServerResponseEntity<PageVO<IndexImgVO>> page(@Valid PageDTO pageDTO, IndexImgDTO indexImgDTO) {
	    indexImgDTO.setShopId(AuthUserContext.get().getTenantId());
		PageVO<IndexImgVO> indexImgPage = indexImgService.page(pageDTO, indexImgDTO);
		return ServerResponseEntity.success(indexImgPage);
	}

	@GetMapping
    @ApiOperation(value = "获取轮播图", notes = "根据imgId获取轮播图")
    public ServerResponseEntity<IndexImgVO> getByImgId(@RequestParam Long imgId) {
        IndexImgVO indexImg = indexImgService.getByImgId(imgId);
        if (Objects.nonNull(indexImg.getSpuId())) {
            ServerResponseEntity<SpuVO> spuResponse = spuFeignClient.getById(indexImg.getSpuId());
            indexImg.setSpu(spuResponse.getData());
        }
        return ServerResponseEntity.success(indexImg);
    }

    @PostMapping
    @ApiOperation(value = "保存轮播图", notes = "保存轮播图")
    public ServerResponseEntity<Void> save(@Valid @RequestBody IndexImgDTO indexImgDTO) {
        IndexImg indexImg = mapperFacade.map(indexImgDTO, IndexImg.class);
        indexImg.setImgId(null);
        indexImg.setShopId(AuthUserContext.get().getTenantId());
        indexImg.setStatus(StatusEnum.ENABLE.value());
        indexImgService.save(indexImg);
        return ServerResponseEntity.success();
    }

    @PutMapping
    @ApiOperation(value = "更新轮播图", notes = "更新轮播图")
    public ServerResponseEntity<Void> update(@Valid @RequestBody IndexImgDTO indexImgDTO) {
        IndexImg indexImg = mapperFacade.map(indexImgDTO, IndexImg.class);
        indexImg.setShopId(AuthUserContext.get().getTenantId());
        indexImgService.update(indexImg);
        return ServerResponseEntity.success();
    }

    @DeleteMapping
    @ApiOperation(value = "删除轮播图", notes = "根据轮播图id删除轮播图")
    public ServerResponseEntity<Void> delete(@RequestParam Long imgId) {
        indexImgService.deleteById(imgId, AuthUserContext.get().getTenantId());
        return ServerResponseEntity.success();
    }
}
