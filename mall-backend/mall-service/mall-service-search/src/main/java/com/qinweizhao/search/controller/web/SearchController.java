package com.qinweizhao.search.controller.web;

import com.qinweizhao.component.modle.result.PageResult;
import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.search.model.param.SearchParam;
import com.qinweizhao.search.model.vo.SearchVO;
import com.qinweizhao.search.service.SearchService;
import org.springframework.web.bind.annotation.*;

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
    public R<PageResult<SearchVO>> listPage(@RequestBody SearchParam param) {
        PageResult<SearchVO> result = searchService.search(param);
        return R.success(result);
    }
}
