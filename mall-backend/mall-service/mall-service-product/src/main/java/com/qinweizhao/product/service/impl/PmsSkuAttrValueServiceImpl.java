package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSkuAttrValue;
import com.qinweizhao.product.mapper.PmsSkuAttrValueMapper;
import com.qinweizhao.product.service.IPmsSkuAttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku销售属性&值Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSkuAttrValueServiceImpl implements IPmsSkuAttrValueService {

    @Resource
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    /**
     * 查询sku销售属性&值
     *
     * @param id sku销售属性&值主键
     * @return sku销售属性&值
     */
    @Override
    public PmsSkuAttrValue getById(Long id) {
        return pmsSkuAttrValueMapper.selectPmsSkuAttrValueById(id);
    }

    /**
     * 查询sku销售属性&值列表
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return sku销售属性&值
     */
    @Override
    public List<PmsSkuAttrValue> list(PmsSkuAttrValue pmsSkuAttrValue) {
        return pmsSkuAttrValueMapper.selectPmsSkuAttrValueList(pmsSkuAttrValue);
    }

    /**
     * 新增sku销售属性&值
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return 结果
     */
    @Override
    public int save(PmsSkuAttrValue pmsSkuAttrValue) {
        pmsSkuAttrValue.setCreateTime(DateUtils.getNowDate());
        return pmsSkuAttrValueMapper.insertPmsSkuAttrValue(pmsSkuAttrValue);
    }

    /**
     * 修改sku销售属性&值
     *
     * @param pmsSkuAttrValue sku销售属性&值
     * @return 结果
     */
    @Override
    public int updateById(PmsSkuAttrValue pmsSkuAttrValue) {
        pmsSkuAttrValue.setUpdateTime(DateUtils.getNowDate());
        return pmsSkuAttrValueMapper.updatePmsSkuAttrValue(pmsSkuAttrValue);
    }

    /**
     * 批量删除sku销售属性&值
     *
     * @param ids 需要删除的sku销售属性&值主键
     * @return 结果
     */
    @Override
    public int removeByIds(Long[] ids) {
        return pmsSkuAttrValueMapper.deletePmsSkuAttrValueByIds(ids);
    }

    /**
     * 删除sku销售属性&值信息
     *
     * @param id sku销售属性&值主键
     * @return 结果
     */
    @Override
    public int removeById(Long id) {
        return pmsSkuAttrValueMapper.deletePmsSkuAttrValueById(id);
    }
}
