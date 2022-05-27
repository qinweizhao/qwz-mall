package com.qinweizhao.product.service.impl;

import com.qinweizhao.common.core.utils.DateUtils;
import com.qinweizhao.common.security.utils.SecurityUtils;
import com.qinweizhao.product.mapper.PmsAttrGroupMapper;
import com.qinweizhao.product.model.dto.SpuItemAttrGroupDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.entity.PmsAttrGroup;
import com.qinweizhao.product.model.entity.PmsSpuAttrValue;
import com.qinweizhao.product.model.vo.AttrGroupWithPmsAttrsVO;
import com.qinweizhao.product.service.IPmsAttrGroupService;
import com.qinweizhao.product.service.IPmsAttrService;
import com.qinweizhao.product.service.IPmsSkuAttrValueService;
import com.qinweizhao.product.service.IPmsSpuAttrValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private IPmsSpuAttrValueService pmsSpuAttrValueService;

    /**
     * 查询属性分组
     *
     * @param attrGroupId 属性分组主键
     * @return 属性分组
     */
    @Override
    public PmsAttrGroup getById(Long attrGroupId) {
        return pmsAttrGroupMapper.selectPmsAttrGroupByAttrGroupId(attrGroupId);
    }

    /**
     * 查询属性分组列表
     *
     * @param pmsAttrGroup 属性分组
     * @return 属性分组
     */
    @Override
    public List<PmsAttrGroup> list(PmsAttrGroup pmsAttrGroup) {
        return pmsAttrGroupMapper.selectPmsAttrGroupList(pmsAttrGroup);
    }

    /**
     * 新增属性分组
     *
     * @param pmsAttrGroup 属性分组
     * @return 结果
     */
    @Override
    public int save(PmsAttrGroup pmsAttrGroup) {
        pmsAttrGroup.setCreateBy(SecurityUtils.getUsername());
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
    public int updateById(PmsAttrGroup pmsAttrGroup) {
        pmsAttrGroup.setUpdateBy(SecurityUtils.getUsername());
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
    public int removeByIds(Long[] attrGroupIds) {
        return pmsAttrGroupMapper.deletePmsAttrGroupByAttrGroupIds(attrGroupIds);
    }

    /**
     * 删除属性分组信息
     *
     * @param attrGroupId 属性分组主键
     * @return 结果
     */
    @Override
    public int removeById(Long attrGroupId) {
        return pmsAttrGroupMapper.deletePmsAttrGroupByAttrGroupId(attrGroupId);
    }

    @Override
    public List<AttrGroupWithPmsAttrsVO> listAttrGroupWithAttrsByCategoryId(Long categoryId) {
        List<PmsAttrGroup> list = pmsAttrGroupMapper.selectPmsAttrGroupByCategoryId(categoryId);
        //2、查询所有属性
        return list.stream().map(group -> {
            AttrGroupWithPmsAttrsVO attrsVo = new AttrGroupWithPmsAttrsVO();
            BeanUtils.copyProperties(group, attrsVo);
            List<PmsAttr> attrs = pmsAttrService.getByAttrGroupId(attrsVo.getAttrGroupId());
            attrsVo.setAttrs(attrs);
            return attrsVo;
        }).collect(Collectors.toList());
    }

    @Override
    public List<SpuItemAttrGroupDTO> listAttrGroupWithAttrsByCategoryId(Long categoryId, Long spuId) {
        List<AttrGroupWithPmsAttrsVO> attrGroupWithPmsAttrs = this.listAttrGroupWithAttrsByCategoryId(categoryId);
        List<SpuItemAttrGroupDTO> returnList = new ArrayList<>();
        attrGroupWithPmsAttrs.forEach(item -> {
            SpuItemAttrGroupDTO spuItemAttrGroupDTO = new SpuItemAttrGroupDTO();
            spuItemAttrGroupDTO.setName(item.getName());
            List<SpuItemAttrGroupDTO.AttrDTO> attrDTOList = new ArrayList<>();
            List<PmsAttr> attrs = item.getAttrs();
            if (!ObjectUtils.isEmpty(attrs)) {
                attrs.forEach(sourceAttr->{
                    SpuItemAttrGroupDTO.AttrDTO attrDTO = new SpuItemAttrGroupDTO.AttrDTO();
                    attrDTO.setAttrId(sourceAttr.getAttrId());
                    attrDTO.setName(sourceAttr.getName());
                    attrDTOList.add(attrDTO);
                });
                spuItemAttrGroupDTO.setAttrs(attrDTOList);
            }
            returnList.add(spuItemAttrGroupDTO);
        });
        returnList.forEach(item -> {
            List<SpuItemAttrGroupDTO.AttrDTO> attrs = item.getAttrs();
            if (!ObjectUtils.isEmpty(attrs)) {
                attrs.forEach(attr -> {
                    PmsSpuAttrValue spuAttrValue = pmsSpuAttrValueService.getBySpuIdAndAttrId(spuId,attr.getAttrId());
                    if (spuAttrValue!=null){
                        attr.setValue(spuAttrValue.getValue());
                    }
                });
            }
        });
        return returnList;
    }
}
