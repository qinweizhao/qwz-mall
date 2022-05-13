package com.qinweizhao.search.service;

import com.qinweizhao.api.search.dto.EsSkuSaveDTO;

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
    int saveProduct(List<EsSkuSaveDTO> esSkuSaveDTOList);
}
