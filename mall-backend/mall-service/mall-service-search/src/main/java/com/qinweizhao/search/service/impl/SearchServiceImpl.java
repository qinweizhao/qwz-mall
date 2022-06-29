package com.qinweizhao.search.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.FieldValue;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.aggregations.Aggregate;
import co.elastic.clients.elasticsearch._types.aggregations.LongTermsBucket;
import co.elastic.clients.elasticsearch._types.aggregations.StringTermsBucket;
import co.elastic.clients.elasticsearch._types.query_dsl.BoolQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.qinweizhao.api.search.model.param.EsSkuSaveParam;
import com.qinweizhao.common.core.exception.ServiceException;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.search.convert.SearchConvert;
import com.qinweizhao.search.model.constant.EsConstant;
import com.qinweizhao.search.model.param.SearchParam;
import com.qinweizhao.search.model.vo.SearchVO;
import com.qinweizhao.search.service.SearchService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
    private static final String CATEGORY_NAME = "categoryName";
    private static final String BRAND_ID = "brandId";
    private static final String BRAND_NAME = "brandName";
    private static final String BRAND_IMG = "brandImg";
    private static final String NESTED_PATH = "attrs";
    private static final String ATTRS_ATTR_ID = "attrs.attrId";
    private static final String ATTRS_ATTR_VALUE = "attrs.attrValue";
    private static final String ATTRS_ATTR_NAME = "attrs.attrName";
    private static final String AGG_CATEGORY = "agg_category";
    private static final String AGG_CATEGORY_NAME = "agg_category_name";
    private static final String AGG_BRAND = "agg_brand";
    private static final String AGG_BRAND_NAME = "agg_brand_name";
    private static final String AGG_BRAND_IMG = "agg_brand_img";
    private static final String AGG_ATTR = "agg_attr";
    private static final String AGG_ATTR_ID = "agg_attr_id";
    private static final String AGG_ATTR_NAME = "agg_attr_name";
    private static final String AGG_ATTR_VALUE = "agg_attr_value";


    @Resource
    private ElasticsearchClient elasticsearchClient;

    @Override
    public SearchVO search(SearchParam param) {
        SearchRequest searchRequest = this.buildSearchRequest(param);
        SearchVO result;
        try {
            SearchResponse<EsSkuSaveParam> searchResponse = elasticsearchClient.search(searchRequest, EsSkuSaveParam.class);
            result = this.buildSearchResult(searchResponse);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("检索异常");
        }
        return result;
    }

    /**
     * 构建检索请求
     *
     * @param param param
     * @return SearchRequest
     */
    private SearchRequest buildSearchRequest(SearchParam param) {
        SearchRequest.Builder builder = new SearchRequest.Builder();
        builder.index(EsConstant.PRODUCT_INDEX);

        // query
        Query query = this.buildQuery(param);
        builder.query(query);


        // page
        this.buildPage(param, builder);


        // sort
        // sort=hotScore_asc/desc
        String sort = param.getOrder();
        if (StringUtils.isNotEmpty(sort)) {
            String[] ss = sort.split("_");
            String attrId = ss[0];
            String order = ss[1];
            {
                builder.sort(s ->
                        s.field(f ->
                                f.field(attrId).order(SortOrder.Asc.toString().equals(order) ? SortOrder.Asc : SortOrder.Desc)
                        )
                );
            }
        }

        // highlight
        builder.highlight(h ->
                h.fields(TITLE, i -> i.preTags("<font color='red'>").postTags("</font>"))
        );


        // aggregations
        this.buildAggregations(builder);


        return builder.build();
    }

    /**
     * 构建聚合
     *
     * @param builder builder
     */
    private void buildAggregations(SearchRequest.Builder builder) {
        // categoryId
        builder.aggregations(AGG_CATEGORY, a ->
                a.terms(t ->
                                t.field(CATEGORY_ID)
                        )
                        .aggregations(
                                AGG_CATEGORY_NAME, subA ->
                                        subA.terms(subT ->
                                                subT.field(CATEGORY_NAME)
                                        )
                        )
        );

        // brandId
        builder.aggregations(AGG_BRAND, a ->
                a.terms(t ->
                                t.field(BRAND_ID)
                        )
                        .aggregations(AGG_BRAND_NAME, subA ->
                                subA.terms(subT ->
                                        subT.field(BRAND_NAME)
                                )
                        )
                        .aggregations(AGG_BRAND_IMG, subA ->
                                subA.terms(subT ->
                                        subT.field(BRAND_IMG)
                                )
                        )
        );

        // attr
        builder.aggregations(AGG_ATTR, a ->
                a.nested(n ->
                        n.path(NESTED_PATH)
                ).aggregations(
                        AGG_ATTR_ID, na ->
                                na.terms(t ->
                                                t.field(ATTRS_ATTR_ID)
                                        )
                                        .aggregations(AGG_ATTR_VALUE, subA ->
                                                subA.terms(subT ->
                                                        subT.field(ATTRS_ATTR_VALUE)
                                                )
                                        )
                                        .aggregations(AGG_ATTR_NAME, subA ->
                                                subA.terms(subT ->
                                                        subT.field(ATTRS_ATTR_NAME)
                                                )
                                        )
                )

        );
    }


    /**
     * 构建分页
     *
     * @param param   param
     * @param builder builder
     */
    private void buildPage(SearchParam param, SearchRequest.Builder builder) {
        int pageNum = param.getPageNum();
        int pageSize = param.getPageSize();

        // from
        builder.from((pageNum - 1) * pageSize);

        // size
        builder.size(pageSize);
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
        // terms
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
        //   id_value1:value2
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
                                n.path(NESTED_PATH).query(new Query(nestedBuilder.build()))
                        )
                );
            }
        }

        // Query
        return new Query(boolBuilder.build());
    }

    /**
     * 构建结果
     *
     * @param response response
     * @return PageResult
     */
    private SearchVO buildSearchResult(SearchResponse<EsSkuSaveParam> response) {
        SearchVO searchVO = new SearchVO();
        List<Hit<EsSkuSaveParam>> hits = response.hits().hits();
        if (ObjectUtils.isEmpty(hits)) {
            return new SearchVO();
        }

        // products
        List<EsSkuSaveParam> esSkus = new ArrayList<>();
        hits.forEach(item -> {
            EsSkuSaveParam source = item.source();
            Map<String, List<String>> highlight = item.highlight();
            if (!ObjectUtils.isEmpty(highlight)) {
                List<String> strings = highlight.get(TITLE);
                String s = strings.get(0);
                assert source != null;
                source.setSkuTitle(s);
            }
            esSkus.add(source);
        });
        searchVO.setProducts(SearchConvert.INSTANCE.convertToVO(esSkus));

        Map<String, Aggregate> aggregations = response.aggregations();

        // category
        ArrayList<SearchVO.Category> categoryList = new ArrayList<>();
        Aggregate aggregate = aggregations.get(AGG_CATEGORY);
        List<LongTermsBucket> array = aggregate.lterms().buckets().array();
        array.forEach(item ->
                {
                    SearchVO.Category category = new SearchVO.Category();
                    category.setCategoryId(Long.parseLong(item.key()));
                    Aggregate categoryNameAgg = item.aggregations().get(AGG_CATEGORY_NAME);
                    List<StringTermsBucket> list = categoryNameAgg.sterms().buckets().array();
                    list.forEach(i -> {
                                category.setCategoryName(i.key());
                                categoryList.add(category);
                            }
                    );
                }
        );
        searchVO.setCategories(categoryList);

        // brand
        ArrayList<SearchVO.Brand> brandList = new ArrayList<>();
        Aggregate aggBrand = aggregations.get(AGG_BRAND);
        List<LongTermsBucket> brandArray = aggBrand.lterms().buckets().array();
        brandArray.forEach(item ->
                {
                    SearchVO.Brand brand = new SearchVO.Brand();
                    brand.setBrandId(Long.parseLong(item.key()));
                    Aggregate categoryNameAgg = item.aggregations().get(AGG_BRAND_NAME);
                    List<StringTermsBucket> list = categoryNameAgg.sterms().buckets().array();
                    list.forEach(i ->
                            brand.setBrandName(i.key())
                    );
                    Aggregate aggBrandName = item.aggregations().get(AGG_BRAND_IMG);
                    List<StringTermsBucket> aggBrandNameBucketList = aggBrandName.sterms().buckets().array();
                    aggBrandNameBucketList.forEach(i ->
                            brand.setBrandImg(i.key())
                    );
                    brandList.add(brand);
                }
        );
        searchVO.setBrands(brandList);

        // attrs
        ArrayList<SearchVO.Attr> attrList = new ArrayList<>();
        Aggregate aggAttr = aggregations.get(AGG_ATTR);
        Map<String, Aggregate> attrAggregate = aggAttr.nested().aggregations();
        List<LongTermsBucket> attrIdAgg = attrAggregate.get(AGG_ATTR_ID).lterms().buckets().array();
        attrIdAgg.forEach(a ->
                {
                    SearchVO.Attr attr = new SearchVO.Attr();
                    String attrId = a.key();
                    attr.setAttrId(Long.parseLong(attrId));
                    List<StringTermsBucket> attrNameAgg = a.aggregations().get(AGG_ATTR_NAME).sterms().buckets().array();
                    attrNameAgg.forEach(an ->
                            attr.setAttrName(an.key())
                    );
                    List<StringTermsBucket> attrValueAgg = a.aggregations().get(AGG_ATTR_VALUE).sterms().buckets().array();
                    List<String> attrValues = new ArrayList<>();
                    attrValueAgg.forEach(av ->
                            attrValues.add(av.key())
                    );
                    attr.setAttrValue(attrValues);
                    attrList.add(attr);
                }
        );
        searchVO.setAttrs(attrList);

        return searchVO;
    }
}
