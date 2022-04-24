package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.core.utils.StringUtils;
import com.qinweizhao.product.entity.PmsCategory;
import com.qinweizhao.product.mapper.PmsCategoryMapper;
import com.qinweizhao.product.service.IPmsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
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
    public PmsCategory selectPmsCategoryByCategoryId(Long categoryId) {
        return pmsCategoryMapper.selectPmsCategoryByCategoryId(categoryId);
    }

    /**
     * 查询商品三级分类列表
     *
     * @param pmsCategory 商品三级分类
     * @return 商品三级分类
     */
    @Override
    public List<PmsCategory> selectPmsCategoryList(PmsCategory pmsCategory) {
        return pmsCategoryMapper.selectPmsCategoryList(pmsCategory);
    }

    /**
     * 新增商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int insertPmsCategory(PmsCategory pmsCategory) {
        pmsCategory.setCreateTime(DateUtils.getNowDate());
        return pmsCategoryMapper.insertPmsCategory(pmsCategory);
    }

    /**
     * 修改商品三级分类
     *
     * @param pmsCategory 商品三级分类
     * @return 结果
     */
    @Override
    public int updatePmsCategory(PmsCategory pmsCategory) {
        pmsCategory.setUpdateTime(DateUtils.getNowDate());
        return pmsCategoryMapper.updatePmsCategory(pmsCategory);
    }

    /**
     * 批量删除商品三级分类
     *
     * @param categoryIds 需要删除的商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCategoryIds(Long[] categoryIds) {
        return pmsCategoryMapper.deletePmsCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除商品三级分类信息
     *
     * @param categoryId 商品三级分类主键
     * @return 结果
     */
    @Override
    public int deletePmsCategoryByCategoryId(Long categoryId) {
        return pmsCategoryMapper.deletePmsCategoryByCategoryId(categoryId);
    }

    @Override
    public List<Map<String, Object>> buildCategoryTreeSelect(List<PmsCategory> list) {
        List<PmsCategory> returnList = buildTree(list);
        List<Map<String, Object>> collect = returnList.stream().map(item -> {
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
        return collect;
    }

    private List<PmsCategory> buildTree(List<PmsCategory> list) {
        List<PmsCategory> returnList = new ArrayList<>();
        List<Long> tempList = new ArrayList<Long>();
        for (PmsCategory category : list) {
            tempList.add(category.getCategoryId());
        }
        for (Iterator<PmsCategory> iterator = list.iterator(); iterator.hasNext(); ) {
            PmsCategory category = iterator.next();
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
        Iterator<PmsCategory> it = list.iterator();
        while (it.hasNext()) {
            PmsCategory n = it.next();
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
