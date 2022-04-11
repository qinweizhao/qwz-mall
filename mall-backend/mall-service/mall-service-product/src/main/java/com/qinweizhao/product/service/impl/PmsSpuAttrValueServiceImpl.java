package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsSpuAttrValue;
import com.qinweizhao.product.mapper.PmsSpuAttrValueMapper;
import com.qinweizhao.product.service.IPmsSpuAttrValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * spu属性值Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsSpuAttrValueServiceImpl implements IPmsSpuAttrValueService {
    @Resource
    private PmsSpuAttrValueMapper pmsSpuAttrValueMapper;

    /**
     * 查询spu属性值
     *
     * @param id spu属性值主键
     * @return spu属性值
     */
    @Override
    public PmsSpuAttrValue selectPmsSpuAttrValueById(Long id) {
        return pmsSpuAttrValueMapper.selectPmsSpuAttrValueById(id);
    }

    /**
     * 查询spu属性值列表
     *
     * @param pmsSpuAttrValue spu属性值
     * @return spu属性值
     */
    @Override
    public List<PmsSpuAttrValue> selectPmsSpuAttrValueList(PmsSpuAttrValue pmsSpuAttrValue) {
        return pmsSpuAttrValueMapper.selectPmsSpuAttrValueList(pmsSpuAttrValue);
    }

    /**
     * 新增spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    @Override
    public int insertPmsSpuAttrValue(PmsSpuAttrValue pmsSpuAttrValue) {
        pmsSpuAttrValue.setCreateTime(DateUtils.getNowDate());
        return pmsSpuAttrValueMapper.insertPmsSpuAttrValue(pmsSpuAttrValue);
    }

    /**
     * 修改spu属性值
     *
     * @param pmsSpuAttrValue spu属性值
     * @return 结果
     */
    @Override
    public int updatePmsSpuAttrValue(PmsSpuAttrValue pmsSpuAttrValue) {
        pmsSpuAttrValue.setUpdateTime(DateUtils.getNowDate());
        return pmsSpuAttrValueMapper.updatePmsSpuAttrValue(pmsSpuAttrValue);
    }

    /**
     * 批量删除spu属性值
     *
     * @param ids 需要删除的spu属性值主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuAttrValueByIds(Long[] ids) {
        return pmsSpuAttrValueMapper.deletePmsSpuAttrValueByIds(ids);
    }

    /**
     * 删除spu属性值信息
     *
     * @param id spu属性值主键
     * @return 结果
     */
    @Override
    public int deletePmsSpuAttrValueById(Long id) {
        return pmsSpuAttrValueMapper.deletePmsSpuAttrValueById(id);
    }
}
