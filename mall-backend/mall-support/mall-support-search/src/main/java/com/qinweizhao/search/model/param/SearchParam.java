package com.qinweizhao.search.model.param;

import lombok.Data;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/16
 */
@Data
public class SearchParam {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 分类id
     */
    private String categoryId;

    /**
     * 按照品牌进行查询，可以多选  v
     *  "5:OPPO"
     */
    private List<Long> brandId;

    /**
     * 排序
     */
    private String sorts;

    /**
     * props: ["23:8G:运行内存"]
     */
    private List<String> props;

}
