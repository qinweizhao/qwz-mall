package com.qinweizhao.search.controller.web;

import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.search.model.param.SearchParam;
import com.qinweizhao.search.model.vo.SearchVO;
import com.qinweizhao.search.service.SearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author qinweizhao
 * @since 2022/5/16
 */
@RestController
@RequestMapping("/ua")
public class SearchController {

    @Resource
    private SearchService searchService;

    @PostMapping("/search")
    public R<SearchVO> listPage(@RequestBody SearchParam param) {
        SearchVO result = searchService.search(param);
        return R.success(result);
    }
}
