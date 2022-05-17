package com.qinweizhao.search.controller.api;

import com.qinweizhao.api.search.dto.EsSkuSaveDTO;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.search.service.ElasticSaveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
@RestController
@RequestMapping("/elastic/save")
public class ElasticSaveController {

    @Resource
    private ElasticSaveService elasticSaveService;


    /**
     * 商品上架
     */
    @PostMapping("/product")
    public R<Void> saveSku(@RequestBody List<EsSkuSaveDTO> esSkuSaveDTOList) throws IOException {
        return R.condition(elasticSaveService.saveSku(esSkuSaveDTOList));
    }


}
