package com.qinweizhao.product.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.qinweizhao.product.mapper.PmsSkuAttrValueMapper;
import com.qinweizhao.product.model.dto.SkuItemAttrDTO;
import com.qinweizhao.product.model.entity.PmsSkuAttrValue;
import com.qinweizhao.product.service.IPmsSkuAttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
        pmsSkuAttrValue.setCreateTime(LocalDateTime.now());
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
        pmsSkuAttrValue.setUpdateTime(LocalDateTime.now());
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

    @Override
    public List<SkuItemAttrDTO> listSkuItemAttrBySpuId(Long spuId) {
        List<PmsSkuAttrValue> pmsSkuAttrValues = pmsSkuAttrValueMapper.selectListBySpuId(spuId);

        List<SkuItemAttrDTO> returnList = new ArrayList<>();

        // 按照属性值分组
        Map<String, List<PmsSkuAttrValue>> collect = pmsSkuAttrValues.stream().collect(Collectors.groupingBy(PmsSkuAttrValue::getValue));
        Set<String> keySet = collect.keySet();

        for (String key : keySet) {
            List<PmsSkuAttrValue> temList = collect.get(key);

            SkuItemAttrDTO skuItemAttrDTO = new SkuItemAttrDTO();
            PmsSkuAttrValue pmsSkuAttrValue = temList.get(0);
            skuItemAttrDTO.setAttrId(pmsSkuAttrValue.getAttrId());
            skuItemAttrDTO.setAttrName(pmsSkuAttrValue.getName());

            SkuItemAttrDTO.AttrValueWithSkuIdDTO attrValueWithSkuIdDTO = new SkuItemAttrDTO.AttrValueWithSkuIdDTO();
            List<SkuItemAttrDTO.AttrValueWithSkuIdDTO> attrList = new ArrayList<>();
            List<Long> ids = new ArrayList<>();
            temList.forEach(item -> {
                attrValueWithSkuIdDTO.setAttrValue(item.getValue());
                ids.add(item.getSkuId());
            });
            String skuIds = CollUtil.join(ids, ",");
            attrValueWithSkuIdDTO.setSkuIds(skuIds);
            attrList.add(attrValueWithSkuIdDTO);

            skuItemAttrDTO.setAttrValues(attrList);
            returnList.add(skuItemAttrDTO);
        }

        return returnList;
    }
}
