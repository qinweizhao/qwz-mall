package com.qinweizhao.product.service.impl;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.impl.QwzServiceImpl;
import com.qinweizhao.product.mapper.PmsBrandMapper;
import com.qinweizhao.product.model.dto.BrandDTO;
import com.qinweizhao.product.model.entity.PmsBrand;
import com.qinweizhao.product.model.params.BrandParam;
import com.qinweizhao.product.service.PmsBrandService;
import org.springframework.stereotype.Service;

/**
 * 品牌Service业务层处理
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
@Service
public class PmsBrandServiceImpl extends QwzServiceImpl<PmsBrandMapper, PmsBrand> implements PmsBrandService {

    @Override
    public PageResult<BrandDTO> page(BrandParam param) {
        return null;
    }

    @Override
    public BrandDTO getById(Long brandId) {
        return null;
    }
}
