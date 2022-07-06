package com.qinweizhao.product.controller.app;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.convert.CategoryConvert;
import com.qinweizhao.product.model.entity.PmsCategory;
import com.qinweizhao.product.model.vo.CategoryVO;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author qinweizhao
 * @since 2022/5/14
 */
@RestController
@RequestMapping("/app/category")
public class CategoryController {


    @Resource
    private IPmsCategoryService pmsCategoryService;


    /**
     * 树
     *
     * @return List
     */
    @GetMapping("/tree")
    public R<List<CategoryVO>> tree() {
        List<CategoryVO> list = pmsCategoryService.getCategoryTree();
        return R.success(list);
    }

    /**
     * 列表
     * @param pmsCategory pmsCategory
     * @return List
     */
    @GetMapping("/list")
    public R<List<CategoryVO>> list(PmsCategory pmsCategory) {
        List<PmsCategory> list = pmsCategoryService.list(pmsCategory);
        return R.success(CategoryConvert.INSTANCE.convertToVO(list));
    }


}
