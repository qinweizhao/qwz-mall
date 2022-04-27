package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.core.utils.bean.BeanUtils;
import com.qinweizhao.product.entity.PmsAttr;
import com.qinweizhao.product.entity.PmsAttrAttrGroup;
import com.qinweizhao.product.entity.vo.PmsAttrVO;
import com.qinweizhao.product.mapper.PmsAttrAttrGroupMapper;
import com.qinweizhao.product.mapper.PmsAttrMapper;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品属性Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
@Service
public class PmsAttrServiceImpl implements IPmsAttrService {

    @Resource
    private PmsAttrMapper pmsAttrMapper;
    @Resource
    private PmsAttrAttrGroupMapper pmsAttrAttrGroupMapper;

    /**
     * 查询商品属性
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    @Override
    public PmsAttr selectPmsAttrByAttrId(Long attrId) {
        return pmsAttrMapper.selectPmsAttrByAttrId(attrId);
    }

    /**
     * 查询商品属性列表
     *
     * @param pmsAttr 商品属性
     * @return 商品属性
     */
    @Override
    public List<PmsAttr> selectPmsAttrList(PmsAttr pmsAttr) {
        return pmsAttrMapper.selectPmsAttrList(pmsAttr);
    }

    /**
     * 新增商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertPmsAttr(PmsAttrVO pmsAttr) {
        PmsAttr attr = new PmsAttr();
        attr.setCreateTime(DateUtils.getNowDate());
        BeanUtils.copyProperties(pmsAttr, attr);
        Long attrId = pmsAttr.getAttrId();
        if (attrId != null) {
            PmsAttrAttrGroup pmsAttrAttrGroup = new PmsAttrAttrGroup();
            pmsAttrAttrGroup.setAttrId(pmsAttr.getAttrId());
            pmsAttrAttrGroup.setAttrGroupId(pmsAttr.getAttrGroupId());
            pmsAttrAttrGroupMapper.insertPmsAttrAttrGroup(pmsAttrAttrGroup);
        }
        return pmsAttrMapper.insertPmsAttr(attr);
    }

    /**
     * 修改商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    @Override
    public int updatePmsAttr(PmsAttrVO pmsAttr) {
        PmsAttr attr = new PmsAttr();
        attr.setUpdateTime(DateUtils.getNowDate());
        BeanUtils.copyProperties(pmsAttr, attr);
        Long attrGroupId = pmsAttr.getAttrGroupId();
        PmsAttrAttrGroup pmsAttrAttrGroup = new PmsAttrAttrGroup();
        pmsAttrAttrGroup.setAttrGroupId(attrGroupId);
        pmsAttrAttrGroup.setAttrId(pmsAttr.getAttrId());
        if (attrGroupId != null) {
            PmsAttrAttrGroup attrAttrGroup = pmsAttrAttrGroupMapper.selectPmsAttrAttrGroupById(attrGroupId);
            if (attrAttrGroup != null) {
                pmsAttrAttrGroupMapper.updatePmsAttrAttrGroup(pmsAttrAttrGroup);
            } else {
                pmsAttrAttrGroupMapper.insertPmsAttrAttrGroup(pmsAttrAttrGroup);
            }
        }
        return pmsAttrMapper.updatePmsAttr(attr);
    }

    /**
     * 批量删除商品属性
     *
     * @param attrIds 需要删除的商品属性主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrByAttrIds(Long[] attrIds) {
        return pmsAttrMapper.deletePmsAttrByAttrIds(attrIds);
    }

    /**
     * 删除商品属性信息
     *
     * @param attrId 商品属性主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrByAttrId(Long attrId) {
        return pmsAttrMapper.deletePmsAttrByAttrId(attrId);
    }
}
