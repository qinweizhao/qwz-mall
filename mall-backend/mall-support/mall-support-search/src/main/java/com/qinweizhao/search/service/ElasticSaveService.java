package com.qinweizhao.search.service;

import com.qinweizhao.api.search.model.param.EsSkuSaveParam;

import java.io.IOException;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
public interface ElasticSaveService {

    /**
     * 商品上架
     * @param esSkuSaveParamList esSkuSaveDTOList
     * @return int
     */
    boolean saveSku(List<EsSkuSaveParam> esSkuSaveParamList) throws IOException;
}
