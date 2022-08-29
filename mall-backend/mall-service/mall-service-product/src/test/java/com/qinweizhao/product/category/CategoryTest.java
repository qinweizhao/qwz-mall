package com.qinweizhao.product.category;

import com.qinweizhao.product.service.IPmsCategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author qinweizhao
 * @since 2022/8/29
 */
@SpringBootTest
public class CategoryTest {

    @Autowired
    private IPmsCategoryService pmsCategoryService;

    @Test
    void testGetTopCategory(){
        Long topCategoryId = pmsCategoryService.getTopCategoryId(225L);

        System.out.println(topCategoryId);
    }
}
