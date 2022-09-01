package com.qinweizhao.product.service;


import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.product.model.dto.BrandDTO;
import com.qinweizhao.product.model.entity.PmsBrand;
import com.qinweizhao.product.model.params.BrandParam;

/**
 * 品牌Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsBrandService extends QwzService<PmsBrand> {

    /**
     * 分页
     *
     * @param param param
     * @return PageResult
     */
    PageResult<BrandDTO> page(BrandParam param);

    /**
     * 详情
     *
     * @param brandId brandId
     * @return BrandDTO
     */
    BrandDTO getById(Long brandId);
}
