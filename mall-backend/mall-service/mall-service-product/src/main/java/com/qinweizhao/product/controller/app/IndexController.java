package com.qinweizhao.product.controller.app;

import com.qinweizhao.component.core.response.R;
import com.qinweizhao.product.convert.CategoryConvert;
import com.qinweizhao.product.model.dto.CategoryTreeDTO;
import com.qinweizhao.product.model.vo.CategoryTreeVO;
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
@RequestMapping("/ua")
public class IndexController {


    @Resource
    private IPmsCategoryService pmsCategoryService;


    /**
     * 树
     */
    @GetMapping("/category/tree")
    public R<List<CategoryTreeVO>> tree() {
        List<CategoryTreeDTO> categoryTreeDTOList = pmsCategoryService.getCategoryTree();
        return R.success(CategoryConvert.INSTANCE.convertToVO(categoryTreeDTOList));
    }
}
