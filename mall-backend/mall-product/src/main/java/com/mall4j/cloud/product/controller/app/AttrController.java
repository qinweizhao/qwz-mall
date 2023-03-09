package com.mall4j.cloud.product.controller.app;

import com.mall4j.cloud.api.product.vo.AttrVO;
import com.mall4j.cloud.common.response.ServerResponseEntity;
import com.mall4j.cloud.product.service.AttrService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 属性信息
 *
 * @author FrozenWatermelon
 * @date 2020-10-28 15:27:23
 */
@RestController("appAttrController")
@RequestMapping("/ua/attr")
@Tag(name = "app-属性信息")
public class AttrController {

    @Autowired
    private AttrService attrService;

    @Autowired
	private MapperFacade mapperFacade;

	@GetMapping
	@Operation(summary = "获取属性信息" , description = "根据attrId获取属性信息")
	public ServerResponseEntity<AttrVO> getByAttrId(@RequestParam Long attrId) {
		return ServerResponseEntity.success(attrService.getByAttrId(attrId));
	}
}
