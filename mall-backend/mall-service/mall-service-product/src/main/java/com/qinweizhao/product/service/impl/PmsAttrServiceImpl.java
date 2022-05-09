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
import java.util.stream.Collectors;

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
    public PmsAttr getById(Long attrId) {
        return pmsAttrMapper.selectPmsAttrByAttrId(attrId);
    }

    /**
     * 查询商品属性列表
     *
     * @param pmsAttr 商品属性
     * @return 商品属性
     */
    @Override
    public List<PmsAttr> list(PmsAttr pmsAttr) {
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
    public int save(PmsAttrVO pmsAttr) {
        PmsAttr attr = new PmsAttr();
        attr.setCreateTime(DateUtils.getNowDate());
        BeanUtils.copyProperties(pmsAttr, attr);
        int count = pmsAttrMapper.insertPmsAttr(attr);
        Long attrId = attr.getAttrId();
        Long attrGroupId = pmsAttr.getAttrGroupId();
        if (attrId != null && attrGroupId != null) {
            PmsAttrAttrGroup pmsAttrAttrGroup = new PmsAttrAttrGroup();
            pmsAttrAttrGroup.setAttrId(attrId);
            pmsAttrAttrGroup.setAttrGroupId(attrGroupId);
            pmsAttrAttrGroupMapper.insertPmsAttrAttrGroup(pmsAttrAttrGroup);
        }
        return count;
    }

    /**
     * 修改商品属性
     *
     * @param pmsAttr 商品属性
     * @return 结果
     */
    @Override
    public int updateById(PmsAttrVO pmsAttr) {
        PmsAttr attr = new PmsAttr();
        attr.setUpdateTime(DateUtils.getNowDate());
        BeanUtils.copyProperties(pmsAttr, attr);
        Long attrGroupId = pmsAttr.getAttrGroupId();
        Long attrId = attr.getAttrId();
        PmsAttrAttrGroup pmsAttrAttrGroup = new PmsAttrAttrGroup();
        pmsAttrAttrGroup.setAttrGroupId(attrGroupId);
        pmsAttrAttrGroup.setAttrId(pmsAttr.getAttrId());
        if (attrGroupId != null) {
            int count = pmsAttrAttrGroupMapper.selectCountByAttrId(attrId);
            if (count >0) {
                pmsAttrAttrGroupMapper.updateByAttrId(attrGroupId,attrId);
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
    public int removeByIds(Long[] attrIds) {
        return pmsAttrMapper.deletePmsAttrByAttrIds(attrIds);
    }

    /**
     * 删除商品属性信息
     *
     * @param attrId 商品属性主键
     * @return 结果
     */
    @Override
    public int removeById(Long attrId) {
        return pmsAttrMapper.deletePmsAttrByAttrId(attrId);
    }

    @Override
    public List<PmsAttr> getByAttrGroupId(Long attrGroupId) {
        PmsAttrAttrGroup pmsAttrAttrGroup = new PmsAttrAttrGroup();
        pmsAttrAttrGroup.setAttrGroupId(attrGroupId);
        List<PmsAttrAttrGroup> pmsAttrAttrGroups = pmsAttrAttrGroupMapper.selectPmsAttrAttrGroupList(pmsAttrAttrGroup);
        List<Long> attrIds = pmsAttrAttrGroups.stream().map(PmsAttrAttrGroup::getAttrId).collect(Collectors.toList());

        if (attrIds.size() == 0) {
            return null;
        }
        return pmsAttrMapper.selectPmsAttrsByPmsAttrIds(attrIds);
    }
}
