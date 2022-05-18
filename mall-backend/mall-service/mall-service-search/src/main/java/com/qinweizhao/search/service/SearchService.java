package com.qinweizhao.search.service;

import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.search.model.param.SearchParam;
import com.qinweizhao.search.model.vo.SearchVO;

/**
 * @author qinweizhao
 * @since 2022/5/17
 */
public interface SearchService {

    /**
     * 检索
     * @param param param
     * @return PageResult
     */
    SearchVO search(SearchParam param);
}
