package com.qinweizhao.search.controller.app;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.core.response.R;
import com.qinweizhao.search.model.param.SearchParam;
import com.qinweizhao.search.model.vo.SearchVO;
import com.qinweizhao.search.service.SearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/16
 */
@RestController
@RequestMapping("/app/search")
public class SearchController {

    @Resource
    private SearchService searchService;

    @GetMapping
    public R<SearchVO> listPage(SearchParam param) {
        SearchVO result = searchService.search(param);
        return R.success(result);
    }

    @GetMapping("/sample-page")
    public R<PageResult<SearchVO.Product>> samplePage(SearchParam param) {
        SearchVO searchVO = searchService.search(param);
        List<SearchVO.Product> products = searchVO.getProducts();
        PageResult<SearchVO.Product> objectPageResult = new PageResult<>();
        objectPageResult.setRows(products);
        return R.success(objectPageResult);
    }


}
