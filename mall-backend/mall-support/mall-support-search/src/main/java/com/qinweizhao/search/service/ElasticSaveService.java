package com.qinweizhao.search.service;

import com.qinweizhao.api.search.dto.EsSkuSaveDTO;

import java.io.IOException;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
public interface ElasticSaveService {

    /**
     * 商品上架
     * @param esSkuSaveDTOList esSkuSaveDTOList
     * @return int
     */
    boolean saveSku(List<EsSkuSaveDTO> esSkuSaveDTOList) throws IOException;
}
