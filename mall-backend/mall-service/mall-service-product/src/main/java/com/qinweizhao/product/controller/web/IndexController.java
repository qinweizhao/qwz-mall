package com.qinweizhao.product.controller.web;

import com.qinweizhao.component.modle.result.R;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author qinweizhao
 * @since 2022/5/14
 */
@RestController
@RequestMapping("/ua")
public class IndexController {


    @Resource
    private IPmsCategoryService pmsCategoryService;


    /**
     * 树
     */
    @GetMapping("/category/tree")
    public R<List<Map<String, Object>>> tree(PmsCategory pmsCategory) {
        List<PmsCategory> list = pmsCategoryService.list(pmsCategory);
        return R.success(pmsCategoryService.buildCategoryTree(list));
    }
}
