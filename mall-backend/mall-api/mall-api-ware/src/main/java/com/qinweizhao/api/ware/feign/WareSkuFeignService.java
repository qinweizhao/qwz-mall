package com.qinweizhao.api.ware.feign;

import com.qinweizhao.api.ware.dto.SkuHasStockDTO;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.component.modle.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
@FeignClient(ServiceNameConstants.WARE_SERVICE)
public interface WareSkuFeignService {


    /**
     * 是否有库存
     * @param skuIds skuIds
     * @return R
     */
    @PostMapping("/ware-sku/stock")
    R<List<SkuHasStockDTO>> listHasStockBySkuIds(@RequestBody List<Long> skuIds);
}
