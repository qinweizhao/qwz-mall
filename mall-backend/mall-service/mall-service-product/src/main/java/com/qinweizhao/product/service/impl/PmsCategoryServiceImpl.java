package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.product.entity.PmsCategory;
import com.qinweizhao.product.mapper.PmsCategoryMapper;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 商品三级分类Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsCategoryServiceImpl implements IPmsCategoryService {

    @Resource
    private PmsCategoryMapper pmsCategoryMapper;

    /**
     * 查询商品三级分类
     *
     * @param categoryId 商品三级分类主键
     * @return 商品三级分类
     */
    @Override
    public PmsCategory getById(Long categoryId) {
        return pmsCategoryMapper.selectById(categoryId);
    }

    /**
     * 查询商品三级分类列表
     *
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<PmsCategory> list(PmsCategory pmsCategory) {
        return pmsCategoryMapper.selectList(pmsCategory);
    }

    /**
     * 新增商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int save(PmsCategory pmsCategory) {
        pmsCategory.setCreateTime(DateUtils.getNowDate());
        return pmsCategoryMapper.insert(pmsCategory);
    }

    /**
     * 修改商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int updateById(PmsCategory pmsCategory) {
        pmsCategory.setUpdateTime(DateUtils.getNowDate());
        return pmsCategoryMapper.updateById(pmsCategory);
    }

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int removeByIds(Long[] categoryIds) {
        return pmsCategoryMapper.removeByIds(categoryIds);
    }

    /**
     * 删除商品三级分类信息
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int removeById(Long categoryId) {
        return pmsCategoryMapper.removeById(categoryId);
    }


    /**
     * 构建分类树
     *
     * @param list list
     * @return List
     */
    @Override
    public List<Map<String, Object>> buildCategoryTree(List<PmsCategory> list) {
        List<PmsCategory> returnList = buildTree(list);
        return returnList.stream().map(item -> {
            Map<String, Object> map = new HashMap<>(3);
            map.put("id", item.getCategoryId());
            map.put("label", item.getName());
            map.put("children", item.getChildren().stream().map(cItem -> {
                Map<String, Object> cMap = new HashMap<>(3);
                cMap.put("id", cItem.getCategoryId());
                cMap.put("label", cItem.getName());
                cMap.put("children", cItem.getChildren().stream().map(ccItem -> {
                    Map<String, Object> ccMap = new HashMap<>(3);
                    ccMap.put("id", ccItem.getCategoryId());
                    ccMap.put("label", ccItem.getName());
                    return ccMap;
                }).collect(Collectors.toList()));
                return cMap;
            }).collect(Collectors.toList()));
            return map;
        }).collect(Collectors.toList());
    }

    /**
     * 构建树
     *
     * @param list list
     * @return List
     */
    private List<PmsCategory> buildTree(List<PmsCategory> list) {
        List<PmsCategory> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<>();
        for (PmsCategory category : list) {
            tempList.add(category.getCategoryId());
        }
        for (PmsCategory category : list) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(category.getParentId())) {
                recursionFn(list, category);
                returnList.add(category);
            }
        }
        if (returnList.isEmpty()) {
            returnList = list;
        }
        return returnList;
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<PmsCategory> list, PmsCategory category) {
        // 得到子节点列表
        List<PmsCategory> childList = getChildList(list, category);
        category.setChildren(childList);
        for (PmsCategory tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<PmsCategory> getChildList(List<PmsCategory> list, PmsCategory t) {
        List<PmsCategory> tList = new ArrayList<>();
        for (PmsCategory n : list) {
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getCategoryId().longValue()) {
                tList.add(n);
            }
        }
        return tList;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<PmsCategory> list, PmsCategory t) {
        return getChildList(list, t).size() > 0;
    }

}
