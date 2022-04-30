package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.product.entity.PmsAttr;
import com.qinweizhao.product.entity.PmsAttrGroup;
import com.qinweizhao.product.entity.vo.PmsAttrGroupWithPmsAttrsVO;
import com.qinweizhao.product.mapper.PmsAttrGroupMapper;
import com.qinweizhao.product.service.IPmsAttrGroupService;
import com.qinweizhao.product.service.IPmsAttrService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 属性分组Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsAttrGroupServiceImpl implements IPmsAttrGroupService {
    @Resource
    private PmsAttrGroupMapper pmsAttrGroupMapper;
    @Resource
    private IPmsAttrService pmsAttrService;

    /**
     * 查询属性分组
     *
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    @Override
    public PmsAttrGroup selectPmsAttrGroupByAttrGroupId(Long attrGroupId) {
        return pmsAttrGroupMapper.selectPmsAttrGroupByAttrGroupId(attrGroupId);
    }

    /**
     * 查询属性分组列表
     *
     * @param pmsAttrGroup 属性分组
     * @return 属性分组
     */
    @Override
    public List<PmsAttrGroup> selectPmsAttrGroupList(PmsAttrGroup pmsAttrGroup) {
        return pmsAttrGroupMapper.selectPmsAttrGroupList(pmsAttrGroup);
    }

    /**
     * 新增属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    @Override
    public int insertPmsAttrGroup(PmsAttrGroup pmsAttrGroup) {
        pmsAttrGroup.setCreateTime(DateUtils.getNowDate());
        return pmsAttrGroupMapper.insertPmsAttrGroup(pmsAttrGroup);
    }

    /**
     * 修改属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    @Override
    public int updatePmsAttrGroup(PmsAttrGroup pmsAttrGroup) {
        pmsAttrGroup.setUpdateTime(DateUtils.getNowDate());
        return pmsAttrGroupMapper.updatePmsAttrGroup(pmsAttrGroup);
    }

    /**
     * 批量删除属性分组
     *
     * @param attrGroupIds 需要删除的属性分组主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrGroupByAttrGroupIds(Long[] attrGroupIds) {
        return pmsAttrGroupMapper.deletePmsAttrGroupByAttrGroupIds(attrGroupIds);
    }

    /**
     * 删除属性分组信息
     *
     * @param attrGroupId 属性分组主键
     * @return 结果
     */
    @Override
    public int deletePmsAttrGroupByAttrGroupId(Long attrGroupId) {
        return pmsAttrGroupMapper.deletePmsAttrGroupByAttrGroupId(attrGroupId);
    }

    @Override
    public List<PmsAttrGroupWithPmsAttrsVO> getPmsAttrGroupWithPmsAttrsByCatelogId(Long categoryId) {
        List<PmsAttrGroup> list = pmsAttrGroupMapper.selectPmsAttrGroupByCategoryId(categoryId);
        //2、查询所有属性
        List<PmsAttrGroupWithPmsAttrsVO> collect = list.stream().map(group -> {
            PmsAttrGroupWithPmsAttrsVO attrsVo = new PmsAttrGroupWithPmsAttrsVO();
            BeanUtils.copyProperties(group, attrsVo);
            List<PmsAttr> attrs = pmsAttrService.getRelationAttr(attrsVo.getAttrGroupId());
            attrsVo.setAttrs(attrs);
            return attrsVo;
        }).collect(Collectors.toList());

        return collect;
    }
}
