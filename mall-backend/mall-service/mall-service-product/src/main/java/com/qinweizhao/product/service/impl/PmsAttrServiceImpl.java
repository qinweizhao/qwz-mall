package com.qinweizhao.product.service.impl;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.product.mapper.PmsAttrMapper;
import com.qinweizhao.product.model.dto.AttrDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.param.AttrParam;
import com.qinweizhao.product.service.PmsAttrService;
import org.springframework.stereotype.Service;

/**
 * 商品属性Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
@Service
public class PmsAttrServiceImpl extends QwzServiceImpl<PmsAttrMapper, PmsAttr> implements PmsAttrService {


    @Override
    public AttrDTO getById(Long attrId) {
        return null;
    }

    @Override
    public PageResult<AttrDTO> page(AttrParam param) {
        return null;
    }
}
