package com.qinweizhao.api.search.feign;

import com.qinweizhao.api.search.dto.EsSkuSaveDTO;
import com.qinweizhao.common.core.constant.ServiceNameConstants;
import com.qinweizhao.component.modle.result.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
@FeignClient(ServiceNameConstants.SEARCH_SERVICE)
public interface ElasticSaveFeignService {

    /**
     * 是否有库存
     * @param esSkuSaveDTOList esSkuSaveDTOList
     * @return R
     */
    @PostMapping("/elastic/save/product")
    R<Void> saveEsSkuList(List<EsSkuSaveDTO> esSkuSaveDTOList);
}
