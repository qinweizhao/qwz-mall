package com.qinweizhao.product.service;

import com.qinweizhao.component.core.response.PageResult;
import com.qinweizhao.component.mybatis.service.QwzService;
import com.qinweizhao.product.model.dto.SpuDTO;
import com.qinweizhao.product.model.entity.PmsSpu;
import com.qinweizhao.product.model.param.SpuSaveParam;
import com.qinweizhao.product.model.params.SpuParam;

/**
 * spu信息Service接口
 *
 * @author qinweizhao
 * @date 2022-04-11
 */
public interface PmsSpuService extends QwzService<PmsSpu> {


    /**
     * 发布商品
     *
     * @param spuSaveParam pmsSpuSaveVO
     * @return boolean
     */
    boolean saveSpu(SpuSaveParam spuSaveParam);

    /**
     * 更改商品状态（上架或下架）
     *
     * @param spuId spuId
     * @return int
     */
    int updateSpuStatus(Long spuId);

    /**
     * 分页
     * @param param param
     * @return PageResult
     */
    PageResult<SpuDTO> page(SpuParam param);

    SpuDTO getById(Long spuId);
}
