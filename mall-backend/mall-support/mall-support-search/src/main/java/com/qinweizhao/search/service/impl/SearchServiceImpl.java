package com.qinweizhao.search.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.*;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.HighlightField;
import com.qinweizhao.api.search.dto.EsSkuSaveDTO;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.search.model.constant.EsConstant;
import com.qinweizhao.search.model.param.SearchParam;
import com.qinweizhao.search.model.vo.SearchVO;
import com.qinweizhao.search.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author qinweizhao
 * @since 2022/5/17
 */
@Service
public class SearchServiceImpl implements SearchService {


    /**
     * 储存在 es 中的属性名
     */
    private static final String TITLE = "skuTitle";
    private static final String CATEGORY_ID = "categoryId";
    private static final String BRAND_ID = "brandId";
    private static final String NESTED_PATH = "attrs";
    private static final String ATTRS_ATTR_ID = "attrs.attrId";
    private static final String ATTRS_ATTR_VALUE = "attrs.value";


    @Resource
    private ElasticsearchClient elasticsearchClient;

    @Override
    public PageResult<SearchVO> search(SearchParam param) {
        SearchRequest searchRequest = buildSearchRequest(param);
        System.out.println("dsl"+searchRequest.toString());
        PageResult<SearchVO> result;
        try {
            SearchResponse<EsSkuSaveDTO> searchResponse = elasticsearchClient.search(searchRequest, EsSkuSaveDTO.class);
            long value = searchResponse.hits().total().value();

            System.out.println(value);
            //            result = buildSearchResult(searchResponse);
        } catch (Exception e) {
            throw new ServiceException("检索失败");
        }
        return null;
    }

    /**
     * 构建检索请求
     *
     * @param param param
     * @return SearchRequest
     */
    private SearchRequest buildSearchRequest(SearchParam param) {
        SearchRequest.Builder builder = new SearchRequest.Builder();
        builder.index("mall_product");

        // query
        Query query = buildQuery(param);
        builder.query(query);

        int pageNum = param.getPageNum();
        int pageSize = param.getPageSize();
        // from
        builder.from((pageNum - 1) * pageSize);

        // size
        builder.size(pageSize);
//
//        // highlighter
//        builder.highlight(h ->
//                h.fields(TITLE, (HighlightField) null).preTags("<b style='color:red'>").postTags("</b>")
//        );


        // sort
        // sort=hotScore_asc/desc
        String sort = param.getSort();
        if (StringUtils.isNotEmpty(sort)) {
            {
                SortOptions sortOptions = buildSortOptions(sort);
                builder.sort(sortOptions);
            }
        }


        String s = builder.toString();
        System.out.println("builder.build()"+s);
        return builder.build();
    }


    /**
     * 构建排序
     *
     * @param sort sort
     * @return SortOptions
     */
    private SortOptions buildSortOptions(String sort) {
        String[] s = sort.split("_");
        String attr = s[0];
        String order = s[1];
        GeoDistanceSort.Builder builder2 = new GeoDistanceSort.Builder();
        builder2.field(attr);
        builder2.order(SortOrder.Asc.toString().equals(order) ? SortOrder.Asc : SortOrder.Desc);
        SortOptionsVariant sortOptionsVariant = builder2.build();
        return new SortOptions(sortOptionsVariant);
    }


    /**
     * 构建查询部分
     *
     * @param param param
     * @return Query
     */
    private Query buildQuery(SearchParam param) {
        // 构建 BoolQuery
        BoolQuery.Builder boolBuilder = new BoolQuery.Builder();

        // 按条件查询

        // 关键字
        String keyword = param.getKeyword();
        if (StringUtils.isNotNull(keyword)) {
            boolBuilder.must(item ->
                    item.match(m ->
                            m.field(TITLE).query(keyword)
                    )
            );
        }

        // 分类
        String categoryId = param.getCategoryId();
        if (StringUtils.isNotNull(categoryId)) {
            boolBuilder.filter(f ->
                    f.term(t ->
                            t.field(CATEGORY_ID).value(categoryId)
                    )
            );
        }

        // 品牌
        List<Long> brandIds = param.getBrandId();
        if (!ObjectUtils.isEmpty(brandIds)) {
            List<FieldValue> collect = brandIds.stream().map(FieldValue::of).collect(Collectors.toList());
            boolBuilder.filter(f ->
                    f.terms(t ->
                            t.field(BRAND_ID).terms(i ->
                                    i.value(collect)
                            )
                    )
            );
        }

        // 属性
        // ["23:8G:运行内存"]  id value name
        // attrs=1_5寸:8寸&attrs=2_16G:8G
        // 新规范  id_value1:value2
        List<String> attrs = param.getAttrs();
        if (!ObjectUtils.isEmpty(attrs)) {
            for (String attr : attrs) {
                String[] props = attr.split("_");
                String attrId = props[0];
                String attrValues = props[1];
                String[] values = attrValues.split(":");
                BoolQuery.Builder nestedBuilder = QueryBuilders.bool();

                nestedBuilder.must(m ->
                        m.term(t ->
                                t.field(ATTRS_ATTR_ID).value(attrId)
                        )
                );

                List<FieldValue> valueList = Arrays.stream(values).map(FieldValue::of).collect(Collectors.toList());
                nestedBuilder.must(m ->
                        m.terms(t ->
                                t.field(ATTRS_ATTR_VALUE).terms(
                                        i ->
                                                i.value(valueList)
                                )
                        )
                );
                boolBuilder.filter(f ->
                        f.nested(n ->
                                n.query(new Query(nestedBuilder.build())).path(NESTED_PATH)
                        )
                );
            }
        }


        String s = boolBuilder.toString();
        System.out.println("Sssss----"+s);
        // Query
        return new Query(boolBuilder.build());
    }

    /**
     * 构建结果
     *
     * @param searchResponse searchResponse
     * @return PageResult
     */
    private PageResult<SearchVO> buildSearchResult(SearchResponse<SearchVO> searchResponse) {
        return null;
    }
}
