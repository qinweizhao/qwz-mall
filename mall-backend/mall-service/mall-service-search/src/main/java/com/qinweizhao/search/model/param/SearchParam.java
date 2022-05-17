package com.qinweizhao.search.model.param;

import com.qinweizhao.component.modle.request.PageParam;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/16
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SearchParam extends PageParam {

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
     * categoryId_asc
     * 排序
     */
    private String order;

    /**
     * attrs: ["23:8G:运行内存"]
     */
    private List<String> attrs;

}
