package com.qinweizhao.api.search.feign;

import com.qinweizhao.api.search.model.param.EsSkuSaveParam;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.component.core.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
@FeignClient(ServiceNameConstants.SEARCH_SERVICE)
public interface ElasticSaveFeignService {

    /**
     * 是否有库存
     * @param esSkuSaveParamList esSkuSaveDTOList
     * @return R
     */
    @PostMapping("/elastic/save/product")
    R<?> saveEsSkuList(List<EsSkuSaveParam> esSkuSaveParamList);
}
