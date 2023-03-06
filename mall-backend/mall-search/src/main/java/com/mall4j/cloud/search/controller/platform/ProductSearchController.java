package com.mall4j.cloud.search.controller.platform;

import com.mall4j.cloud.api.dto.EsPageDTO;
import com.mall4j.cloud.api.dto.ProductSearchDTO;
import com.mall4j.cloud.api.vo.EsPageVO;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.search.constant.SearchTypeEnum;
import com.mall4j.cloud.search.manager.ProductSearchManager;
import com.mall4j.cloud.search.vo.SpuAdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author lth
 * @Date 2021/6/21 13:48
 */
@RestController("platformSearchSpuController")
@RequestMapping("/p/search")
@Api(tags = "platform-spu列表接口")
public class ProductSearchController {

    @Autowired
    private ProductSearchManager productSearchManager;

    @GetMapping("/page")
    @ApiOperation(value = "商品管理信息列表（平台端）", notes = "商品管理信息列表（平台端）")
    public ServerResponseEntity<EsPageVO<SpuAdminVO>> adminPage(@Valid EsPageDTO pageDTO, ProductSearchDTO productSearchDTO) {
        productSearchDTO.setSearchType(SearchTypeEnum.PLATFORM.value());
        EsPageVO<SpuAdminVO> searchPage =  productSearchManager.adminPage(pageDTO, productSearchDTO);
        return ServerResponseEntity.success(searchPage);
    }
}
