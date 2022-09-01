package com.qinweizhao.product.service;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.product.model.dto.AttrDTO;
import com.qinweizhao.product.model.entity.PmsAttr;
import com.qinweizhao.product.model.param.AttrParam;


/**
 * 商品属性Service接口
 *
 * @author qinweizhao
 * @date 2022-04-25
 */
public interface PmsAttrService extends QwzService<PmsAttr> {

    /**
     * 详情
     *
     * @param attrId 商品属性主键
     * @return 商品属性
     */
    AttrDTO getById(Long attrId);


    /**
     * 分页
     * @param param param
     * @return PageResult
     */
    PageResult<AttrDTO> page(AttrParam param);
}
