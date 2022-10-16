package com.qinweizhao.search.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import com.qinweizhao.api.search.model.param.EsSkuSaveParam;
import com.qinweizhao.search.model.constant.EsConstant;
import com.qinweizhao.search.service.ElasticSaveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/13
 */
@Slf4j
@Service
public class ElasticSaveServiceImpl implements ElasticSaveService {

    @Resource
    private ElasticsearchClient elasticsearchClient;


    /**
     * 若使用 json
     * 参考：
     * <p>
     * String s ="{'level': 'warn'}";
     * StringReader stringReader = new StringReader(s);
     * IndexResponse json = client.index(i -> i.index("bank").withJson(stringReader));
     * </p>
     *
     * @param esSkuSaveParamList esSkuSaveDTOList
     * @return boolean
     * @throws IOException e
     */
    @Override
    public boolean saveSku(List<EsSkuSaveParam> esSkuSaveParamList) throws IOException {

        //保存到es
        //1、给es中建立索引。product，建立好映射关系
        //2、给es中保存这些数据

        BulkRequest.Builder br = new BulkRequest.Builder();

        for (EsSkuSaveParam esSkuSaveParam : esSkuSaveParamList) {
            br.operations(op -> op
                    .index(idx -> idx
                            .index(EsConstant.PRODUCT_INDEX)
                            .document(esSkuSaveParam)

                    )
            );
        }
        BulkResponse result = elasticsearchClient.bulk(br.build());

        if (result.errors()) {
            for (BulkResponseItem item : result.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }

        return !result.errors();
    }

}
